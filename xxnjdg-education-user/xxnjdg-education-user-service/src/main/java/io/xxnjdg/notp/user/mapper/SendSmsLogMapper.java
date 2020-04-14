package io.xxnjdg.notp.user.mapper;

import io.xxnjdg.notp.user.model.SendSmsLog;
import io.xxnjdg.notp.user.model.SendSmsLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SendSmsLogMapper {
    long countByExample(SendSmsLogExample example);

    int deleteByExample(SendSmsLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SendSmsLog record);

    int insertSelective(SendSmsLog record);

    List<SendSmsLog> selectByExample(SendSmsLogExample example);

    SendSmsLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SendSmsLog record, @Param("example") SendSmsLogExample example);

    int updateByExample(@Param("record") SendSmsLog record, @Param("example") SendSmsLogExample example);

    int updateByPrimaryKeySelective(SendSmsLog record);

    int updateByPrimaryKey(SendSmsLog record);
}