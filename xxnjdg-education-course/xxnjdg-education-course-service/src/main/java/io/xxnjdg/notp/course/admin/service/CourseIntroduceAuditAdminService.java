package io.xxnjdg.notp.course.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.course.admin.object.data.transfer.CourseIntroduceAuditDTO;
import io.xxnjdg.notp.course.object.persistent.CourseIntroduceAudit;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/22 12:39
 */
public interface CourseIntroduceAuditAdminService extends IService<CourseIntroduceAudit> {

    /**
     * 更新
     * @param courseIntroduceAuditDTO
     * @return
     */
    Boolean updateCourseIntroduceAuditById(CourseIntroduceAuditDTO courseIntroduceAuditDTO);


}
