package io.xxnjdg.notp.course.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
import io.xxnjdg.notp.utils.constant.RowStatus;
import io.xxnjdg.notp.utils.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotBlank;
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
                .orderByAsc(CourseChapterPeriodAudit::getSort,CourseChapterPeriodAudit::getId);

        return CourseChapterPeriodAuditMapStruct.INSTANCE.convertD2B(this.list(wrapper));
    }

    @Override
    @Transactional
    public CourseChapterPeriodAuditBO insertCourseChapterPeriodAudit(CourseChapterPeriodAuditBTO courseChapterPeriodAuditBTO) {

        String chapterId = courseChapterPeriodAuditBTO.getChapterId();

        CourseChapterAuditDTO courseChapterAuditDTO =
                new CourseChapterAuditDTO().setId(chapterId);

        //查询章节
        CourseChapterAuditBO courseChapterAuditBO = courseChapterAuditService
                .getCourseChapterAuditById(courseChapterAuditDTO);

        //查询 CourseAudit
        String id = String.valueOf(courseChapterAuditBO.getCourseId());
        CourseAuditDTO courseAuditDTO = new CourseAuditDTO().setId(id);
        CourseAuditBO courseAuditBO = courseAuditService.getCourseAuditById(courseAuditDTO);

        if (!ObjectUtil.equal(courseAuditBO.getLecturerUserNo(),courseChapterPeriodAuditBTO.getUserNo())){
            throw new BaseException(CourseChapterPeriodAuditEnum.UPDATE_ERROR);
        }

        //设置
        CourseChapterPeriodAudit courseChapterPeriodAudit =
                CourseChapterPeriodAuditMapStruct.INSTANCE.convertBTO2D(courseChapterPeriodAuditBTO);

        if (StrUtil.isNotBlank(courseChapterPeriodAudit.getDocUrl())){
            courseChapterPeriodAudit.setIsDoc(1);
        }

        //生成主键id
        Snowflake snowflake = IdUtil.createSnowflake(snowFlakeId.getWorkerId(), snowFlakeId.getDataCenterId());
        long cid = snowflake.nextId();

        courseChapterPeriodAudit
                .setId(cid)
                .setCourseId(courseChapterAuditBO.getCourseId())
                .setAuditStatus(0);

        //更新
        boolean save = this.save(courseChapterPeriodAudit);
        if (!save){
            throw new BaseException(CourseChapterPeriodAuditEnum.UPDATE_ERROR);
        }

        courseChapterAuditDTO
                .setAuditStatus(0)
                .setGmtModified(LocalDateTime.now());

        courseChapterAuditService.updateCourseChapterAuditById(courseChapterAuditDTO);

        courseAuditDTO.setAuditStatus(0);
        courseAuditService.updateCourseAuditById(courseAuditDTO);

        return null;
    }
}
