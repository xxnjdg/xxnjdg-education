package io.xxnjdg.notp.course.mapper;

import io.xxnjdg.notp.course.model.DicList;
import io.xxnjdg.notp.course.model.DicListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DicListMapper {
    long countByExample(DicListExample example);

    int deleteByExample(DicListExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DicList record);

    int insertSelective(DicList record);

    List<DicList> selectByExample(DicListExample example);

    DicList selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DicList record, @Param("example") DicListExample example);

    int updateByExample(@Param("record") DicList record, @Param("example") DicListExample example);

    int updateByPrimaryKeySelective(DicList record);

    int updateByPrimaryKey(DicList record);
}