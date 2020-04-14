package io.xxnjdg.notp.course.mapper;

import io.xxnjdg.notp.course.model.CourseChapterPeriod;
import io.xxnjdg.notp.course.model.CourseChapterPeriodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseChapterPeriodMapper {
    long countByExample(CourseChapterPeriodExample example);

    int deleteByExample(CourseChapterPeriodExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CourseChapterPeriod record);

    int insertSelective(CourseChapterPeriod record);

    List<CourseChapterPeriod> selectByExample(CourseChapterPeriodExample example);

    CourseChapterPeriod selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CourseChapterPeriod record, @Param("example") CourseChapterPeriodExample example);

    int updateByExample(@Param("record") CourseChapterPeriod record, @Param("example") CourseChapterPeriodExample example);

    int updateByPrimaryKeySelective(CourseChapterPeriod record);

    int updateByPrimaryKey(CourseChapterPeriod record);
}