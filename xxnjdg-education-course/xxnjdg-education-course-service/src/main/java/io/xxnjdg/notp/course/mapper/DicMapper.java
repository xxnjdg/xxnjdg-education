package io.xxnjdg.notp.course.mapper;

import io.xxnjdg.notp.course.model.Dic;
import io.xxnjdg.notp.course.model.DicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DicMapper {
    long countByExample(DicExample example);

    int deleteByExample(DicExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Dic record);

    int insertSelective(Dic record);

    List<Dic> selectByExample(DicExample example);

    Dic selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Dic record, @Param("example") DicExample example);

    int updateByExample(@Param("record") Dic record, @Param("example") DicExample example);

    int updateByPrimaryKeySelective(Dic record);

    int updateByPrimaryKey(Dic record);
}