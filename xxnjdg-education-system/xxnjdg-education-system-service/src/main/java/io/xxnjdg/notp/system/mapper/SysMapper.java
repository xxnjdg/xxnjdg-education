package io.xxnjdg.notp.system.mapper;

import io.xxnjdg.notp.system.model.Sys;
import io.xxnjdg.notp.system.model.SysExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysMapper {
    long countByExample(SysExample example);

    int deleteByExample(SysExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Sys record);

    int insertSelective(Sys record);

    List<Sys> selectByExample(SysExample example);

    Sys selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Sys record, @Param("example") SysExample example);

    int updateByExample(@Param("record") Sys record, @Param("example") SysExample example);

    int updateByPrimaryKeySelective(Sys record);

    int updateByPrimaryKey(Sys record);
}