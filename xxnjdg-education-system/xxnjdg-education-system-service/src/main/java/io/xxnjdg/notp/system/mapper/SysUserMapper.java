package io.xxnjdg.notp.system.mapper;

import io.xxnjdg.notp.system.object.persistent.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 后台用户信息 Mapper 接口
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 分页查询SysUser列表
     * @param mobile
     * @param offset
     * @param size
     * @return
     */
    List<SysUser> listSysUserByPage(
            @Param("mobile") String mobile,
            @Param("offset") Integer offset,
            @Param("size") Integer size);
}
