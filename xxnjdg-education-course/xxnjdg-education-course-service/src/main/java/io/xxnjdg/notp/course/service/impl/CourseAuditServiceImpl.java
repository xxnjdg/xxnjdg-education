package io.xxnjdg.notp.course.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import io.xxnjdg.notp.course.object.business.CourseAuditBO;
import io.xxnjdg.notp.course.object.business.CourseIntroduceAuditBO;
import io.xxnjdg.notp.course.object.convert.CourseAuditMapStruct;
import io.xxnjdg.notp.course.object.data.transfer.*;
import io.xxnjdg.notp.course.object.error.CourseAuditEnum;
import io.xxnjdg.notp.course.object.persistent.CourseAudit;
import io.xxnjdg.notp.course.mapper.CourseAuditMapper;
import io.xxnjdg.notp.course.service.CourseAuditService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.course.service.CourseIntroduceAuditService;
import io.xxnjdg.notp.utils.config.SnowFlakeId;
import io.xxnjdg.notp.utils.constant.AuditStatus;
import io.xxnjdg.notp.utils.constant.CourseIsPutAway;
import io.xxnjdg.notp.utils.constant.RowStatus;
import io.xxnjdg.notp.utils.custom.utils.PageObjectUtil;
import io.xxnjdg.notp.utils.exception.BaseException;
import io.xxnjdg.notp.utils.objects.PageObject;
import io.xxnjdg.notp.utils.response.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 课程信息-审核 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
@Service
@Slf4j
public class CourseAuditServiceImpl extends ServiceImpl<CourseAuditMapper, CourseAudit> implements CourseAuditService {

    @Autowired
    private CourseIntroduceAuditService courseIntroduceAuditService;

    @Autowired
    private SnowFlakeId snowFlakeId;

    @Override
    public CourseAuditBO getCourseAudit(CourseAuditDTO courseAuditDTO) {
        CourseAuditBO courseAuditBO = this.getCourseAuditById(courseAuditDTO);

        CourseIntroduceAuditBO courseIntroduceAuditBO = courseIntroduceAuditService
                .getCourseIntroduceAuditById(new CourseIntroduceAuditDTO()
                        .setId(courseAuditBO.getIntroduceId()));

        return courseAuditBO.setIntroduce(courseIntroduceAuditBO.getIntroduce());
    }

    @Override
    public PageResult<CourseAuditBO> listCourseAuditByPage(ListCourseAuditBTO listCourseAuditBTO) {

        Long lecturerUserNo = new Long(listCourseAuditBTO.getLecturerUserNo());
        Integer auditStatus = null;
        PageResult<CourseAuditBO> result = new PageResult<>();

        //算总数
        LambdaQueryWrapper<CourseAudit> wrapper = new QueryWrapper<CourseAudit>()
                .lambda()
                .eq(CourseAudit::getLecturerUserNo,lecturerUserNo)
                .eq(CourseAudit::getStatusId, RowStatus.ENABLE);

        if (listCourseAuditBTO.getAuditStatus() != null){
            auditStatus = new Integer(listCourseAuditBTO.getAuditStatus());
            wrapper.eq(CourseAudit::getAuditStatus,auditStatus);
        }else {
            wrapper.lt(CourseAudit::getAuditStatus,3);
        }

        int count = this.count(wrapper);

        //条数为0
        if (count == 0){
            return result;
        }

        PageObject pageObject = PageObjectUtil.countPageOffsetAndSize(
                listCourseAuditBTO.getPageCurrent(), listCourseAuditBTO.getPageSize(), count);

        //查询
        List<CourseAudit> courseAudits =
                this.baseMapper.listCourseAuditByPage(lecturerUserNo, auditStatus,pageObject.getOffset(), pageObject.getSize());

        List<CourseAuditBO> courseAuditBOS = CourseAuditMapStruct.INSTANCE.convertD2B(courseAudits);

        // TODO: 20-5-9 xxnjdg 没写完
        if (courseAuditBOS!=null){
            courseAuditBOS.forEach(courseAuditBO -> {
                courseAuditBO.setIsDelete(1);
                if (ObjectUtil.equal(courseAuditBO.getAuditStatus(),1)){
                    courseAuditBO.setIsDelete(0);
                }
            });
            result.setCurrentListSize((long) courseAuditBOS.size());
        }

        return result
                .setCurrentList(courseAuditBOS)
                .setTotalCount((long) count)
                .setTotalPage(pageObject.getTotalPage())
                .setCurrentPage(pageObject.getCurrentPage());
    }

