package io.xxnjdg.notp.user.admin.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.user.admin.object.business.LecturerAuditBO;
import io.xxnjdg.notp.user.admin.object.business.LecturerExtBO;
import io.xxnjdg.notp.user.admin.object.convert.LecturerAuditMapStruct;
import io.xxnjdg.notp.user.admin.object.data.transfer.LecturerAuditDTO;
import io.xxnjdg.notp.user.admin.object.error.LecturerAuditEnum;
import io.xxnjdg.notp.user.admin.service.LecturerAuditAdminService;
import io.xxnjdg.notp.user.admin.service.LecturerExtAdminService;
import io.xxnjdg.notp.user.admin.service.UserAdminService;
import io.xxnjdg.notp.user.admin.service.UserExtAdminService;
import io.xxnjdg.notp.user.mapper.LecturerAuditMapper;
import io.xxnjdg.notp.user.object.persistent.*;
import io.xxnjdg.notp.utils.config.SnowFlakeId;
import io.xxnjdg.notp.utils.constant.AuditStatus;
import io.xxnjdg.notp.utils.constant.RowStatus;
import io.xxnjdg.notp.utils.custom.utils.NOUtil;
import io.xxnjdg.notp.utils.custom.utils.PageObjectUtil;
import io.xxnjdg.notp.utils.exception.BaseException;
import io.xxnjdg.notp.utils.objects.PageObject;
import io.xxnjdg.notp.utils.response.PageResult;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/24 16:02
 */
@Service
public class LecturerAuditAdminServiceImpl extends ServiceImpl<LecturerAuditMapper, LecturerAudit> implements LecturerAuditAdminService {
    @Autowired
    private UserExtAdminService userExtAdminService;

    @Autowired
    private UserAdminService userAdminService;

    @Autowired
    private SnowFlakeId snowFlakeId;

    @Autowired
    private LecturerExtAdminService lecturerExtAdminService;

    @Autowired
    private LecturerAdminServiceImpl lecturerAdminService;

    @Override
    public PageResult<LecturerAuditBO> listLecturerAuditByPage(LecturerAuditDTO lecturerAuditDTO) {
        PageResult<LecturerAuditBO> result = new PageResult<>();

        //算总数
        LambdaQueryWrapper<LecturerAudit> wrapper = new QueryWrapper<LecturerAudit>()
                .lambda();

        String lecturerMobile = null;
        String lecturerName = null;
        Integer statusId = lecturerAuditDTO.getStatusId();
        Integer auditStatus = lecturerAuditDTO.getAuditStatus();

        if (StrUtil.isNotBlank(lecturerAuditDTO.getLecturerMobile())) {
            lecturerMobile = lecturerAuditDTO.getLecturerMobile();
            wrapper.like(LecturerAudit::getLecturerMobile, lecturerMobile);
        }

        if (statusId != null){
            wrapper.eq(LecturerAudit::getStatusId,statusId);
        }

        if (auditStatus != null) {
            wrapper.eq(LecturerAudit::getAuditStatus, auditStatus);
        } else {
            wrapper.ne(LecturerAudit::getAuditStatus, AuditStatus.PASS);
        }

        if (StrUtil.isNotBlank(lecturerAuditDTO.getLecturerName())) {
            lecturerName = lecturerAuditDTO.getLecturerName();
            wrapper.like(LecturerAudit::getLecturerName, lecturerName);
        }

        int count = this.count(wrapper);

        //条数为0
        if (count == 0) {
            return result;
        }

        PageObject pageObject = PageObjectUtil.countPageOffsetAndSize(
                lecturerAuditDTO.getPageCurrent(), lecturerAuditDTO.getPageSize(), count);

        //查询
        List<LecturerAudit> lecturerAuditList =
                this.baseMapper.listLecturerAuditByPage(auditStatus,statusId,lecturerMobile,lecturerName, pageObject.getOffset(), pageObject.getSize());

        List<LecturerAuditBO> lecturerAuditBOList = LecturerAuditMapStruct.INSTANCE.P2B(lecturerAuditList);

        return result
                .setCurrentList(lecturerAuditBOList)
                .setTotalCount((long) count)
                .setTotalPage(pageObject.getTotalPage())
                .setCurrentPage(pageObject.getCurrentPage())
                .setCurrentListSize((long) lecturerAuditBOList.size());

    }

