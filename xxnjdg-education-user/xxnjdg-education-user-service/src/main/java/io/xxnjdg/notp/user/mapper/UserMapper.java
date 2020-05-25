package io.xxnjdg.notp.user.mapper;

import io.xxnjdg.notp.user.object.persistent.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户基本信息 Mapper 接口
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-20
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 分页查询列表
     * @param mobile
     * @param offset
     * @param size
     * @return
     */
    List<User> listUserByPage(
            @Param("mobile") String mobile,
            @Param("offset") Integer offset,
            @Param("size") Integer size);
}
