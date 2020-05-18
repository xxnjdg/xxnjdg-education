package io.xxnjdg.notp.system.admin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.system.admin.object.business.SysUserBO;
import io.xxnjdg.notp.system.admin.object.convert.SysUserMapStruct;
import io.xxnjdg.notp.system.admin.object.data.transfer.SysUserDTO;
import io.xxnjdg.notp.system.admin.service.SysUserAdminService;
import io.xxnjdg.notp.system.mapper.SysUserMapper;
import io.xxnjdg.notp.system.object.persistent.SysUser;
import io.xxnjdg.notp.utils.custom.utils.PageObjectUtil;
import io.xxnjdg.notp.utils.objects.PageObject;
import io.xxnjdg.notp.utils.response.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/19 2:59
 */
@Service
public class SysUserAdminServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserAdminService {
    @Override
    public PageResult<SysUserBO> listSysUserByPage(SysUserDTO sysUserDTO) {
        PageResult<SysUserBO> result = new PageResult<>();
        String mobile = null;

        //算总数
        LambdaQueryWrapper<SysUser> wrapper = new QueryWrapper<SysUser>()
                .lambda();

        if (StrUtil.isNotBlank(sysUserDTO.getMobile())) {
            mobile = sysUserDTO.getMobile();
            wrapper.like(SysUser::getMobile, mobile);
        }

        int count = this.count(wrapper);

        //条数为0
        if (count == 0) {
            return result;
        }

        PageObject pageObject = PageObjectUtil.countPageOffsetAndSize(
                sysUserDTO.getPageCurrent(), sysUserDTO.getPageSize(), count);

        //查询
        List<SysUser> sysUserList =
                this.baseMapper.listSysUserByPage(mobile,pageObject.getOffset(), pageObject.getSize());

        List<SysUserBO> sysUserBOList = SysUserMapStruct.INSTANCE.P2B(sysUserList);

        return result
                .setCurrentList(sysUserBOList)
                .setTotalCount((long) count)
                .setTotalPage(pageObject.getTotalPage())
                .setCurrentPage(pageObject.getCurrentPage())
                .setCurrentListSize((long) sysUserList.size());
    }

    @Override
    public Boolean saveSysUser(SysUserDTO sysUserDTO) {

        return null;
    }
}
