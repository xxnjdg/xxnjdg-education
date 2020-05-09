package io.xxnjdg.notp.user.service;

import io.xxnjdg.notp.user.object.business.UserExtBO;
import io.xxnjdg.notp.user.object.data.transfer.UpdateUserExtDTO;
import io.xxnjdg.notp.user.object.data.transfer.UserExtDTO;
import io.xxnjdg.notp.user.object.persistent.UserExt;
import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.user.object.view.UserExtVO;

/**
 * <p>
 * 用户教育信息 服务类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-20
 */
public interface UserExtService extends IService<UserExt> {

    /**
     * ss
     * @param userNo userExtDTO
     * @return UserExtVO
     */
    UserExtBO getUserExtByUserNo(String userNo);

    /**
     * 更新 UserExt 表
     * @param updateUserExtDTO updateUserExtDTO
     * @return UserExtBO
     */
    UserExtBO updateUserExt(UpdateUserExtDTO updateUserExtDTO);
}
