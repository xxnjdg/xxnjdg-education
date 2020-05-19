package io.xxnjdg.notp.system.admin.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.system.admin.object.business.SysUserBO;
import io.xxnjdg.notp.system.admin.object.convert.SysUserMapStruct;
import io.xxnjdg.notp.system.admin.object.data.transfer.SysRoleUserDTO;
import io.xxnjdg.notp.system.admin.object.data.transfer.SysUserDTO;
import io.xxnjdg.notp.system.admin.object.error.SysUserEnum;
import io.xxnjdg.notp.system.admin.service.SysRoleUserAdminService;
import io.xxnjdg.notp.system.admin.service.SysUserAdminService;
import io.xxnjdg.notp.system.mapper.SysUserMapper;
import io.xxnjdg.notp.system.object.persistent.SysUser;
import io.xxnjdg.notp.user.admin.api.UserAdminControllerApi;
import io.xxnjdg.notp.user.admin.object.data.transfer.UserDTO;
import io.xxnjdg.notp.user.admin.object.view.UserVO;
import io.xxnjdg.notp.utils.constant.HttpStatus;
import io.xxnjdg.notp.utils.custom.utils.PageObjectUtil;
import io.xxnjdg.notp.utils.exception.BaseException;
import io.xxnjdg.notp.utils.objects.PageObject;
import io.xxnjdg.notp.utils.response.PageResult;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/19 2:59
 */
@Service
public class SysUserAdminServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserAdminService {
    @Autowired
    private UserAdminControllerApi userAdminControllerApi;

    @Autowired
    private SysRoleUserAdminService sysRoleUserAdminService;

    @Override
    public PageResult<SysUserBO> listSysUserByPage(SysUserDTO sysUserDTO) {
        PageResult<SysUserBO> result = new PageResult<>();
        String newMobile = null;
        String mobile = sysUserDTO.getMobile();

        //算总数
        LambdaQueryWrapper<SysUser> wrapper = new QueryWrapper<SysUser>()
                .lambda();

        if (StrUtil.isNotBlank(mobile)) {
            newMobile = mobile;
            wrapper.like(SysUser::getMobile, newMobile);
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
                this.baseMapper.listSysUserByPage(newMobile,pageObject.getOffset(), pageObject.getSize());

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

        Long userNo = sysUserDTO.getUserNo();
        ResponseResult<UserVO> userVO = userAdminControllerApi.getUserByUserNo(
                new UserDTO().setUserNo(userNo));
        if (userVO==null ||
                !ObjectUtil.equal(userVO.getStatus(), HttpStatus.SUCCESS.getStatus()) ||
                userVO.getData() == null ){
            throw new BaseException(SysUserEnum.SAVE_ERROR);
        }

        LambdaQueryWrapper<SysUser> wrapper = new QueryWrapper<SysUser>()
                .lambda()
                .eq(SysUser::getUserNo, userNo);

        SysUser one = this.getOne(wrapper);
        if (one!=null){
            throw new BaseException(SysUserEnum.SAVE_ERROR);
        }
        SysUser sysUser = SysUserMapStruct.INSTANCE.DTO2P(sysUserDTO);
        boolean save = this.save(sysUser);

        if (!save){
            throw new BaseException(SysUserEnum.SAVE_ERROR);
        }
        return true;
    }

    @Override
    public Boolean deleteSysUserById(SysUserDTO sysUserDTO) {
        Long id = sysUserDTO.getId();

        //删除SysRoleUser表
        sysRoleUserAdminService.deleteSysRoleUserByUserId(
                new SysRoleUserDTO().setUserId(id));

        //删除SysUser
        boolean remove = this.removeById(id);
        if (!remove){
            throw new BaseException(SysUserEnum.DELETE_ERROR);
        }
        return true;
    }

    @Override
    public Boolean updateSysUserById(SysUserDTO sysUserDTO) {
        SysUser sysUser = SysUserMapStruct.INSTANCE.DTO2P(sysUserDTO);
        boolean update = this.updateById(sysUser);
        if (!update){
            throw new BaseException(SysUserEnum.UPDATE_ERROR);
        }
        return true;
    }

    @Override
    public SysUserBO getSysUserById(SysUserDTO sysUserDTO) {
        SysUser sysUser = this.getById(sysUserDTO.getId());
        if (sysUser == null){
            throw new BaseException(SysUserEnum.GET_ERROR);
        }
        return SysUserMapStruct.INSTANCE.P2B(sysUser);
    }
}
