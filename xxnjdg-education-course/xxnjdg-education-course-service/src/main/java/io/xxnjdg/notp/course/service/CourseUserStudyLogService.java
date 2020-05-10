package io.xxnjdg.notp.course.service;

import io.xxnjdg.notp.course.object.business.CourseUserStudyLogBO;
import io.xxnjdg.notp.course.object.data.transfer.ListCourseUserStudyLogDTO;
import io.xxnjdg.notp.course.object.persistent.CourseUserStudyLog;
import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.utils.response.PageResult;

/**
 * <p>
 * 课程用户学习日志 服务类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
public interface CourseUserStudyLogService extends IService<CourseUserStudyLog> {

    /**
     * 分页查询CourseUserStudyLog列表
     * @param listCourseUserStudyLogDTO listCourseUserStudyLogDTO
     * @return CourseUserStudyLogBO
     */
    PageResult<CourseUserStudyLogBO> listCourseUserStudyLogByPage(ListCourseUserStudyLogDTO listCourseUserStudyLogDTO);
}
