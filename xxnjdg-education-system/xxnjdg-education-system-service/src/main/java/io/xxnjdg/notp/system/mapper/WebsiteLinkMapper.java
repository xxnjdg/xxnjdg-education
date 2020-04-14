package io.xxnjdg.notp.system.mapper;

import io.xxnjdg.notp.system.model.WebsiteLink;
import io.xxnjdg.notp.system.model.WebsiteLinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebsiteLinkMapper {
    long countByExample(WebsiteLinkExample example);

    int deleteByExample(WebsiteLinkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WebsiteLink record);

    int insertSelective(WebsiteLink record);

    List<WebsiteLink> selectByExample(WebsiteLinkExample example);

    WebsiteLink selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WebsiteLink record, @Param("example") WebsiteLinkExample example);

    int updateByExample(@Param("record") WebsiteLink record, @Param("example") WebsiteLinkExample example);

    int updateByPrimaryKeySelective(WebsiteLink record);

    int updateByPrimaryKey(WebsiteLink record);
}