package io.xxnjdg.notp.user.mapper;

import io.xxnjdg.notp.user.model.UserExt;
import io.xxnjdg.notp.user.model.UserExtExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserExtMapper {
    long countByExample(UserExtExample example);

    int deleteByExample(UserExtExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserExt record);

    int insertSelective(UserExt record);

    List<UserExt> selectByExample(UserExtExample example);

    UserExt selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserExt record, @Param("example") UserExtExample example);

    int updateByExample(@Param("record") UserExt record, @Param("example") UserExtExample example);

    int updateByPrimaryKeySelective(UserExt record);

    int updateByPrimaryKey(UserExt record);
}