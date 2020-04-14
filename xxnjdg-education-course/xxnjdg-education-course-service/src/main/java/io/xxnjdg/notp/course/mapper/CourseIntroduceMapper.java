package io.xxnjdg.notp.course.mapper;

import io.xxnjdg.notp.course.model.CourseIntroduce;
import io.xxnjdg.notp.course.model.CourseIntroduceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseIntroduceMapper {
    long countByExample(CourseIntroduceExample example);

    int deleteByExample(CourseIntroduceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CourseIntroduce record);

    int insertSelective(CourseIntroduce record);

    List<CourseIntroduce> selectByExampleWithBLOBs(CourseIntroduceExample example);

    List<CourseIntroduce> selectByExample(CourseIntroduceExample example);

    CourseIntroduce selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CourseIntroduce record, @Param("example") CourseIntroduceExample example);

    int updateByExampleWithBLOBs(@Param("record") CourseIntroduce record, @Param("example") CourseIntroduceExample example);

    int updateByExample(@Param("record") CourseIntroduce record, @Param("example") CourseIntroduceExample example);

    int updateByPrimaryKeySelective(CourseIntroduce record);

    int updateByPrimaryKeyWithBLOBs(CourseIntroduce record);

    int updateByPrimaryKey(CourseIntroduce record);
}