    @Override
    @Transactional
    public CourseAuditBO insertCourseAudit(CourseAuditDTO courseAuditDTO) {
        // 如果课程收费，价格不能为空
        if (ObjectUtil.equal(courseAuditDTO.getIsFree(),0) && courseAuditDTO.getCourseOriginal() == null){
            throw new BaseException(CourseAuditEnum.INSERT_ERROR);
        }

        //插入简介
        CourseIntroduceAuditBO courseIntroduceAuditBO =
                courseIntroduceAuditService.insertCourseIntroduceAudit(
                        new CourseIntroduceAuditDTO()
                                .setIntroduce(courseAuditDTO.getIntroduce()));
        CourseAudit courseAudit = CourseAuditMapStruct.INSTANCE.convertBTO2D(courseAuditDTO);

        if (ObjectUtil.equal(courseAudit.getIsFree(),1)){
            courseAudit.setCourseOriginal(BigDecimal.valueOf(0));
        }

        //生成主键id
        Snowflake snowflake = IdUtil.createSnowflake(snowFlakeId.getWorkerId(), snowFlakeId.getDataCenterId());
        long id = snowflake.nextId();

        courseAudit
                .setId(id)
                .setIntroduceId(courseIntroduceAuditBO.getId())
                .setCourseDiscount(courseAudit.getCourseOriginal());

        //插入
        boolean save = this.save(courseAudit);

        if (!save){
            throw new BaseException(CourseAuditEnum.INSERT_ERROR);
        }

        return CourseAuditMapStruct.INSTANCE.convertD2B(courseAudit);
    }



    @Override
    @Transactional
    public Boolean updateCourseAudit(CourseAuditDTO courseAuditDTO) {

        // 如果课程收费，价格不能为空
        if (ObjectUtil.equal(courseAuditDTO.getIsFree(),0) && courseAuditDTO.getCourseOriginal() == null){
            throw new BaseException(CourseAuditEnum.UPDATE_ERROR);
        }

        //查询课程 和 参数 lecturerUserNo 是否一致
        CourseAuditBO courseAuditBO = this.getCourseAuditById(
                new CourseAuditDTO().setId(courseAuditDTO.getId()));

        if (!ObjectUtil.equal(courseAuditBO.getLecturerUserNo(),courseAuditDTO.getLecturerUserNo())){
            throw new BaseException(CourseAuditEnum.UPDATE_ERROR);
        }

        //更新描述
        courseIntroduceAuditService.updateCourseIntroduceAudit(
                new CourseIntroduceAuditDTO()
                        .setId(courseAuditBO.getIntroduceId())
                        .setIntroduce(courseAuditDTO.getIntroduce()));

        if (ObjectUtil.equal(courseAuditDTO.getIsFree(),1)){
            courseAuditDTO.setCourseOriginal(String.valueOf(0));
        }

        if (courseAuditDTO.getCategoryId1() == null) {
            courseAuditDTO.setCategoryId1(0L);
        }
        if (courseAuditDTO.getCategoryId2() == null) {
            courseAuditDTO.setCategoryId2(0L);
        }
        if (courseAuditDTO.getCategoryId3() == null) {
            courseAuditDTO.setCategoryId3(0L);
        }

        courseAuditDTO
                .setGmtModified(LocalDateTime.now())
                .setAuditStatus(0)
                .setCourseDiscount(new BigDecimal(courseAuditDTO.getCourseOriginal()));

        log.info(courseAuditDTO.toString());

        //更新
        boolean update = this.updateCourseAuditById(courseAuditDTO);

        if (!update){
            throw new BaseException(CourseAuditEnum.UPDATE_ERROR);
        }

        return true;
    }

    @Override
    public CourseAuditBO getCourseAuditById(CourseAuditDTO courseAuditDTO) {
        LambdaQueryWrapper<CourseAudit> wrapper = new QueryWrapper<CourseAudit>()
                .lambda()
                .eq(CourseAudit::getStatusId, RowStatus.ENABLE)
                .eq(CourseAudit::getId, courseAuditDTO.getId());

        CourseAudit courseAudit = this.getOne(wrapper);
        if (courseAudit == null){
            throw new BaseException(CourseAuditEnum.GET_ERROR);
        }

        return CourseAuditMapStruct.INSTANCE.convertD2B(courseAudit);
    }

    @Override
    public boolean updateCourseAuditById(CourseAuditDTO courseAuditDTO) {

        LambdaUpdateWrapper<CourseAudit> wrapper = new UpdateWrapper<CourseAudit>()
                .lambda()
                .eq(CourseAudit::getStatusId, RowStatus.ENABLE)
                .eq(CourseAudit::getId, courseAuditDTO.getId());

        CourseAudit courseAudit =
                CourseAuditMapStruct.INSTANCE.convertBTO2D(courseAuditDTO);


        boolean update = this.update(courseAudit, wrapper);
        if (!update){
            throw new BaseException(CourseAuditEnum.GET_ERROR);
        }
        return true;
    }
}