    @Override
    @Transactional
    public Boolean saveLecturerAudit(LecturerAuditDTO lecturerAuditDTO) {
        //查询用户是否存在
        UserExt userExt = userExtAdminService.getUserExtByMobile(
                lecturerAuditDTO.getLecturerMobile());

        //生成主键id
        Snowflake snowflake = IdUtil.createSnowflake(snowFlakeId.getWorkerId(), snowFlakeId.getDataCenterId());

        //未注册，执行注册
        if (userExt == null){

            if (lecturerAuditDTO.getMobilePsw() == null ||
                    lecturerAuditDTO.getConfirmPasswd() == null){
                throw new BaseException(LecturerAuditEnum.SAVE_ERROR);
            }

            //判断密码是否相同
            if (!ObjectUtil.equal(lecturerAuditDTO.getMobilePsw(),lecturerAuditDTO.getConfirmPasswd())){
                throw new BaseException(LecturerAuditEnum.SAVE_ERROR);
            }


            //插入 user 表
            User user = new User()
                    .setId(snowflake.nextId())
                    .setMobileSalt(IdUtil.simpleUUID())
                    .setMobile(lecturerAuditDTO.getLecturerMobile())
                    .setUserNo(NOUtil.getUserNo());
            user.setMobilePsw(DigestUtil.sha1Hex(user.getMobileSalt() + lecturerAuditDTO.getMobilePsw()));

            boolean save = userAdminService.save(user);
            if (!save){
                throw new BaseException(LecturerAuditEnum.SAVE_ERROR);
            }

            userExt = new UserExt()
                    .setId(snowflake.nextId())
                    .setMobile(lecturerAuditDTO.getLecturerMobile())
                    .setUserNo(user.getUserNo())
                    .setNickname(lecturerAuditDTO.getLecturerName())
                    .setHeadImgUrl(lecturerAuditDTO.getHeadImgUrl());

            boolean save1 = userExtAdminService.save(userExt);
            if (!save1){
                throw new BaseException(LecturerAuditEnum.SAVE_ERROR);
            }
        }

        //查询
        LambdaQueryWrapper<LecturerAudit> wrapper = new QueryWrapper<LecturerAudit>()
                .lambda()
                .eq(LecturerAudit::getLecturerMobile, lecturerAuditDTO.getLecturerMobile());

        LecturerAudit one = this.getOne(wrapper);
        if (one != null){
            throw new BaseException(LecturerAuditEnum.SAVE_ERROR);
        }

        LecturerAudit lecturerAudit = LecturerAuditMapStruct.INSTANCE.DT2P(lecturerAuditDTO)
                .setId(snowflake.nextId())
                .setLecturerUserNo(userExt.getUserNo());

        if (lecturerAudit.getLecturerName() == null){
            lecturerAudit.setLecturerName(userExt.getNickname());
        }

        if (lecturerAudit.getHeadImgUrl() == null){
            lecturerAudit.setHeadImgUrl(userExt.getHeadImgUrl());
        }

        if (lecturerAudit.getLecturerProportion() == null){
            lecturerAudit.setLecturerProportion(new BigDecimal("0.7"));
        }

        boolean save = this.save(lecturerAudit);
        if (!save){
            throw new BaseException(LecturerAuditEnum.SAVE_ERROR);
        }

        LecturerExt lecturerExt = new LecturerExt()
                .setId(snowflake.nextId())
                .setLecturerUserNo(userExt.getUserNo())
                .setTotalIncome(BigDecimal.ZERO)
                .setHistoryMoney(BigDecimal.ZERO)
                .setEnableBalances(BigDecimal.ZERO)
                .setFreezeBalances(BigDecimal.ZERO);

        lecturerExt.setSign(getByLecturer(
                lecturerExt.getTotalIncome(),
                lecturerExt.getHistoryMoney(),
                lecturerExt.getEnableBalances(),
                lecturerExt.getFreezeBalances()));

        boolean save1 = lecturerExtAdminService.save(lecturerExt);
        if (!save1){
            throw new BaseException(LecturerAuditEnum.SAVE_ERROR);
        }

        return true;
    }

    @Override
    @Transactional
    public Boolean updateLecturerAudit(LecturerAuditDTO lecturerAuditDTO) {

        String mobile = lecturerAuditDTO.getLecturerMobile();
        // TODO: 2020/5/25 目前使用手机号登陆，所以以下if逻辑暂时作废
        if (mobile !=null){
            //查询用户是否存在
            UserExt userExt = userExtAdminService.getUserExtByMobile(mobile);

            //手机号以存在
            if (userExt != null){
                throw new BaseException(LecturerAuditEnum.UPDATE_ERROR);
            }

            LecturerAudit lecturerAudit = this.getById(lecturerAuditDTO.getId());
            if (lecturerAudit == null){
                throw new BaseException(LecturerAuditEnum.UPDATE_ERROR);
            }

            Long userNo = lecturerAudit.getLecturerUserNo();

            Boolean update = userAdminService.updateUserByUserNo(mobile, userNo);

            if (!update){
                throw new BaseException(LecturerAuditEnum.UPDATE_ERROR);
            }

            Boolean update1 = userExtAdminService.updateUserByUserNo(mobile, userNo);

            if (!update1){
                throw new BaseException(LecturerAuditEnum.UPDATE_ERROR);
            }
        }
        LecturerAudit lecturerAudit = LecturerAuditMapStruct.INSTANCE
                .DT2P(lecturerAuditDTO);

        boolean update = this.updateById(lecturerAudit);

        if (!update){
            throw new BaseException(LecturerAuditEnum.UPDATE_ERROR);
        }

        return true;
    }

