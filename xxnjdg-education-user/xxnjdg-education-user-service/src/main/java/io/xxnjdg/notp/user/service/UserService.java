package io.xxnjdg.notp.user.service;

import io.xxnjdg.notp.user.object.data.transfer.UserLoginPasswordDTO;
import io.xxnjdg.notp.user.object.persistent.User;
import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.user.object.view.UserLoginVO;

/**
 * <p>
 * 用户基本信息 服务类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-20
 */
public interface UserService extends IService<User> {

    /**
     * xx
     * @param userLoginPasswordDTO
     * @return
     */
    UserLoginVO postUserLoginByPassword(UserLoginPasswordDTO userLoginPasswordDTO);
}
