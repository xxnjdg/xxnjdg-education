package io.xxnjdg.notp.system.mapper;

import io.xxnjdg.notp.system.model.MsgUser;
import io.xxnjdg.notp.system.model.MsgUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MsgUserMapper {
    long countByExample(MsgUserExample example);

    int deleteByExample(MsgUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MsgUser record);

    int insertSelective(MsgUser record);

    List<MsgUser> selectByExample(MsgUserExample example);

    MsgUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MsgUser record, @Param("example") MsgUserExample example);

    int updateByExample(@Param("record") MsgUser record, @Param("example") MsgUserExample example);

    int updateByPrimaryKeySelective(MsgUser record);

    int updateByPrimaryKey(MsgUser record);
}