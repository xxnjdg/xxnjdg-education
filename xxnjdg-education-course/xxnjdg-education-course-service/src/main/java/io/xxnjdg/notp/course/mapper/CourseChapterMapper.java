package io.xxnjdg.notp.course.mapper;

import io.xxnjdg.notp.course.model.CourseChapter;
import io.xxnjdg.notp.course.model.CourseChapterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseChapterMapper {
    long countByExample(CourseChapterExample example);

    int deleteByExample(CourseChapterExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CourseChapter record);

    int insertSelective(CourseChapter record);

    List<CourseChapter> selectByExample(CourseChapterExample example);

    CourseChapter selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CourseChapter record, @Param("example") CourseChapterExample example);

    int updateByExample(@Param("record") CourseChapter record, @Param("example") CourseChapterExample example);

    int updateByPrimaryKeySelective(CourseChapter record);

    int updateByPrimaryKey(CourseChapter record);
}