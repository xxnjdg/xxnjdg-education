package io.xxnjdg.notp.course.service;

import io.xxnjdg.notp.course.object.business.CourseChapterPeriodAuditBO;
import io.xxnjdg.notp.course.object.data.transfer.CourseChapterPeriodAuditBTO;
import io.xxnjdg.notp.course.object.data.transfer.ListCourseChapterPeriodAuditBTO;
import io.xxnjdg.notp.course.object.persistent.CourseChapterPeriodAudit;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课时信息-审核 服务类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
public interface CourseChapterPeriodAuditService extends IService<CourseChapterPeriodAudit> {

    /**
     * 查询CourseChapterPeriodAudit列表
     * @param listCourseChapterPeriodAuditBTO
     * @return
     */
    List<CourseChapterPeriodAuditBO> listCourseChapterPeriodAudit(ListCourseChapterPeriodAuditBTO listCourseChapterPeriodAuditBTO);

    /**
     * 插入 CourseChapterPeriodAudit
     * @param courseChapterPeriodAuditBTO
     * @return
     */
    CourseChapterPeriodAuditBO insertCourseChapterPeriodAudit(CourseChapterPeriodAuditBTO courseChapterPeriodAuditBTO);
}
