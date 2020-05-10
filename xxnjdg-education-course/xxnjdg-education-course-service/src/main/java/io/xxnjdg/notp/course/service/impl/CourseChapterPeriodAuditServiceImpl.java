package io.xxnjdg.notp.course.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.xxnjdg.notp.course.object.business.CourseChapterPeriodAuditBO;
import io.xxnjdg.notp.course.object.convert.CourseChapterPeriodAuditMapStruct;
import io.xxnjdg.notp.course.object.data.transfer.ListCourseChapterPeriodAuditBTO;
import io.xxnjdg.notp.course.object.persistent.CourseChapterPeriodAudit;
import io.xxnjdg.notp.course.mapper.CourseChapterPeriodAuditMapper;
import io.xxnjdg.notp.course.service.CourseChapterPeriodAuditService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.utils.constant.RowStatus;
import org.springframework.stereotype.Service;

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

    @Override
    public List<CourseChapterPeriodAuditBO> listCourseChapterPeriodAudit(ListCourseChapterPeriodAuditBTO listCourseChapterPeriodAuditBTO) {
        LambdaQueryWrapper<CourseChapterPeriodAudit> wrapper = new QueryWrapper<CourseChapterPeriodAudit>()
                .lambda()
                .eq(CourseChapterPeriodAudit::getChapterId, new Long(listCourseChapterPeriodAuditBTO.getChapterId()))
                .eq(CourseChapterPeriodAudit::getStatusId, RowStatus.ENABLE);

        return CourseChapterPeriodAuditMapStruct.INSTANCE.convertD2B(this.list(wrapper));
    }
}
