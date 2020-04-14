package io.xxnjdg.notp.course.mapper;

import io.xxnjdg.notp.course.model.CourseAudit;
import io.xxnjdg.notp.course.model.CourseAuditExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseAuditMapper {
    long countByExample(CourseAuditExample example);

    int deleteByExample(CourseAuditExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CourseAudit record);

    int insertSelective(CourseAudit record);

    List<CourseAudit> selectByExample(CourseAuditExample example);

    CourseAudit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CourseAudit record, @Param("example") CourseAuditExample example);

    int updateByExample(@Param("record") CourseAudit record, @Param("example") CourseAuditExample example);

    int updateByPrimaryKeySelective(CourseAudit record);

    int updateByPrimaryKey(CourseAudit record);
}