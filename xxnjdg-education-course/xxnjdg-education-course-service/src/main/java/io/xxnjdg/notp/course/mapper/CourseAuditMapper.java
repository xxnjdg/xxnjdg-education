package io.xxnjdg.notp.course.mapper;

import io.xxnjdg.notp.course.object.persistent.CourseAudit;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 课程信息-审核 Mapper 接口
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
public interface CourseAuditMapper extends BaseMapper<CourseAudit> {

    /**
     * 分页查询CourseAudit列表
     * @param lecturerUserNo
     * @param auditStatus
     * @param offset
     * @param size
     * @return
     */
    List<CourseAudit> listCourseAuditByPage(
            @Param("lecturerUserNo") Long lecturerUserNo,
            @Param("auditStatus") Integer auditStatus,
            @Param("offset") Integer offset,
            @Param("size")Integer size);
}
