package io.xxnjdg.notp.course.admin.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.course.admin.object.business.AdvBO;
import io.xxnjdg.notp.course.admin.object.convert.AdvMapStruct;
import io.xxnjdg.notp.course.admin.object.data.transfer.AdvDTO;
import io.xxnjdg.notp.course.admin.object.error.AdvEnum;
import io.xxnjdg.notp.course.admin.service.AdvAdminService;
import io.xxnjdg.notp.course.mapper.AdvMapper;
import io.xxnjdg.notp.course.object.persistent.Adv;
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
 * @date 2020/5/20 13:50
 */
@Service
public class AdvAdminServiceImpl extends ServiceImpl<AdvMapper, Adv> implements AdvAdminService {

    @Autowired
    private SnowFlakeId snowFlakeId;

    @Override
    public PageResult<AdvBO> listAdvByPage(AdvDTO advDTO) {
        PageResult<AdvBO> result = new PageResult<>();

        //算总数
        LambdaQueryWrapper<Adv> wrapper = new QueryWrapper<Adv>()
                .lambda();

        int count = this.count(wrapper);

        Integer statusId = advDTO.getStatusId();
        Integer platShow = advDTO.getPlatShow();
        String advTitle = null;

        if (statusId != null){
            wrapper.eq(Adv::getStatusId,statusId);
        }

        if (platShow != null){
            wrapper.eq(Adv::getPlatShow,platShow);
        }

        if (StrUtil.isNotBlank(advDTO.getAdvTitle())){
            advTitle = advDTO.getAdvTitle();
             wrapper.like(Adv::getAdvTitle,advTitle);
        }

        //条数为0
        if (count == 0){
            return result;
        }

        PageObject pageObject = PageObjectUtil.countPageOffsetAndSize(
                advDTO.getPageCurrent(), advDTO.getPageSize(), count);

        //查询
        List<Adv> advList =
                this.baseMapper.listAdvByPage(statusId,platShow,advTitle,pageObject.getOffset(), pageObject.getSize());

        List<AdvBO> advBOList = AdvMapStruct.INSTANCE.P2B(advList);

        return result
                .setCurrentList(advBOList)
                .setTotalCount((long) count)
                .setTotalPage(pageObject.getTotalPage())
                .setCurrentPage(pageObject.getCurrentPage())
                .setCurrentListSize((long) advBOList.size());
    }

    @Override
    public Boolean saveAdv(AdvDTO advDTO) {
        //生成id
        Snowflake snowflake = IdUtil.createSnowflake(snowFlakeId.getWorkerId(), snowFlakeId.getDataCenterId());
        long id = snowflake.nextId();

        Adv adv = AdvMapStruct.INSTANCE.DTO2P(advDTO).setId(id);
        boolean save = this.save(adv);

        if (!save){
            throw new BaseException(AdvEnum.SAVE_ERROR);
        }
        return true;
    }

    @Override
    public AdvBO getAdvById(AdvDTO advDTO) {
        Adv adv = this.getById(advDTO.getId());
        if (adv == null){
            throw new BaseException(AdvEnum.GET_ERROR);
        }
        return AdvMapStruct.INSTANCE.P2B(adv);
    }

    @Override
    public Boolean updateAdvById(AdvDTO advDTO) {
        // TODO: 2020/5/21 少了删除oss图片
        Adv adv = AdvMapStruct.INSTANCE.DTO2P(advDTO);
        boolean update = this.updateById(adv);
        if (!update){
            throw new BaseException(AdvEnum.UPDATE_ERROR);
        }
        return true;
    }

    @Override
    public Boolean deleteAdvById(AdvDTO advDTO) {
        // TODO: 2020/5/21 少了删除oss图片
        boolean remove = this.removeById(advDTO.getId());
        if (!remove){
            throw new BaseException(AdvEnum.DELETE_ERROR);
        }
        return true;
    }
}

