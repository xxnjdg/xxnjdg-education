package io.xxnjdg.notp.course.mapper;

import io.xxnjdg.notp.course.model.CourseRecommend;
import io.xxnjdg.notp.course.model.CourseRecommendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseRecommendMapper {
    long countByExample(CourseRecommendExample example);

    int deleteByExample(CourseRecommendExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CourseRecommend record);

    int insertSelective(CourseRecommend record);

    List<CourseRecommend> selectByExample(CourseRecommendExample example);

    CourseRecommend selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CourseRecommend record, @Param("example") CourseRecommendExample example);

    int updateByExample(@Param("record") CourseRecommend record, @Param("example") CourseRecommendExample example);

    int updateByPrimaryKeySelective(CourseRecommend record);

    int updateByPrimaryKey(CourseRecommend record);
}