    @Override
    public LecturerAuditBO getLecturerAudit(LecturerAuditDTO lecturerAuditDTO) {
        LecturerAudit lecturerAudit = this.getById(lecturerAuditDTO.getId());
        if (lecturerAudit == null){
            throw new BaseException(LecturerAuditEnum.GET_ERROR);
        }
        LecturerAuditBO lecturerAuditBO = LecturerAuditMapStruct.INSTANCE
                .P2B(lecturerAudit);

        LecturerExt lecturerExt = lecturerExtAdminService
                .getLecturerExtByUserNo(lecturerAudit.getLecturerUserNo());
        if (lecturerExt == null){
            throw new BaseException(LecturerAuditEnum.GET_ERROR);
        }

        return lecturerAuditBO.setLecturerExt(lecturerExt);
    }

    @Override
    @Transactional
    public Boolean auditLecturerAudit(LecturerAuditDTO lecturerAuditDTO) {
        if (ObjectUtil.equal(lecturerAuditDTO.getAuditStatus(),AuditStatus.PASS)){
            //查询
            LecturerAudit lecturerAudit = this.getById(lecturerAuditDTO.getId());
            if (lecturerAudit == null){
                throw new BaseException(LecturerAuditEnum.GET_ERROR);
            }

            boolean result = true;
            Lecturer lecturer = LecturerAuditMapStruct.INSTANCE.A2NA(lecturerAudit)
                    .setGmtCreate(null)
                    .setGmtModified(null);
            if (lecturerAdminService.getById(lecturerAudit.getId()) == null){
                //插入
                result = lecturerAdminService.save(lecturer);
            }else{
                //更新
                result = lecturerAdminService.updateById(
                        lecturer.setGmtModified(LocalDateTime.now()));
            }
            if (!result){
                throw new BaseException(LecturerAuditEnum.GET_ERROR);
            }

            UserExt userExt = userExtAdminService
                    .getUserExtByMobile(lecturer.getLecturerMobile());

            if (userExt == null){
                throw new BaseException(LecturerAuditEnum.UPDATE_ERROR);
            }

            boolean update = userExtAdminService.updateById(userExt
                    .setUserType(2)
                    .setGmtModified(LocalDateTime.now()));

            if (!update){
                throw new BaseException(LecturerAuditEnum.GET_ERROR);
            }
        }

        LecturerAudit lecturerAudit = LecturerAuditMapStruct.INSTANCE
                .DT2P(lecturerAuditDTO)
                .setGmtModified(LocalDateTime.now());

        boolean update = this.updateById(lecturerAudit);
        if (!update){
            throw new BaseException(LecturerAuditEnum.GET_ERROR);
        }

        return true;
    }

    @Override
    public Boolean checkLecturerAudit(LecturerAuditDTO lecturerAuditDTO) {
        //查询用户是否存在
        UserExt userExt = userExtAdminService.getUserExtByMobile(
                lecturerAuditDTO.getLecturerMobile());

        if (userExt == null){
            throw new BaseException(LecturerAuditEnum.UPDATE_ERROR);
        }

        LambdaQueryWrapper<LecturerAudit> wrapper = new QueryWrapper<LecturerAudit>()
                .lambda()
                .eq(LecturerAudit::getLecturerUserNo, userExt.getUserNo());

        LecturerAudit lecturerAudit = this.getOne(wrapper);
        if (lecturerAudit == null){
            throw new BaseException(LecturerAuditEnum.UPDATE_ERROR);
        }

        return true;
    }

    public String getByLecturer(BigDecimal totalIncome, BigDecimal historyMoney, BigDecimal enableBalances, BigDecimal freezeBalances) {
        int t = totalIncome.add(historyMoney).add(enableBalances).add(freezeBalances).multiply(new BigDecimal(100)).intValue();
        return SecureUtil.md5("roncoo" + t);
    }
}
