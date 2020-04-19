package io.xxnjdg.notp.course.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.PageUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.xxnjdg.notp.course.object.data.transfer.CourseListDTO;
import io.xxnjdg.notp.course.object.persistent.Course;
import io.xxnjdg.notp.course.mapper.CourseMapper;
import io.xxnjdg.notp.course.object.view.CourseListVO;
import io.xxnjdg.notp.course.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.utils.constant.CourseIsPutAway;
import io.xxnjdg.notp.utils.constant.DefaultPageValue;
import io.xxnjdg.notp.utils.constant.RowStatus;
import io.xxnjdg.notp.utils.response.PageResult;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

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
}
