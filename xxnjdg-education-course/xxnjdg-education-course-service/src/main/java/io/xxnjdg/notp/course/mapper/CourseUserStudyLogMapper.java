package io.xxnjdg.notp.course.mapper;

import io.xxnjdg.notp.course.model.CourseUserStudyLog;
import io.xxnjdg.notp.course.model.CourseUserStudyLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseUserStudyLogMapper {
    long countByExample(CourseUserStudyLogExample example);

    int deleteByExample(CourseUserStudyLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CourseUserStudyLog record);

    int insertSelective(CourseUserStudyLog record);

    List<CourseUserStudyLog> selectByExample(CourseUserStudyLogExample example);

    CourseUserStudyLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CourseUserStudyLog record, @Param("example") CourseUserStudyLogExample example);

    int updateByExample(@Param("record") CourseUserStudyLog record, @Param("example") CourseUserStudyLogExample example);

    int updateByPrimaryKeySelective(CourseUserStudyLog record);

    int updateByPrimaryKey(CourseUserStudyLog record);
}