package io.xxnjdg.notp.course.mapper;

import io.xxnjdg.notp.course.model.CourseIntroduceAudit;
import io.xxnjdg.notp.course.model.CourseIntroduceAuditExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseIntroduceAuditMapper {
    long countByExample(CourseIntroduceAuditExample example);

    int deleteByExample(CourseIntroduceAuditExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CourseIntroduceAudit record);

    int insertSelective(CourseIntroduceAudit record);

    List<CourseIntroduceAudit> selectByExampleWithBLOBs(CourseIntroduceAuditExample example);

    List<CourseIntroduceAudit> selectByExample(CourseIntroduceAuditExample example);

    CourseIntroduceAudit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CourseIntroduceAudit record, @Param("example") CourseIntroduceAuditExample example);

    int updateByExampleWithBLOBs(@Param("record") CourseIntroduceAudit record, @Param("example") CourseIntroduceAuditExample example);

    int updateByExample(@Param("record") CourseIntroduceAudit record, @Param("example") CourseIntroduceAuditExample example);

    int updateByPrimaryKeySelective(CourseIntroduceAudit record);

    int updateByPrimaryKeyWithBLOBs(CourseIntroduceAudit record);

    int updateByPrimaryKey(CourseIntroduceAudit record);
}