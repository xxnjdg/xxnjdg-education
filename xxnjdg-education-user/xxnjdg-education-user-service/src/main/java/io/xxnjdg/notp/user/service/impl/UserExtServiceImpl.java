package io.xxnjdg.notp.user.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.xxnjdg.notp.user.object.data.transfer.UserExtDTO;
import io.xxnjdg.notp.user.object.error.UserExtEnum;
import io.xxnjdg.notp.user.object.persistent.UserExt;
import io.xxnjdg.notp.user.mapper.UserExtMapper;
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
public class UserExtServiceImpl extends ServiceImpl<UserExtMapper, UserExt> implements UserExtService {

    @Override
    public UserExtVO postUserExt(UserExtDTO userExtDTO) {

        LambdaQueryWrapper<UserExt> queryWrapper = new QueryWrapper<UserExt>().lambda()
                .eq(UserExt::getStatusId, RowStatus.ENABLE)
                .eq(UserExt::getUserNo, userExtDTO.getUserNo());

        UserExt userExt = this.getOne(queryWrapper);
        if (userExt == null){
            throw new BaseException(UserExtEnum.USER_EXT_ERROR);
        }

        return BeanUtil.copyProperties(userExt,UserExtVO.class);
    }
}
