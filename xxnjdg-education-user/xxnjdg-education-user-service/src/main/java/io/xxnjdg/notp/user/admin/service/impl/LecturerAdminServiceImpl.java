package io.xxnjdg.notp.user.admin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.user.admin.object.business.LecturerBO;
import io.xxnjdg.notp.user.admin.object.convert.LecturerMapStruct;
import io.xxnjdg.notp.user.admin.object.data.transfer.LecturerDTO;
import io.xxnjdg.notp.user.admin.object.error.LecturerEnum;
import io.xxnjdg.notp.user.admin.service.LecturerAdminService;
import io.xxnjdg.notp.user.admin.service.LecturerAuditAdminService;
import io.xxnjdg.notp.user.admin.service.LecturerExtAdminService;
import io.xxnjdg.notp.user.mapper.LecturerMapper;
import io.xxnjdg.notp.user.object.persistent.Lecturer;
import io.xxnjdg.notp.user.object.persistent.LecturerAudit;
import io.xxnjdg.notp.user.object.persistent.LecturerExt;
import io.xxnjdg.notp.utils.custom.utils.PageObjectUtil;
import io.xxnjdg.notp.utils.exception.BaseException;
import io.xxnjdg.notp.utils.objects.PageObject;
import io.xxnjdg.notp.utils.response.PageResult;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/23 15:51
 */
@Service
public class LecturerAdminServiceImpl extends ServiceImpl<LecturerMapper, Lecturer> implements LecturerAdminService {

    @Autowired
    private LecturerAuditAdminService lecturerAuditAdminService;

    @Autowired
    private LecturerExtAdminService lecturerExtAdminService;

    @Override
    public PageResult<LecturerBO> listLecturerByPage(LecturerDTO lecturerDTO) {
        PageResult<LecturerBO> result = new PageResult<>();

        //算总数
        LambdaQueryWrapper<Lecturer> wrapper = new QueryWrapper<Lecturer>()
                .lambda();

        String lecturerMobile = null;
        String lecturerName = null;
        Integer statusId = lecturerDTO.getStatusId();

        if (StrUtil.isNotBlank(lecturerDTO.getLecturerMobile())) {
            lecturerMobile = lecturerDTO.getLecturerMobile();
            wrapper.like(Lecturer::getLecturerMobile, lecturerMobile);
        }

        if (statusId != null){
            wrapper.eq(Lecturer::getStatusId,statusId);
        }

        if (StrUtil.isNotBlank(lecturerDTO.getLecturerName())) {
            lecturerName = lecturerDTO.getLecturerName();
            wrapper.like(Lecturer::getLecturerName, lecturerName);
        }

        int count = this.count(wrapper);

        //条数为0
        if (count == 0) {
            return result;
        }

        PageObject pageObject = PageObjectUtil.countPageOffsetAndSize(
                lecturerDTO.getPageCurrent(), lecturerDTO.getPageSize(), count);

        //查询
        List<Lecturer> lecturerList =
                this.baseMapper.listLecturerByPage(statusId,lecturerMobile,lecturerName, pageObject.getOffset(), pageObject.getSize());

        List<LecturerBO> lecturerBOList = LecturerMapStruct.INSTANCE.P2B(lecturerList);

        return result
                .setCurrentList(lecturerBOList)
                .setTotalCount((long) count)
                .setTotalPage(pageObject.getTotalPage())
                .setCurrentPage(pageObject.getCurrentPage())
                .setCurrentListSize((long) lecturerBOList.size());
    }

    @Override
    public List<Lecturer> listLecturerByLecturerName(String lecturerName) {
        LambdaQueryWrapper<Lecturer> wrapper = new QueryWrapper<Lecturer>()
                .lambda()
                .like(Lecturer::getLecturerName, lecturerName);
        return this.list(wrapper);
    }

    @Override
    public List<Lecturer> listLecturerByUserNos(Collection<Long> userNoList) {
        LambdaQueryWrapper<Lecturer> wrapper = new QueryWrapper<Lecturer>()
                .lambda()
                .in(Lecturer::getLecturerUserNo, userNoList);
        return this.list(wrapper);
    }

    @Override
    public Boolean updateLecturer(LecturerDTO lecturerDTO) {
        Lecturer lecturer = LecturerMapStruct.INSTANCE.DT2P(lecturerDTO);
        boolean update = this.updateById(lecturer);
        if (!update){
            throw new BaseException(LecturerEnum.UPDATE_ERROR);
        }
        LecturerAudit lecturerAudit = LecturerMapStruct.INSTANCE.NA2A(lecturer);

        boolean update1 = lecturerAuditAdminService.updateById(lecturerAudit);
        if (!update1){
            throw new BaseException(LecturerEnum.UPDATE_ERROR);
        }

        return true;
    }

    @Override
    public LecturerBO getLecturer(LecturerDTO lecturerDTO) {
        Lecturer lecturer = this.getById(lecturerDTO.getId());
        if (lecturer == null){
            throw new BaseException(LecturerEnum.GET_ERROR);
        }
        LecturerExt lecturerExt = lecturerExtAdminService.getLecturerExtByUserNo(
                lecturer.getLecturerUserNo());

        if (lecturerExt == null){
            throw new BaseException(LecturerEnum.GET_ERROR);
        }

        return LecturerMapStruct.INSTANCE.P2B(lecturer)
                .setLecturerExt(lecturerExt);
    }
}
