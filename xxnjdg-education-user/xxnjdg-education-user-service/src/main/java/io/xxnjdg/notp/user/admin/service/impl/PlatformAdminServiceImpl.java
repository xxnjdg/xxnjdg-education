package io.xxnjdg.notp.user.admin.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.user.admin.object.business.PlatformBO;
import io.xxnjdg.notp.user.admin.object.convert.PlatformMapStruct;
import io.xxnjdg.notp.user.admin.object.data.transfer.PlatformDTO;
import io.xxnjdg.notp.user.admin.object.error.PlatformEnum;
import io.xxnjdg.notp.user.admin.service.PlatformAdminService;
import io.xxnjdg.notp.user.mapper.PlatformMapper;
import io.xxnjdg.notp.user.object.persistent.Platform;
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
 * @date 2020/5/18 21:45
 */
@Service
public class PlatformAdminServiceImpl extends ServiceImpl<PlatformMapper, Platform> implements PlatformAdminService {

    @Autowired
    private SnowFlakeId snowFlakeId;

    @Override
    public PageResult<PlatformBO> listPlatformByPage(PlatformDTO platformDTO) {
        PageResult<PlatformBO> result = new PageResult<>();

        //算总数
        LambdaQueryWrapper<Platform> wrapper = new QueryWrapper<Platform>()
                .lambda();

        String clientName = null;

        if (StrUtil.isNotBlank(platformDTO.getClientName())) {
            clientName = platformDTO.getClientName();
            wrapper.like(Platform::getClientName, clientName);
        }

        int count = this.count(wrapper);

        //条数为0
        if (count == 0) {
            return result;
        }

        PageObject pageObject = PageObjectUtil.countPageOffsetAndSize(
                platformDTO.getPageCurrent(), platformDTO.getPageSize(), count);

        //查询
        List<Platform> platformList =
                this.baseMapper.listPlatformByPage(clientName, pageObject.getOffset(), pageObject.getSize());

        List<PlatformBO> platformBOList = PlatformMapStruct.INSTANCE.P2B(platformList);

        return result
                .setCurrentList(platformBOList)
                .setTotalCount((long) count)
                .setTotalPage(pageObject.getTotalPage())
                .setCurrentPage(pageObject.getCurrentPage())
                .setCurrentListSize((long) platformList.size());
    }

    @Override
    public Boolean savePlatform(PlatformDTO platformDTO) {
        LambdaQueryWrapper<Platform> wrapper = new QueryWrapper<Platform>()
                .lambda()
                .eq(Platform::getClientName, platformDTO.getClientName());

        Platform one = this.getOne(wrapper);
        if (one != null) {
            throw new BaseException(PlatformEnum.SAVE_ERROR);
        }

        //生成id
        Snowflake snowflake = IdUtil.createSnowflake(snowFlakeId.getWorkerId(), snowFlakeId.getDataCenterId());
        long id = snowflake.nextId();

        platformDTO
                .setId(id)
                .setClientId("lk" + IdUtil.simpleUUID())
                .setClientSecret(IdUtil.simpleUUID());

        Platform platform = PlatformMapStruct.INSTANCE.DTO2P(platformDTO);
        boolean save = this.save(platform);
        if (!save) {
            throw new BaseException(PlatformEnum.SAVE_ERROR);
        }

        return true;
    }

    @Override
    public Boolean updatePlatformById(PlatformDTO platformDTO) {
        Platform platform = PlatformMapStruct.INSTANCE.DTO2P(platformDTO);
        boolean update = this.updateById(platform);
        if (!update){
            throw new BaseException(PlatformEnum.UPDATE_ERROR);
        }
        return true;
    }

    @Override
    public Boolean deletePlatformById(PlatformDTO platformDTO) {
        boolean remove = this.removeById(platformDTO.getId());
        if (!remove){
            throw new BaseException(PlatformEnum.DELETE_ERROR);
        }
        return true;
    }

    @Override
    public PlatformBO getPlatformById(PlatformDTO platformDTO) {
        Platform platform = this.getById(platformDTO.getId());
        if (platform == null){
            throw new BaseException(PlatformEnum.DELETE_ERROR);
        }
        return PlatformMapStruct.INSTANCE.P2B(platform);
    }
}
