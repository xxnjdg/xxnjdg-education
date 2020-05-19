package io.xxnjdg.notp.system.mapper;

import io.xxnjdg.notp.system.object.persistent.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色信息 Mapper 接口
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 分页查询SysRole列表
     * @param roleName
     * @param statusId
     * @param offset
     * @param size
     * @return
     */
    List<SysRole> listSysRoleByPage(
            @Param("roleName") String roleName,
            @Param("statusId") Integer statusId,
            @Param("offset") Integer offset,
            @Param("size") Integer size);
}
