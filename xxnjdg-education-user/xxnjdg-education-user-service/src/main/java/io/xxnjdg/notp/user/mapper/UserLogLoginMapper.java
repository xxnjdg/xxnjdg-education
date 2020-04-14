package io.xxnjdg.notp.user.mapper;

import io.xxnjdg.notp.user.model.UserLogLogin;
import io.xxnjdg.notp.user.model.UserLogLoginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLogLoginMapper {
    long countByExample(UserLogLoginExample example);

    int deleteByExample(UserLogLoginExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserLogLogin record);

    int insertSelective(UserLogLogin record);

    List<UserLogLogin> selectByExample(UserLogLoginExample example);

    UserLogLogin selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserLogLogin record, @Param("example") UserLogLoginExample example);

    int updateByExample(@Param("record") UserLogLogin record, @Param("example") UserLogLoginExample example);

    int updateByPrimaryKeySelective(UserLogLogin record);

    int updateByPrimaryKey(UserLogLogin record);
}