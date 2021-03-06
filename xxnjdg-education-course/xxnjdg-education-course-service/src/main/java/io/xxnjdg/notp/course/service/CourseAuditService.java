package io.xxnjdg.notp.course.service;

import io.xxnjdg.notp.course.object.business.CourseAuditBO;
import io.xxnjdg.notp.course.object.data.transfer.CourseAuditDTO;
import io.xxnjdg.notp.course.object.data.transfer.CourseAuditPutawayDTO;
import io.xxnjdg.notp.course.object.data.transfer.InsertCourseAuditDTO;
import io.xxnjdg.notp.course.object.data.transfer.ListCourseAuditBTO;
import io.xxnjdg.notp.course.object.persistent.CourseAudit;
import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.utils.response.PageResult;

/**
 * <p>
 * 课程信息-审核 服务类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
public interface CourseAuditService extends IService<CourseAudit> {

    /**
     * 分页查询CourseAudit列表
     * @param listCourseAuditBTO
     * @return
     */
    PageResult<CourseAuditBO> listCourseAuditByPage(ListCourseAuditBTO listCourseAuditBTO);

    /**
     * 查询 CourseAudit
     * @param courseAuditDTO
     * @return
     */
    CourseAuditBO getCourseAudit(CourseAuditDTO courseAuditDTO);

    /**
     * 插入
     * @param courseAuditDTO
     * @return
     */
    CourseAuditBO insertCourseAudit(CourseAuditDTO courseAuditDTO);

    /**
     * 更新
     * @param courseAuditDTO
     * @return
     */
    Boolean updateCourseAudit(CourseAuditDTO courseAuditDTO);

    /**
     * 通过 Id 获取 CourseAudit
     * @param courseAuditDTO
     * @return
     */
    CourseAuditBO getCourseAuditById(CourseAuditDTO courseAuditDTO);

    /**
     * 通过 Id 更新
     * @param courseAuditDTO
     * @return
     */
    boolean updateCourseAuditById(CourseAuditDTO courseAuditDTO);
}
