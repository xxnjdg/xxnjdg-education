package io.xxnjdg.notp.course.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.course.admin.object.business.CourseUserStudyLogBO;
import io.xxnjdg.notp.course.admin.object.data.transfer.CourseUserStudyLogDTO;
import io.xxnjdg.notp.course.object.persistent.CourseUserStudyLog;
import io.xxnjdg.notp.utils.response.PageResult;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/26 4:12
 */
public interface CourseUserStudyLogAdminService extends IService<CourseUserStudyLog> {
    /**
     * 分页查询列表
     * @param courseUserStudyLogDTO
     * @return
     */
    PageResult<CourseUserStudyLogBO> listCourseUserStudyLogByPage(CourseUserStudyLogDTO courseUserStudyLogDTO);
}
