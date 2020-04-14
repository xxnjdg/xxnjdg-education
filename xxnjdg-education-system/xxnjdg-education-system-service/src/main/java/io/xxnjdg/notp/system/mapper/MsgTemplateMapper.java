package io.xxnjdg.notp.system.mapper;

import io.xxnjdg.notp.system.model.MsgTemplate;
import io.xxnjdg.notp.system.model.MsgTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MsgTemplateMapper {
    long countByExample(MsgTemplateExample example);

    int deleteByExample(MsgTemplateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MsgTemplate record);

    int insertSelective(MsgTemplate record);

    List<MsgTemplate> selectByExample(MsgTemplateExample example);

    MsgTemplate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MsgTemplate record, @Param("example") MsgTemplateExample example);

    int updateByExample(@Param("record") MsgTemplate record, @Param("example") MsgTemplateExample example);

    int updateByPrimaryKeySelective(MsgTemplate record);

    int updateByPrimaryKey(MsgTemplate record);
}