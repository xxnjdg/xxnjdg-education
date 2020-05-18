package io.xxnjdg.notp.system.admin.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.system.admin.object.business.MsgBO;
import io.xxnjdg.notp.system.admin.object.convert.MsgMapStruct;
import io.xxnjdg.notp.system.admin.object.data.transfer.MsgDTO;
import io.xxnjdg.notp.system.admin.object.error.MsgEnum;
import io.xxnjdg.notp.system.admin.service.MsgAdminService;
import io.xxnjdg.notp.system.mapper.MsgMapper;
import io.xxnjdg.notp.system.object.persistent.Msg;
import io.xxnjdg.notp.utils.config.SnowFlakeId;
import io.xxnjdg.notp.utils.custom.utils.PageObjectUtil;
import io.xxnjdg.notp.utils.exception.BaseException;
import io.xxnjdg.notp.utils.objects.PageObject;
import io.xxnjdg.notp.utils.response.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/18 2:28
 */
@Service
public class MsgAdminServiceImpl extends ServiceImpl<MsgMapper, Msg> implements MsgAdminService {

    @Autowired
    private SnowFlakeId snowFlakeId;

    @Override
    public PageResult<MsgBO> listMsgByPage(MsgDTO msgDTO) {
        PageResult<MsgBO> result = new PageResult<>();

        //算总数
        LambdaQueryWrapper<Msg> wrapper = new QueryWrapper<Msg>()
                .lambda();

        Integer statusId = msgDTO.getStatusId();
        Integer isSend = msgDTO.getIsSend();
        Integer isTop = msgDTO.getIsTop();
        String msgTitle = null;

        if (statusId != null){
            wrapper.eq(Msg::getStatusId, statusId);
        }

        if (isSend != null){
            wrapper.eq(Msg::getIsSend, isSend);
        }

        if (isTop != null){
            wrapper.eq(Msg::getIsTop, isTop);
        }

        if (StrUtil.isNotBlank(msgDTO.getMsgTitle())) {
            msgTitle = msgDTO.getMsgTitle();
            wrapper.like(Msg::getMsgTitle, msgTitle);
        }

        int count = this.count(wrapper);

        //条数为0
        if (count == 0) {
            return result;
        }

        PageObject pageObject = PageObjectUtil.countPageOffsetAndSize(
                msgDTO.getPageCurrent(), msgDTO.getPageSize(), count);

        //查询
        List<Msg> msgList =
                this.baseMapper.listMsgByPage(statusId, isSend, isTop, msgTitle,pageObject.getOffset(), pageObject.getSize());

        List<MsgBO> msgBOList = MsgMapStruct.INSTANCE.P2B(msgList);

        return result
                .setCurrentList(msgBOList)
                .setTotalCount((long) count)
                .setTotalPage(pageObject.getTotalPage())
                .setCurrentPage(pageObject.getCurrentPage())
                .setCurrentListSize((long) msgList.size());
    }

    @Override
    public Boolean saveMsg(MsgDTO msgDTO) {

        //生成主键id
        Snowflake snowflake = IdUtil.createSnowflake(snowFlakeId.getWorkerId(), snowFlakeId.getDataCenterId());
        long id = snowflake.nextId();

        msgDTO.setId(id);

        Msg msg = MsgMapStruct.INSTANCE.DTO2P(msgDTO);

        boolean save = this.save(msg);

        if (!save){
            throw new BaseException(MsgEnum.SAVE_ERROR);
        }

        return true;
    }

    @Override
    public Boolean deleteMsg(MsgDTO msgDTO) {
        // TODO: 2020/5/18 有点问题
        boolean remove = this.removeById(msgDTO.getId());
        if (!remove){
            throw new BaseException(MsgEnum.SAVE_ERROR);
        }

        return true;
    }

    @Override
    public Boolean updateMsg(MsgDTO msgDTO) {
        Msg msg = MsgMapStruct.INSTANCE.DTO2P(msgDTO);
        boolean update = this.updateById(msg);
        if (!update){
            throw new BaseException(MsgEnum.UPDATE_ERROR);
        }
        return true;
    }

    @Override
    public MsgBO getMsg(MsgDTO msgDTO) {
        Msg msg = this.getById(msgDTO.getId());
        if (msg == null){
            throw new BaseException(MsgEnum.GET_ERROR);
        }
        return MsgMapStruct.INSTANCE.P2B(msg);
    }
}
