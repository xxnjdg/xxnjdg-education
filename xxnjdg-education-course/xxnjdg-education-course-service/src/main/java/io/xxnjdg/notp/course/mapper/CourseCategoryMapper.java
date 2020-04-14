package io.xxnjdg.notp.course.mapper;

import io.xxnjdg.notp.course.model.CourseCategory;
import io.xxnjdg.notp.course.model.CourseCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseCategoryMapper {
    long countByExample(CourseCategoryExample example);

    int deleteByExample(CourseCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CourseCategory record);

    int insertSelective(CourseCategory record);

    List<CourseCategory> selectByExample(CourseCategoryExample example);

    CourseCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CourseCategory record, @Param("example") CourseCategoryExample example);

    int updateByExample(@Param("record") CourseCategory record, @Param("example") CourseCategoryExample example);

    int updateByPrimaryKeySelective(CourseCategory record);

    int updateByPrimaryKey(CourseCategory record);
}