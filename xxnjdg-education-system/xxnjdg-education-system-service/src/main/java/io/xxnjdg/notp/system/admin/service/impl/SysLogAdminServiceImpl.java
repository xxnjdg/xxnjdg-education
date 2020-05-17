package io.xxnjdg.notp.system.admin.service.impl;


import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.system.admin.object.business.SysLogBO;
import io.xxnjdg.notp.system.admin.object.convert.SysLogMapStruct;
import io.xxnjdg.notp.system.admin.object.data.transfer.SysLogDTO;
import io.xxnjdg.notp.system.admin.service.SysLogAdminService;
import io.xxnjdg.notp.system.mapper.SysLogMapper;
import io.xxnjdg.notp.system.object.persistent.SysLog;
import io.xxnjdg.notp.utils.custom.utils.PageObjectUtil;
import io.xxnjdg.notp.utils.objects.PageObject;
import io.xxnjdg.notp.utils.response.PageResult;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/17 21:34
 */
@Service
public class SysLogAdminServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogAdminService {
    @Override
    public PageResult<SysLogBO> listSysLogByPage(SysLogDTO sysLogDTO) {
        PageResult<SysLogBO> result = new PageResult<>();

        //算总数
        LambdaQueryWrapper<SysLog> wrapper = new QueryWrapper<SysLog>()
                .lambda();

        String realName = null;
        DateTime beginDate = null;
        DateTime endDate = null;

        if (StrUtil.isNotBlank(sysLogDTO.getRealName())) {
            realName = sysLogDTO.getRealName();
            wrapper.like(SysLog::getRealName, realName);
        }

        if (StrUtil.isNotBlank(sysLogDTO.getBeginDate())) {
            beginDate = DateUtil.parse(sysLogDTO.getBeginDate());
            beginDate.offset(DateField.HOUR, 24);
            wrapper.ge(SysLog::getGmtCreate, beginDate);
        }

        if (StrUtil.isNotBlank(sysLogDTO.getEndDate())) {
            endDate = DateUtil.parse(sysLogDTO.getEndDate());
            endDate.offset(DateField.HOUR, 48);
            wrapper.le(SysLog::getGmtCreate, endDate);
        }

        int count = this.count(wrapper);

        //条数为0
        if (count == 0) {
            return result;
        }

        PageObject pageObject = PageObjectUtil.countPageOffsetAndSize(
                sysLogDTO.getPageCurrent(), sysLogDTO.getPageSize(), count);

        //查询
        List<SysLog> sysLogList =
                this.baseMapper.listSysLogByPage(realName, beginDate, endDate, pageObject.getOffset(), pageObject.getSize());

        List<SysLogBO> sysLogBOList = SysLogMapStruct.INSTANCE.P2B(sysLogList);

        return result
                .setCurrentList(sysLogBOList)
                .setTotalCount((long) count)
                .setTotalPage(pageObject.getTotalPage())
                .setCurrentPage(pageObject.getCurrentPage())
                .setCurrentListSize((long) sysLogList.size());
    }
}
