package io.xxnjdg.notp.course.mapper;

import io.xxnjdg.notp.course.model.Adv;
import io.xxnjdg.notp.course.model.AdvExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdvMapper {
    long countByExample(AdvExample example);

    int deleteByExample(AdvExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Adv record);

    int insertSelective(Adv record);

    List<Adv> selectByExample(AdvExample example);

    Adv selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Adv record, @Param("example") AdvExample example);

    int updateByExample(@Param("record") Adv record, @Param("example") AdvExample example);

    int updateByPrimaryKeySelective(Adv record);

    int updateByPrimaryKey(Adv record);
}