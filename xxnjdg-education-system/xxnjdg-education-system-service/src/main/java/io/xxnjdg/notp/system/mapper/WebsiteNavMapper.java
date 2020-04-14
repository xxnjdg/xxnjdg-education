package io.xxnjdg.notp.system.mapper;

import io.xxnjdg.notp.system.model.WebsiteNav;
import io.xxnjdg.notp.system.model.WebsiteNavExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebsiteNavMapper {
    long countByExample(WebsiteNavExample example);

    int deleteByExample(WebsiteNavExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WebsiteNav record);

    int insertSelective(WebsiteNav record);

    List<WebsiteNav> selectByExample(WebsiteNavExample example);

    WebsiteNav selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WebsiteNav record, @Param("example") WebsiteNavExample example);

    int updateByExample(@Param("record") WebsiteNav record, @Param("example") WebsiteNavExample example);

    int updateByPrimaryKeySelective(WebsiteNav record);

    int updateByPrimaryKey(WebsiteNav record);
}