package io.xxnjdg.notp.system.mapper;

import io.xxnjdg.notp.system.model.SysMenuRole;
import io.xxnjdg.notp.system.model.SysMenuRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysMenuRoleMapper {
    long countByExample(SysMenuRoleExample example);

    int deleteByExample(SysMenuRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysMenuRole record);

    int insertSelective(SysMenuRole record);

    List<SysMenuRole> selectByExample(SysMenuRoleExample example);

    SysMenuRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysMenuRole record, @Param("example") SysMenuRoleExample example);

    int updateByExample(@Param("record") SysMenuRole record, @Param("example") SysMenuRoleExample example);

    int updateByPrimaryKeySelective(SysMenuRole record);

    int updateByPrimaryKey(SysMenuRole record);
}