package io.xxnjdg.notp.user.admin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.user.admin.object.business.UserBO;
import io.xxnjdg.notp.user.admin.object.convert.UserMapStruct;
import io.xxnjdg.notp.user.admin.object.data.transfer.UserDTO;
import io.xxnjdg.notp.user.admin.object.error.UserEnum;
import io.xxnjdg.notp.user.admin.service.UserAdminService;
import io.xxnjdg.notp.user.mapper.UserMapper;
import io.xxnjdg.notp.user.object.persistent.User;
import io.xxnjdg.notp.utils.custom.utils.PageObjectUtil;
import io.xxnjdg.notp.utils.exception.BaseException;
import io.xxnjdg.notp.utils.objects.PageObject;
import io.xxnjdg.notp.utils.response.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Boolean updateUserByUserNo(String mobile, Long userNo) {
        LambdaUpdateWrapper<User> wrapper = new UpdateWrapper<User>()
                .lambda()
                .eq(User::getUserNo, userNo)
                .set(User::getMobile, mobile);
        return this.update(wrapper);
    }

    @Override
    public PageResult<UserBO> listUserByPage(UserDTO userDTO) {
        PageResult<UserBO> result = new PageResult<>();

        //算总数
        LambdaQueryWrapper<User> wrapper = new QueryWrapper<User>()
                .lambda();

        String mobile = null;

        if (StrUtil.isNotBlank(userDTO.getMobile())) {
            mobile = userDTO.getMobile();
            wrapper.like(User::getMobile, mobile);
        }

        int count = this.count(wrapper);

        //条数为0
        if (count == 0) {
            return result;
        }

        PageObject pageObject = PageObjectUtil.countPageOffsetAndSize(
                userDTO.getPageCurrent(), userDTO.getPageSize(), count);

        //查询
        List<User> userList =
                this.baseMapper.listUserByPage(mobile, pageObject.getOffset(), pageObject.getSize());

        List<UserBO> userBOList = UserMapStruct.INSTANCE.P2B(userList);

        return result
                .setCurrentList(userBOList)
                .setTotalCount((long) count)
                .setTotalPage(pageObject.getTotalPage())
                .setCurrentPage(pageObject.getCurrentPage())
                .setCurrentListSize((long) userBOList.size());
    }
}
