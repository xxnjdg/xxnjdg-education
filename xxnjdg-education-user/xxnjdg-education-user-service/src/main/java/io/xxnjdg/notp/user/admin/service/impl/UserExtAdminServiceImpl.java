package io.xxnjdg.notp.user.admin.service.impl;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.user.admin.object.business.UserExtBO;
import io.xxnjdg.notp.user.admin.object.convert.UserExtMapStruct;
import io.xxnjdg.notp.user.admin.object.data.transfer.UserExtDTO;
import io.xxnjdg.notp.user.admin.object.error.UserExtEnum;
import io.xxnjdg.notp.user.admin.service.UserExtAdminService;
import io.xxnjdg.notp.user.mapper.UserExtMapper;
import io.xxnjdg.notp.user.object.persistent.UserExt;
import io.xxnjdg.notp.utils.custom.utils.PageObjectUtil;
import io.xxnjdg.notp.utils.exception.BaseException;
import io.xxnjdg.notp.utils.objects.PageObject;
import io.xxnjdg.notp.utils.response.PageResult;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/25 3:00
 */
@Service
public class UserExtAdminServiceImpl extends ServiceImpl<UserExtMapper, UserExt> implements UserExtAdminService {
    @Override
    public UserExt getUserExtByMobile(String mobile) {
        LambdaQueryWrapper<UserExt> wrapper = new QueryWrapper<UserExt>()
                .lambda()
                .eq(UserExt::getMobile, mobile);

        return this.getOne(wrapper);
    }

    @Override
    public Boolean updateUserByUserNo(String mobile, Long userNo) {
        LambdaUpdateWrapper<UserExt> wrapper = new UpdateWrapper<UserExt>()
                .lambda()
                .eq(UserExt::getUserNo, userNo)
                .set(UserExt::getMobile, mobile);
        return this.update(wrapper);
    }

    @Override
    public PageResult<UserExtBO> listUserExtByPage(UserExtDTO userExtDTO) {
        PageResult<UserExtBO> result = new PageResult<>();

        //算总数
        LambdaQueryWrapper<UserExt> wrapper = new QueryWrapper<UserExt>()
                .lambda();

        String nickname = null;
        String mobile = null;
        DateTime beginGmtCreate = null;
        DateTime endGmtCreate = null;
        Integer statusId = userExtDTO.getStatusId();

        if (statusId!=null){
            wrapper.eq(UserExt::getStatusId,statusId);
        }

        if (StrUtil.isNotBlank(userExtDTO.getNickname())) {
            nickname = userExtDTO.getNickname();
            wrapper.like(UserExt::getNickname, nickname);
        }

        if (StrUtil.isNotBlank(userExtDTO.getMobile())) {
            mobile = userExtDTO.getMobile();
            wrapper.like(UserExt::getMobile, mobile);
        }

        if (StrUtil.isNotBlank(userExtDTO.getBeginGmtCreate())) {
            beginGmtCreate = DateUtil.parse(userExtDTO.getBeginGmtCreate());
            beginGmtCreate.offset(DateField.HOUR, 24);
            wrapper.ge(UserExt::getGmtCreate, beginGmtCreate);
        }

        if (StrUtil.isNotBlank(userExtDTO.getEndGmtCreate())) {
            endGmtCreate = DateUtil.parse(userExtDTO.getEndGmtCreate());
            endGmtCreate.offset(DateField.HOUR, 48);
            wrapper.le(UserExt::getGmtCreate, endGmtCreate);
        }

        int count = this.count(wrapper);

        //条数为0
        if (count == 0) {
            return result;
        }

        PageObject pageObject = PageObjectUtil.countPageOffsetAndSize(
                userExtDTO.getPageCurrent(), userExtDTO.getPageSize(), count);

        //查询
        List<UserExt> userExtList =
                this.baseMapper.listUserExtByPage(statusId,nickname,mobile, beginGmtCreate, endGmtCreate, pageObject.getOffset(), pageObject.getSize());

        List<UserExtBO> userExtBOList = UserExtMapStruct.INSTANCE.P2B(userExtList);

        return result
                .setCurrentList(userExtBOList)
                .setTotalCount((long) count)
                .setTotalPage(pageObject.getTotalPage())
                .setCurrentPage(pageObject.getCurrentPage())
                .setCurrentListSize((long) userExtBOList.size());
    }

    @Override
    public Boolean updateUserExt(UserExtDTO userExtDTO) {
        UserExt userExt = UserExtMapStruct.INSTANCE.DT2P(userExtDTO);
        boolean update = this.updateById(userExt);
        if (!update){
            throw new BaseException(UserExtEnum.UPDATE_ERROR);
        }
        return true;
    }

    @Override
    public UserExtBO getUserExt(UserExtDTO userExtDTO) {
        UserExt userExt = this.getById(userExtDTO.getId());
        if (userExt == null){
            throw new BaseException(UserExtEnum.GET_ERROR);
        }
        return UserExtMapStruct.INSTANCE.P2B(userExt);
    }
}
