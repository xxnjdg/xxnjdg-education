package io.xxnjdg.notp.course.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.course.admin.object.business.ZoneBO;
import io.xxnjdg.notp.course.admin.object.convert.ZoneMapStruct;
import io.xxnjdg.notp.course.admin.object.data.transfer.ZoneDTO;
import io.xxnjdg.notp.course.admin.object.error.ZoneEnum;
import io.xxnjdg.notp.course.admin.service.ZoneAdminService;
import io.xxnjdg.notp.course.mapper.ZoneMapper;
import io.xxnjdg.notp.course.object.persistent.Zone;
import io.xxnjdg.notp.utils.config.SnowFlakeId;
import io.xxnjdg.notp.utils.custom.utils.PageObjectUtil;
import io.xxnjdg.notp.utils.exception.BaseException;
import io.xxnjdg.notp.utils.objects.PageObject;
import io.xxnjdg.notp.utils.response.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/20 21:09
 */
@Service
public class ZoneAdminServiceImpl extends ServiceImpl<ZoneMapper, Zone> implements ZoneAdminService {

    @Autowired
    private SnowFlakeId snowFlakeId;

    @Override
    public PageResult<ZoneBO> listZoneByPage(ZoneDTO zoneDTO) {
        PageResult<ZoneBO> result = new PageResult<>();

        //算总数
        LambdaQueryWrapper<Zone> wrapper = new QueryWrapper<Zone>()
                .lambda();

        Integer statusId = zoneDTO.getStatusId();
        Integer zoneLocation = zoneDTO.getZoneLocation();
        String zoneName = null;

        if (statusId != null){
            wrapper.eq(Zone::getStatusId,statusId);
        }

        if (zoneLocation != null){
            wrapper.eq(Zone::getZoneLocation,zoneLocation);
        }

        if (StrUtil.isNotBlank(zoneDTO.getZoneName())){
            zoneName = zoneDTO.getZoneName();
            wrapper.like(Zone::getZoneName,zoneName);
        }

        int count = this.count(wrapper);

        //条数为0
        if (count == 0){
            return result;
        }

        PageObject pageObject = PageObjectUtil.countPageOffsetAndSize(
                zoneDTO.getPageCurrent(), zoneDTO.getPageSize(), count);

        //查询
        List<Zone> zoneList =
                this.baseMapper.listZoneByPage(statusId,zoneLocation,zoneName,pageObject.getOffset(), pageObject.getSize());

        List<ZoneBO> zoneBOList = ZoneMapStruct.INSTANCE.P2B(zoneList);

        return result
                .setCurrentList(zoneBOList)
                .setTotalCount((long) count)
                .setTotalPage(pageObject.getTotalPage())
                .setCurrentPage(pageObject.getCurrentPage())
                .setCurrentListSize((long) zoneList.size());
    }

    @Override
    public Boolean saveZone(ZoneDTO zoneDTO) {
        //生成id
        Snowflake snowflake = IdUtil.createSnowflake(snowFlakeId.getWorkerId(), snowFlakeId.getDataCenterId());
        long id = snowflake.nextId();

        Zone zone = ZoneMapStruct.INSTANCE.DT2P(zoneDTO).setId(id);
        boolean save = this.save(zone);
        if (!save){
            throw new BaseException(ZoneEnum.SAVE_ERROR);
        }
        return true;
    }

    @Override
    public Boolean updateZoneById(ZoneDTO zoneDTO) {
        Zone zone = ZoneMapStruct.INSTANCE.DT2P(zoneDTO);
        boolean update = this.updateById(zone);
        if (!update){
            throw new BaseException(ZoneEnum.UPDATE_ERROR);
        }
        return true;
    }

    @Override
    public ZoneBO getZoneById(ZoneDTO zoneDTO) {
        Zone zone = this.getById(zoneDTO.getId());
        if (zone == null){
            throw new BaseException(ZoneEnum.GET_ERROR);
        }
        return ZoneMapStruct.INSTANCE.P2B(zone);
    }

    @Override
    public Boolean deleteZoneById(ZoneDTO zoneDTO) {
        boolean remove = this.removeById(zoneDTO.getId());
        if (!remove){
            throw new BaseException(ZoneEnum.DELETE_ERROR);
        }
        return true;
    }

    @Override
    public List<ZoneBO> getZoneByMap(ZoneDTO zoneDTO) {
        Zone zone = ZoneMapStruct.INSTANCE.DT2P(zoneDTO);
        Map<String, Object> map = BeanUtil.beanToMap(zone, true, true);
        List<Zone> zoneList = this.baseMapper.selectByMap(map);
        if (CollUtil.isEmpty(zoneList)){
            throw new BaseException(ZoneEnum.GET_ERROR);
        }
        return ZoneMapStruct.INSTANCE.P2B(zoneList);
    }
}
