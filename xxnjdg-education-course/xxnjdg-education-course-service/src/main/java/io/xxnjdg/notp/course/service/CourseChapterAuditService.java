package io.xxnjdg.notp.course.service;

import io.xxnjdg.notp.course.object.business.CourseChapterAuditBO;
import io.xxnjdg.notp.course.object.data.transfer.CourseChapterAuditDTO;
import io.xxnjdg.notp.course.object.data.transfer.InsertCourseChapterAuditDTO;
import io.xxnjdg.notp.course.object.data.transfer.ListCourseChapterAuditDTO;
import io.xxnjdg.notp.course.object.persistent.CourseChapterAudit;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 章节信息-审核 服务类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
public interface CourseChapterAuditService extends IService<CourseChapterAudit> {

    /**
     * 查询 CourseChapterAudit 列表
     * @param listCourseChapterAuditDTO
     * @return
     */
    List<CourseChapterAuditBO> listCourseChapterAudit(ListCourseChapterAuditDTO listCourseChapterAuditDTO);

    /**
     * 插入 CourseChapterAudit
     * @param insertCourseChapterAuditDTO
     * @return
     */
    CourseChapterAuditBO insertCourseChapterAudit(InsertCourseChapterAuditDTO insertCourseChapterAuditDTO);

    /**
     * 更新 CourseChapterAudit
     * @param courseChapterAuditDTO
     * @return
     */
    Boolean updateCourseChapterAudit(CourseChapterAuditDTO courseChapterAuditDTO);

    /**
     * 通过 id 更新 CourseChapterAudit
     * @param courseChapterAuditDTO
     * @return
     */
    Boolean updateCourseChapterAuditById(CourseChapterAuditDTO courseChapterAuditDTO);

    /**
     * 通过 id 获取 CourseChapterAudit
     * @param courseChapterAuditDTO
     * @return
     */
    CourseChapterAuditBO getCourseChapterAuditById(CourseChapterAuditDTO courseChapterAuditDTO);
}
