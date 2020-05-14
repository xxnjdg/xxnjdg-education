package io.xxnjdg.notp.course.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import io.xxnjdg.notp.course.object.business.CourseAuditBO;
import io.xxnjdg.notp.course.object.business.CourseChapterAuditBO;
import io.xxnjdg.notp.course.object.business.CourseChapterPeriodAuditBO;
import io.xxnjdg.notp.course.object.convert.CourseChapterPeriodAuditMapStruct;
import io.xxnjdg.notp.course.object.data.transfer.*;
import io.xxnjdg.notp.course.object.error.CourseChapterPeriodAuditEnum;
import io.xxnjdg.notp.course.object.persistent.CourseChapterPeriodAudit;
import io.xxnjdg.notp.course.mapper.CourseChapterPeriodAuditMapper;
import io.xxnjdg.notp.course.service.CourseAuditService;
import io.xxnjdg.notp.course.service.CourseChapterAuditService;
import io.xxnjdg.notp.course.service.CourseChapterPeriodAuditService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.utils.config.SnowFlakeId;
import io.xxnjdg.notp.utils.constant.AuditStatus;
import io.xxnjdg.notp.utils.constant.RowStatus;
import io.xxnjdg.notp.utils.exception.BaseException;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 课时信息-审核 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
@Service
public class CourseChapterPeriodAuditServiceImpl extends ServiceImpl<CourseChapterPeriodAuditMapper, CourseChapterPeriodAudit> implements CourseChapterPeriodAuditService {

    @Autowired
    private CourseChapterAuditService courseChapterAuditService;

    @Autowired
    private CourseAuditService courseAuditService;

    @Autowired
    private SnowFlakeId snowFlakeId;

    @Override
    public List<CourseChapterPeriodAuditBO> listCourseChapterPeriodAudit(ListCourseChapterPeriodAuditBTO listCourseChapterPeriodAuditBTO) {
        LambdaQueryWrapper<CourseChapterPeriodAudit> wrapper = new QueryWrapper<CourseChapterPeriodAudit>()
                .lambda()
                .eq(CourseChapterPeriodAudit::getChapterId, new Long(listCourseChapterPeriodAuditBTO.getChapterId()))
                .eq(CourseChapterPeriodAudit::getStatusId, RowStatus.ENABLE)
                .orderByAsc(CourseChapterPeriodAudit::getSort)
                .orderByAsc(CourseChapterPeriodAudit::getId);

        return CourseChapterPeriodAuditMapStruct.INSTANCE.convertD2B(this.list(wrapper));
    }

    @Override
    @Transactional
    public Boolean insertCourseChapterPeriodAudit(CourseChapterPeriodAuditBTO courseChapterPeriodAuditBTO) {

        Long chapterId = courseChapterPeriodAuditBTO.getChapterId();

        CourseChapterAuditDTO courseChapterAuditDTO =
                new CourseChapterAuditDTO().setId(chapterId);

        //查询章节
        CourseChapterAuditBO courseChapterAuditBO = courseChapterAuditService
                .getCourseChapterAuditById(courseChapterAuditDTO);

        //查询 CourseAudit
        Long courseId = courseChapterAuditBO.getCourseId();
        CourseAuditDTO courseAuditDTO = new CourseAuditDTO().setId(courseId);
        CourseAuditBO courseAuditBO = courseAuditService.getCourseAuditById(courseAuditDTO);

        if (!ObjectUtil.equal(courseAuditBO.getLecturerUserNo(),courseChapterPeriodAuditBTO.getUserNo())){
            throw new BaseException(CourseChapterPeriodAuditEnum.UPDATE_ERROR);
        }

        //生成主键id
        Snowflake snowflake = IdUtil.createSnowflake(snowFlakeId.getWorkerId(), snowFlakeId.getDataCenterId());
        long id = snowflake.nextId();

        //BTO -> DO
        CourseChapterPeriodAudit courseChapterPeriodAudit =
                CourseChapterPeriodAuditMapStruct.INSTANCE.convertBTO2D(courseChapterPeriodAuditBTO);

        //设置 setIsDoc
        if (StrUtil.isNotBlank(courseChapterPeriodAudit.getDocUrl())){
            courseChapterPeriodAudit.setIsDoc(1);
        }

        //设置 主键 课程id 待审核状态
        courseChapterPeriodAudit
                .setId(id)
                .setCourseId(courseId)
                .setAuditStatus(AuditStatus.PENDING_APPROVAL);

        //插入
        boolean save = this.save(courseChapterPeriodAudit);
        if (!save){
            throw new BaseException(CourseChapterPeriodAuditEnum.UPDATE_ERROR);
        }

        //更新 courseChapterAudit 待审核状态
        courseChapterAuditDTO
                .setAuditStatus(AuditStatus.PENDING_APPROVAL)
                .setGmtModified(LocalDateTime.now());

        courseChapterAuditService.updateCourseChapterAuditById(courseChapterAuditDTO);

        //更新 courseAudit 待审核状态
        courseAuditDTO
                .setGmtModified(LocalDateTime.now())
                .setAuditStatus(AuditStatus.PENDING_APPROVAL);

        courseAuditService.updateCourseAuditById(courseAuditDTO);

        return true;
    }

