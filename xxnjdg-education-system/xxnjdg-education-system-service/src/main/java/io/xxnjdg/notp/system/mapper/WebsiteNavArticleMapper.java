package io.xxnjdg.notp.system.mapper;

import io.xxnjdg.notp.system.model.WebsiteNavArticle;
import io.xxnjdg.notp.system.model.WebsiteNavArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebsiteNavArticleMapper {
    long countByExample(WebsiteNavArticleExample example);

    int deleteByExample(WebsiteNavArticleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WebsiteNavArticle record);

    int insertSelective(WebsiteNavArticle record);

    List<WebsiteNavArticle> selectByExampleWithBLOBs(WebsiteNavArticleExample example);

    List<WebsiteNavArticle> selectByExample(WebsiteNavArticleExample example);

    WebsiteNavArticle selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WebsiteNavArticle record, @Param("example") WebsiteNavArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") WebsiteNavArticle record, @Param("example") WebsiteNavArticleExample example);

    int updateByExample(@Param("record") WebsiteNavArticle record, @Param("example") WebsiteNavArticleExample example);

    int updateByPrimaryKeySelective(WebsiteNavArticle record);

    int updateByPrimaryKeyWithBLOBs(WebsiteNavArticle record);

    int updateByPrimaryKey(WebsiteNavArticle record);
}