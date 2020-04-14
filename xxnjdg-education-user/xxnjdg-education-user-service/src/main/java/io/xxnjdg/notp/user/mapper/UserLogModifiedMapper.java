package io.xxnjdg.notp.user.mapper;

import io.xxnjdg.notp.user.model.UserLogModified;
import io.xxnjdg.notp.user.model.UserLogModifiedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLogModifiedMapper {
    long countByExample(UserLogModifiedExample example);

    int deleteByExample(UserLogModifiedExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserLogModified record);

    int insertSelective(UserLogModified record);

    List<UserLogModified> selectByExample(UserLogModifiedExample example);

    UserLogModified selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserLogModified record, @Param("example") UserLogModifiedExample example);

    int updateByExample(@Param("record") UserLogModified record, @Param("example") UserLogModifiedExample example);

    int updateByPrimaryKeySelective(UserLogModified record);

    int updateByPrimaryKey(UserLogModified record);
}