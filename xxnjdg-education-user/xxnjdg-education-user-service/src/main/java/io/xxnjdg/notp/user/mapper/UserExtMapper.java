package io.xxnjdg.notp.user.mapper;

import cn.hutool.core.date.DateTime;
import io.xxnjdg.notp.user.object.persistent.UserExt;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户教育信息 Mapper 接口
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-20
 */
public interface UserExtMapper extends BaseMapper<UserExt> {

    /**
     * 分页查询
     * @param statusId
     * @param nickname
     * @param mobile
     * @param beginGmtCreate
     * @param endGmtCreate
     * @param offset
     * @param size
     * @return
     */
    List<UserExt> listUserExtByPage(
            @Param("statusId") Integer statusId,
            @Param("nickname") String nickname,
            @Param("mobile") String mobile,
            @Param("beginGmtCreate") DateTime beginGmtCreate,
            @Param("endGmtCreate") DateTime endGmtCreate,
            @Param("offset") Integer offset,
            @Param("size") Integer size);
}
