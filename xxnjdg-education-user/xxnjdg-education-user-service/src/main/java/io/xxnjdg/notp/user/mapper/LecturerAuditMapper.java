package io.xxnjdg.notp.user.mapper;

import io.xxnjdg.notp.user.model.LecturerAudit;
import io.xxnjdg.notp.user.model.LecturerAuditExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LecturerAuditMapper {
    long countByExample(LecturerAuditExample example);

    int deleteByExample(LecturerAuditExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LecturerAudit record);

    int insertSelective(LecturerAudit record);

    List<LecturerAudit> selectByExample(LecturerAuditExample example);

    LecturerAudit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LecturerAudit record, @Param("example") LecturerAuditExample example);

    int updateByExample(@Param("record") LecturerAudit record, @Param("example") LecturerAuditExample example);

    int updateByPrimaryKeySelective(LecturerAudit record);

    int updateByPrimaryKey(LecturerAudit record);
}