package io.xxnjdg.notp.system.mapper;

import io.xxnjdg.notp.system.model.NavBar;
import io.xxnjdg.notp.system.model.NavBarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NavBarMapper {
    long countByExample(NavBarExample example);

    int deleteByExample(NavBarExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NavBar record);

    int insertSelective(NavBar record);

    List<NavBar> selectByExample(NavBarExample example);

    NavBar selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NavBar record, @Param("example") NavBarExample example);

    int updateByExample(@Param("record") NavBar record, @Param("example") NavBarExample example);

    int updateByPrimaryKeySelective(NavBar record);

    int updateByPrimaryKey(NavBar record);
}