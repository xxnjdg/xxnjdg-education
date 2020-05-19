package io.xxnjdg.notp.user.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.user.admin.object.business.UserBO;
import io.xxnjdg.notp.user.admin.object.data.transfer.UserDTO;
import io.xxnjdg.notp.user.object.persistent.User;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/19 12:50
 */
public interface UserAdminService extends IService<User> {
    /**
     * UserNo查询User
     * @param userDTO
     * @return
     */
    UserBO getUserByUserNo(UserDTO userDTO);
}
