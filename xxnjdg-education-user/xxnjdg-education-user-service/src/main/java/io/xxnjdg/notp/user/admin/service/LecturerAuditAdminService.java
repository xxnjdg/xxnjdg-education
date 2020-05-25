package io.xxnjdg.notp.user.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.user.admin.object.business.LecturerAuditBO;
import io.xxnjdg.notp.user.admin.object.data.transfer.LecturerAuditDTO;
import io.xxnjdg.notp.user.object.persistent.LecturerAudit;
import io.xxnjdg.notp.utils.response.PageResult;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/24 16:02
 */
public interface LecturerAuditAdminService extends IService<LecturerAudit> {
    /**
     * 分页查询列表
     * @param lecturerAuditDTO
     * @return
     */
    PageResult<LecturerAuditBO> listLecturerAuditByPage(LecturerAuditDTO lecturerAuditDTO);

    /**
     * 插入
     * @param lecturerAuditDTO
     * @return
     */
    Boolean saveLecturerAudit(LecturerAuditDTO lecturerAuditDTO);

    /**
     * 更新
     * @param lecturerAuditDTO
     * @return
     */
    Boolean updateLecturerAudit(LecturerAuditDTO lecturerAuditDTO);

    /**
     * 查询
     * @param lecturerAuditDTO
     * @return
     */
    LecturerAuditBO getLecturerAudit(LecturerAuditDTO lecturerAuditDTO);

    /**
     * 审核
     * @param lecturerAuditDTO
     * @return
     */
    Boolean auditLecturerAudit(LecturerAuditDTO lecturerAuditDTO);

    /**
     * check
     * @param lecturerAuditDTO
     * @return
     */
    Boolean checkLecturerAudit(LecturerAuditDTO lecturerAuditDTO);
}
