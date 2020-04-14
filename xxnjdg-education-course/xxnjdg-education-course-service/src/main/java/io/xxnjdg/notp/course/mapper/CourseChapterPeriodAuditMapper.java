package io.xxnjdg.notp.course.mapper;

import io.xxnjdg.notp.course.model.CourseChapterPeriodAudit;
import io.xxnjdg.notp.course.model.CourseChapterPeriodAuditExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseChapterPeriodAuditMapper {
    long countByExample(CourseChapterPeriodAuditExample example);

    int deleteByExample(CourseChapterPeriodAuditExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CourseChapterPeriodAudit record);

    int insertSelective(CourseChapterPeriodAudit record);

    List<CourseChapterPeriodAudit> selectByExample(CourseChapterPeriodAuditExample example);

    CourseChapterPeriodAudit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CourseChapterPeriodAudit record, @Param("example") CourseChapterPeriodAuditExample example);

    int updateByExample(@Param("record") CourseChapterPeriodAudit record, @Param("example") CourseChapterPeriodAuditExample example);

    int updateByPrimaryKeySelective(CourseChapterPeriodAudit record);

    int updateByPrimaryKey(CourseChapterPeriodAudit record);
}