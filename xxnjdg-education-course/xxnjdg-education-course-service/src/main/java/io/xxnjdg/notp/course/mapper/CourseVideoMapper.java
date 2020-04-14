package io.xxnjdg.notp.course.mapper;

import io.xxnjdg.notp.course.model.CourseVideo;
import io.xxnjdg.notp.course.model.CourseVideoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseVideoMapper {
    long countByExample(CourseVideoExample example);

    int deleteByExample(CourseVideoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CourseVideo record);

    int insertSelective(CourseVideo record);

    List<CourseVideo> selectByExample(CourseVideoExample example);

    CourseVideo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CourseVideo record, @Param("example") CourseVideoExample example);

    int updateByExample(@Param("record") CourseVideo record, @Param("example") CourseVideoExample example);

    int updateByPrimaryKeySelective(CourseVideo record);

    int updateByPrimaryKey(CourseVideo record);
}