    @Override
    @Transactional
    public Boolean updateCourseChapterPeriodAudit(CourseChapterPeriodAuditBTO courseChapterPeriodAuditBTO) {

        //查询自己
        CourseChapterPeriodAuditBO courseChapterPeriodAuditBO =
                this.getCourseChapterPeriodAuditById(courseChapterPeriodAuditBTO);

        //查询课程
        CourseAuditDTO courseAuditDTO = new CourseAuditDTO()
                .setId(courseChapterPeriodAuditBO.getCourseId())
                .setAuditStatus(AuditStatus.PENDING_APPROVAL);
        CourseAuditBO courseAuditBO = courseAuditService.getCourseAuditById(courseAuditDTO);

        //判断是否有权限
        if (!ObjectUtil.equal(courseAuditBO.getLecturerUserNo(),courseChapterPeriodAuditBTO.getUserNo())){
            throw new BaseException(CourseChapterPeriodAuditEnum.UPDATE_ERROR);
        }

        if (StrUtil.isNotBlank(courseChapterPeriodAuditBTO.getDocUrl())){
            courseChapterPeriodAuditBTO.setIsDoc(1);
        }else{
            courseChapterPeriodAuditBTO
                    .setDocUrl(null)
                    .setDocName(null)
                    .setIsDoc(0);
        }

        //更新
        this.updateCourseChapterPeriodAuditById(courseChapterPeriodAuditBTO);

        //更新 CourseChapterAudit
        CourseChapterAuditDTO courseChapterAuditDTO = new CourseChapterAuditDTO()
                .setId(courseChapterPeriodAuditBO.getChapterId())
                .setAuditStatus(AuditStatus.PENDING_APPROVAL);

        courseChapterAuditService.updateCourseChapterAuditById(courseChapterAuditDTO);

        //更新 CourseAudit
        courseAuditService.updateCourseAuditById(courseAuditDTO);

        return true;
    }

    @Override
    public CourseChapterPeriodAuditBO getCourseChapterPeriodAuditById(CourseChapterPeriodAuditBTO courseChapterPeriodAuditBTO) {

        LambdaQueryWrapper<CourseChapterPeriodAudit> wrapper = new QueryWrapper<CourseChapterPeriodAudit>()
                .lambda()
                .eq(CourseChapterPeriodAudit::getId, courseChapterPeriodAuditBTO.getId())
                .eq(CourseChapterPeriodAudit::getStatusId, RowStatus.ENABLE);

        CourseChapterPeriodAudit one = this.getOne(wrapper);
        if (one == null){
            throw new BaseException(CourseChapterPeriodAuditEnum.GET_ERROR);
        }

        return CourseChapterPeriodAuditMapStruct.INSTANCE.convertD2B(one);
    }

    @Override
    public Boolean updateCourseChapterPeriodAuditById(CourseChapterPeriodAuditBTO courseChapterPeriodAuditBTO) {

        LambdaUpdateWrapper<CourseChapterPeriodAudit> wrapper = new UpdateWrapper<CourseChapterPeriodAudit>()
                .lambda()
                .eq(CourseChapterPeriodAudit::getId, courseChapterPeriodAuditBTO.getId())
                .eq(CourseChapterPeriodAudit::getStatusId, RowStatus.ENABLE);

        CourseChapterPeriodAudit courseChapterPeriodAudit =
                CourseChapterPeriodAuditMapStruct.INSTANCE.convertBTO2D(courseChapterPeriodAuditBTO);

        boolean update = this.update(courseChapterPeriodAudit, wrapper);

        if (!update){
            throw new BaseException(CourseChapterPeriodAuditEnum.UPDATE_ERROR);
        }

        return true;
    }
}
