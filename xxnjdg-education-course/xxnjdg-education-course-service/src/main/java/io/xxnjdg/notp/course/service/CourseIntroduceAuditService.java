package io.xxnjdg.notp.course.service;

import io.xxnjdg.notp.course.object.business.CourseIntroduceAuditBO;
import io.xxnjdg.notp.course.object.persistent.CourseIntroduceAudit;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程介绍信息-审核 服务类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
public interface CourseIntroduceAuditService extends IService<CourseIntroduceAudit> {

    /**
     * 插入 CourseIntroduceAudit
     * @param introduce
     * @return
     */
    CourseIntroduceAuditBO insertCourseIntroduceAudit(String introduce);

}
