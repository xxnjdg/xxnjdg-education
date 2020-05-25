package io.xxnjdg.notp.user.mapper;

import io.xxnjdg.notp.user.object.persistent.LecturerAudit;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 讲师信息-审核 Mapper 接口
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-20
 */
public interface LecturerAuditMapper extends BaseMapper<LecturerAudit> {

    /**
     * 分页查询列表
     * @param auditStatus
     * @param statusId
     * @param lecturerMobile
     * @param lecturerName
     * @param offset
     * @param size
     * @return
     */
    List<LecturerAudit> listLecturerAuditByPage(
            @Param("auditStatus") Integer auditStatus,
            @Param("statusId") Integer statusId,
            @Param("lecturerMobile") String lecturerMobile,
            @Param("lecturerName") String lecturerName,
            @Param("offset") Integer offset,
            @Param("size") Integer size);
}
