package io.xxnjdg.notp.system.admin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.system.admin.object.business.MsgUserBO;
import io.xxnjdg.notp.system.admin.object.convert.MsgUserMapStruct;
import io.xxnjdg.notp.system.admin.object.data.transfer.MsgUserDTO;
import io.xxnjdg.notp.system.admin.object.error.MsgUserEnum;
import io.xxnjdg.notp.system.admin.service.MsgUserAdminService;
import io.xxnjdg.notp.system.mapper.MsgUserMapper;
import io.xxnjdg.notp.system.object.persistent.MsgUser;
import io.xxnjdg.notp.utils.custom.utils.PageObjectUtil;
import io.xxnjdg.notp.utils.exception.BaseException;
import io.xxnjdg.notp.utils.objects.PageObject;
import io.xxnjdg.notp.utils.response.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/18 13:56
 */
@Service
public class MsgUserAdminServiceImpl extends ServiceImpl<MsgUserMapper, MsgUser> implements MsgUserAdminService {
    @Override
    public PageResult<MsgUserBO> listMsgUserByPage(MsgUserDTO msgUserDTO) {
        PageResult<MsgUserBO> result = new PageResult<>();

        //算总数
        LambdaQueryWrapper<MsgUser> wrapper = new QueryWrapper<MsgUser>()
                .lambda();

        String mobile = null;
        String msgTitle = null;

        if (StrUtil.isNotBlank(msgUserDTO.getMsgTitle())) {
            msgTitle = msgUserDTO.getMsgTitle();
            wrapper.like(MsgUser::getMsgTitle, msgTitle);
        }

        if (StrUtil.isNotBlank(msgUserDTO.getMobile())) {
            mobile = msgUserDTO.getMobile();
            wrapper.like(MsgUser::getMobile, mobile);
        }

        int count = this.count(wrapper);

        //条数为0
        if (count == 0) {
            return result;
        }

        PageObject pageObject = PageObjectUtil.countPageOffsetAndSize(
                msgUserDTO.getPageCurrent(), msgUserDTO.getPageSize(), count);

        //查询
        List<MsgUser> msgUserList =
                this.baseMapper.listMsgUserByPage(mobile, msgTitle, pageObject.getOffset(), pageObject.getSize());

        List<MsgUserBO> msgUserBOList = MsgUserMapStruct.INSTANCE.P2B(msgUserList);

        return result
                .setCurrentList(msgUserBOList)
                .setTotalCount((long) count)
                .setTotalPage(pageObject.getTotalPage())
                .setCurrentPage(pageObject.getCurrentPage())
                .setCurrentListSize((long) msgUserList.size());
    }

    @Override
    public Boolean deleteMsgUserById(MsgUserDTO msgUserDTO) {
        boolean remove = this.removeById(msgUserDTO.getId());
        if (!remove){
            throw new BaseException(MsgUserEnum.DELETE_ERROR);
        }
        return true;
    }

    @Override
    public MsgUserBO getMsgUserById(MsgUserDTO msgUserDTO) {

        MsgUser msgUser = this.getById(msgUserDTO.getId());
        if (msgUser == null){
            throw new BaseException(MsgUserEnum.GET_ERROR);
        }

        return MsgUserMapStruct.INSTANCE.P2B(msgUser);
    }
}
