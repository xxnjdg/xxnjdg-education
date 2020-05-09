package io.xxnjdg.notp.course.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.PageUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.xxnjdg.notp.course.object.business.*;
import io.xxnjdg.notp.course.object.convert.CourseBOToDetailBO;
import io.xxnjdg.notp.course.object.convert.CourseDOToBO;
import io.xxnjdg.notp.course.object.convert.CourseIntroduceDOToBO;
import io.xxnjdg.notp.course.object.data.transfer.CourseDetailDTO;
import io.xxnjdg.notp.course.object.data.transfer.CourseListDTO;
import io.xxnjdg.notp.course.object.data.transfer.UserCoursePaymentStatusDTO;
import io.xxnjdg.notp.course.object.error.CourseEnum;
import io.xxnjdg.notp.course.object.persistent.Course;
import io.xxnjdg.notp.course.mapper.CourseMapper;
import io.xxnjdg.notp.course.object.persistent.OrderInfo;
import io.xxnjdg.notp.course.object.view.CourseChapterLevelVO;
import io.xxnjdg.notp.course.object.view.CourseDetailVO;
import io.xxnjdg.notp.course.object.view.CourseListVO;
import io.xxnjdg.notp.course.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.user.apis.LecturerControllerApi;
import io.xxnjdg.notp.user.object.view.LecturerVO;
import io.xxnjdg.notp.utils.constant.CourseIsPutAway;
import io.xxnjdg.notp.utils.constant.DefaultPageValue;
import io.xxnjdg.notp.utils.constant.HttpStatus;
import io.xxnjdg.notp.utils.constant.RowStatus;
import io.xxnjdg.notp.utils.exception.BaseException;
import io.xxnjdg.notp.utils.response.PageResult;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * <p>
 * 课程信息 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Resource(name = "courseThreadPoolExecutorService")
    private ThreadPoolExecutor courseThreadPoolExecutorService;

    @Autowired
    private LecturerControllerApi lecturerControllerApi;

    @Autowired
    private OrderInfoService orderInfoService;

    @Autowired
    private CourseChapterService courseChapterService;

    @Autowired
    private CourseIntroduceService courseIntroduceService;

    @Autowired
    private CourseChapterPeriodService courseChapterPeriodService;


    @Override
    public PageResult<CourseListVO> postCourseListByPage(CourseListDTO courseListDTO) {

        // 设置当前页默认值
        Integer pageCurrent = courseListDTO.getPageCurrent();
        if (pageCurrent == null || pageCurrent < DefaultPageValue.MIN) {
            courseListDTO.setPageCurrent(DefaultPageValue.DEFAULT_CURRENT_PAGE);
        }

        // 设置列表数默认值
        Integer pageSize = courseListDTO.getPageSize();
        if (pageSize == null || pageSize < DefaultPageValue.MIN || pageSize > DefaultPageValue.DEFAULT_CURRENT_LIST_SIZE) {
            courseListDTO.setPageSize(DefaultPageValue.DEFAULT_CURRENT_LIST_SIZE);
        }

        // 设置各种条件
        // 是否上架 是否启用
        LambdaQueryWrapper<Course> lambda = new QueryWrapper<Course>().lambda();
        lambda.eq(Course::getStatusId, RowStatus.ENABLE)
                .eq(Course::getIsPutaway, CourseIsPutAway.PUT_ON_SHELVES);


        // 是否一级分类
        if (courseListDTO.getCategoryId1() != null){
            lambda.eq(Course::getCategoryId1,courseListDTO.getCategoryId1());
        }

        // 是否二级分类
        if (courseListDTO.getCategoryId2() != null){
            lambda.eq(Course::getCategoryId2,courseListDTO.getCategoryId2());
        }

        // 是否三级分类
        if (courseListDTO.getCategoryId3() != null){
            lambda.eq(Course::getCategoryId3,courseListDTO.getCategoryId3());
        }

        // 是否收费
        if (courseListDTO.getIsFree() != null){
            lambda.eq(Course::getIsFree,courseListDTO.getIsFree());
        }

        // 排序
        lambda.orderByDesc(Course::getSort);

        // 查询
        Page<Course> page = this.page(new Page<>(courseListDTO.getPageCurrent(), courseListDTO.getPageSize()), lambda);

        // PO -> VO
        List<Course> records = page.getRecords();
        ArrayList<CourseListVO> courseListVOS = new ArrayList<>();

        records.forEach(course -> {
            courseListVOS.add(BeanUtil.copyProperties(course,CourseListVO.class));
        });

        // 返回封装好的对象
        return new PageResult<>(courseListVOS,page.getPages(),page.getTotal(),page.getCurrent(),page.getSize());
    }

    @Override
    public CourseDetailBO getCourseDetail(CourseDetailDTO courseDetailDTO) {

        Long courseId = Long.valueOf(courseDetailDTO.getCourseId());
        Long userNo = courseDetailDTO.getUserNo();


        //获取 Course
        CourseBO courseBO = this.getCourseById(courseId);
        //转换
        CourseDetailBO courseDetailBO =
                CourseBOToDetailBO.INSTANCE.convert(courseBO);

        //获取 CourseIntroduce
        Long introduceId = courseBO.getIntroduceId();
        CourseIntroduceBO courseIntroduceBO =
                courseIntroduceService.getCourseIntroduceById(introduceId);

        //设置introduce
        courseDetailBO.setIntroduce(courseIntroduceBO.getIntroduce());

        courseDetailBO.setIsPay(0);

        if (userNo != null){
            //设置是否付费
            Integer isFree = courseBO.getIsFree();
            courseDetailBO.setIsPay(1);

            if (isFree.equals(0)){
                OrderInfoBO userCoursePaymentStatus = orderInfoService.getUserCoursePaymentStatus(
                        new UserCoursePaymentStatusDTO()
                                .setCourseId(courseId)
                                .setUserNo(userNo)
                                .setOrderStatus(2));
                if (userCoursePaymentStatus == null){
                    courseDetailBO.setIsPay(0);
                }
            }
        }

        //设置课程
        List<CourseChapterBO> courseChapterBOList = courseChapterService.listCourseChapterByCourseId(courseId);
        if (courseChapterBOList!=null){
            courseChapterBOList.forEach(courseChapterBO -> {
                List<CourseChapterPeriodBO> courseChapterPeriodBOList =
                        courseChapterPeriodService.listCourseChapterPeriodByChapterId(courseChapterBO.getId());
                courseChapterBO.setCourseChapterPeriodVOS(courseChapterPeriodBOList);
            });
        }
        courseDetailBO.setChapterList(courseChapterBOList);

        ResponseResult<LecturerVO> lecturerByLecturerUserNo =
                lecturerControllerApi.getLecturerByLecturerUserNo(courseDetailBO.getLecturerUserNo());


        if (!ObjectUtil.equal(lecturerByLecturerUserNo.getStatus(),HttpStatus.SUCCESS.getStatus()) || lecturerByLecturerUserNo.getData() == null){
            throw new BaseException(lecturerByLecturerUserNo.getStatus(),lecturerByLecturerUserNo.getStatusText());
        }

        return courseDetailBO.setLecturer(lecturerByLecturerUserNo.getData());
    }

    @Override
    public CourseBO getCourseById(Long id) {
        LambdaQueryWrapper<Course> queryWrapper = new QueryWrapper<Course>()
                .lambda()
                .eq(Course::getId, id)
                .eq(Course::getStatusId, RowStatus.ENABLE)
                .eq(Course::getIsPutaway, 1);

        Course one = this.getOne(queryWrapper);
        if (one == null){
            throw new BaseException(CourseEnum.COURSE_NO_ERROR);
        }
        return CourseDOToBO.INSTANCE.convert(one);
    }
}
