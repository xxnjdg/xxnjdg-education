package io.xxnjdg.notp.course.mapper;

import io.xxnjdg.notp.course.model.CourseChapterAudit;
import io.xxnjdg.notp.course.model.CourseChapterAuditExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseChapterAuditMapper {
    long countByExample(CourseChapterAuditExample example);

    int deleteByExample(CourseChapterAuditExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CourseChapterAudit record);

    int insertSelective(CourseChapterAudit record);

    List<CourseChapterAudit> selectByExample(CourseChapterAuditExample example);

    CourseChapterAudit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CourseChapterAudit record, @Param("example") CourseChapterAuditExample example);

    int updateByExample(@Param("record") CourseChapterAudit record, @Param("example") CourseChapterAuditExample example);

    int updateByPrimaryKeySelective(CourseChapterAudit record);

    int updateByPrimaryKey(CourseChapterAudit record);
}