package io.xxnjdg.notp.user.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.user.admin.object.business.UserBO;
import io.xxnjdg.notp.user.admin.object.convert.UserMapStruct;
import io.xxnjdg.notp.user.admin.object.data.transfer.UserDTO;
import io.xxnjdg.notp.user.admin.object.error.UserEnum;
import io.xxnjdg.notp.user.admin.service.UserAdminService;
import io.xxnjdg.notp.user.mapper.UserMapper;
import io.xxnjdg.notp.user.object.persistent.User;
import io.xxnjdg.notp.utils.exception.BaseException;
import org.springframework.stereotype.Service;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/19 12:54
 */
@Service
public class UserAdminServiceImpl extends ServiceImpl<UserMapper, User> implements UserAdminService {
    @Override
    public UserBO getUserByUserNo(UserDTO userDTO) {
        LambdaQueryWrapper<User> wrapper = new QueryWrapper<User>()
                .lambda()
                .eq(User::getUserNo, userDTO.getUserNo());

        User one = this.getOne(wrapper);
        if (one == null){
            throw new BaseException(UserEnum.GET_ERROR);
        }
        return UserMapStruct.INSTANCE.P2B(one);
    }
}
