package io.xxnjdg.notp.system.admin.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.system.admin.object.business.MsgTemplateBO;
import io.xxnjdg.notp.system.admin.object.convert.MsgTemplateMapStruct;
import io.xxnjdg.notp.system.admin.object.data.transfer.MsgTemplateDTO;
import io.xxnjdg.notp.system.admin.object.error.MsgTemplateEnum;
import io.xxnjdg.notp.system.admin.service.MsgTemplateAdminService;
import io.xxnjdg.notp.system.mapper.MsgTemplateMapper;
import io.xxnjdg.notp.system.object.persistent.MsgTemplate;
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
 * @date 2020/5/18 16:10
 */
@Service
public class MsgTemplateAdminServiceImpl extends ServiceImpl<MsgTemplateMapper, MsgTemplate> implements MsgTemplateAdminService {
    @Autowired
    private SnowFlakeId snowFlakeId;

    @Override
    public PageResult<MsgTemplateBO> listMsgTemplateByPage(MsgTemplateDTO msgTemplateDTO) {
        PageResult<MsgTemplateBO> result = new PageResult<>();

        //算总数
        LambdaQueryWrapper<MsgTemplate> wrapper = new QueryWrapper<MsgTemplate>()
                .lambda();

        int count = this.count(wrapper);

        //条数为0
        if (count == 0) {
            return result;
        }

        PageObject pageObject = PageObjectUtil.countPageOffsetAndSize(
                msgTemplateDTO.getPageCurrent(), msgTemplateDTO.getPageSize(), count);

        //查询
        List<MsgTemplate> msgTemplateList =
                this.baseMapper.listMsgTemplateByPage(pageObject.getOffset(), pageObject.getSize());

        List<MsgTemplateBO> msgTemplateBOList = MsgTemplateMapStruct.INSTANCE.P2B(msgTemplateList);

        return result
                .setCurrentList(msgTemplateBOList)
                .setTotalCount((long) count)
                .setTotalPage(pageObject.getTotalPage())
                .setCurrentPage(pageObject.getCurrentPage())
                .setCurrentListSize((long) msgTemplateList.size());
    }

    @Override
    public Boolean deleteMsgTemplateById(MsgTemplateDTO msgTemplateDTO) {
        boolean remove = this.removeById(msgTemplateDTO.getId());
        if (!remove){
            throw new BaseException(MsgTemplateEnum.DELETE_ERROR);
        }
        return true;
    }

    @Override
    public Boolean saveMsgTemplate(MsgTemplateDTO msgTemplateDTO) {
        //生成主键id
        Snowflake snowflake = IdUtil.createSnowflake(snowFlakeId.getWorkerId(), snowFlakeId.getDataCenterId());
        long id = snowflake.nextId();

        msgTemplateDTO.setId(id);

        MsgTemplate msgTemplate = MsgTemplateMapStruct.INSTANCE.DTO2P(msgTemplateDTO);
        boolean save = this.save(msgTemplate);
        if (!save){
            throw new BaseException(MsgTemplateEnum.SAVE_ERROR);
        }
        return true;
    }

    @Override
    public Boolean updateMsgTemplateById(MsgTemplateDTO msgTemplateDTO) {
        MsgTemplate msgTemplate = MsgTemplateMapStruct.INSTANCE.DTO2P(msgTemplateDTO);
        boolean update = this.updateById(msgTemplate);
        if (!update){
            throw new BaseException(MsgTemplateEnum.UPDATE_ERROR);
        }
        return true;
    }

    @Override
    public MsgTemplateBO getMsgTemplateById(MsgTemplateDTO msgTemplateDTO) {
        MsgTemplate msgTemplate = this.getById(msgTemplateDTO.getId());
        if (msgTemplate == null){
            throw new BaseException(MsgTemplateEnum.GET_ERROR);
        }
        return MsgTemplateMapStruct.INSTANCE.P2B(msgTemplate);
    }
}
