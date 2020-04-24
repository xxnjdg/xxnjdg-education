package io.xxnjdg.notp.user.service;

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
     * @param userExtDTO userExtDTO
     * @return UserExtVO
     */
    UserExtVO postUserExt(UserExtDTO userExtDTO);
}
