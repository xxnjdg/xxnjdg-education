package io.xxnjdg.notp.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import io.xxnjdg.notp.user.object.business.UserExtBO;
import io.xxnjdg.notp.user.object.convert.UserExtMapper;
import io.xxnjdg.notp.user.object.data.transfer.UpdateUserExtDTO;
import io.xxnjdg.notp.user.object.error.UserExtEnum;
import io.xxnjdg.notp.user.object.persistent.UserExt;
import io.xxnjdg.notp.user.object.view.UserExtVO;
import io.xxnjdg.notp.user.service.UserExtService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.utils.constant.RowStatus;
import io.xxnjdg.notp.utils.exception.BaseException;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户教育信息 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-20
 */
@Service
public class UserExtServiceImpl extends ServiceImpl<io.xxnjdg.notp.user.mapper.UserExtMapper, UserExt> implements UserExtService {

    @Override
    public UserExtBO getUserExtByUserNo(String userNo) {

        LambdaQueryWrapper<UserExt> queryWrapper = new QueryWrapper<UserExt>().lambda()
                .eq(UserExt::getStatusId, RowStatus.ENABLE)
                .eq(UserExt::getUserNo, Long.valueOf(userNo));

        UserExt userExt = this.getOne(queryWrapper);
        if (userExt == null){
            throw new BaseException(UserExtEnum.USER_EXT_ERROR);
        }

        return UserExtMapper.INSTANCE.convertD2B(userExt);
    }

    @Override
    public UserExtBO updateUserExt(UpdateUserExtDTO updateUserExtDTO) {

        LambdaUpdateWrapper<UserExt> updateWrapper = new UpdateWrapper<UserExt>()
                .lambda()
                .eq(UserExt::getUserNo, new Long(updateUserExtDTO.getUserNo()))
                .eq(UserExt::getStatusId,RowStatus.ENABLE)
                .set(UserExt::getAge, new Integer(updateUserExtDTO.getAge()))
                .set(UserExt::getSex, new Integer(updateUserExtDTO.getSex()))
                .set(UserExt::getNickname, updateUserExtDTO.getNickname())
                .set(UserExt::getHeadImgUrl, updateUserExtDTO.getHeadImgUrl());

        boolean update = this.update(updateWrapper);

        if (!update){
            throw new BaseException(UserExtEnum.USER_EXT_UPDATE_ERROR);
        }

        return this.getUserExtByUserNo(updateUserExtDTO.getUserNo());
    }
}
