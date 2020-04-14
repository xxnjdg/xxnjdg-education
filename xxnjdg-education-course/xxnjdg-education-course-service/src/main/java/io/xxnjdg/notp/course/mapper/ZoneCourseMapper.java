package io.xxnjdg.notp.course.mapper;

import io.xxnjdg.notp.course.model.ZoneCourse;
import io.xxnjdg.notp.course.model.ZoneCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZoneCourseMapper {
    long countByExample(ZoneCourseExample example);

    int deleteByExample(ZoneCourseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ZoneCourse record);

    int insertSelective(ZoneCourse record);

    List<ZoneCourse> selectByExample(ZoneCourseExample example);

    ZoneCourse selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ZoneCourse record, @Param("example") ZoneCourseExample example);

    int updateByExample(@Param("record") ZoneCourse record, @Param("example") ZoneCourseExample example);

    int updateByPrimaryKeySelective(ZoneCourse record);

    int updateByPrimaryKey(ZoneCourse record);
}