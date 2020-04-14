package io.xxnjdg.notp.system.mapper;

import io.xxnjdg.notp.system.model.Website;
import io.xxnjdg.notp.system.model.WebsiteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebsiteMapper {
    long countByExample(WebsiteExample example);

    int deleteByExample(WebsiteExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Website record);

    int insertSelective(Website record);

    List<Website> selectByExampleWithBLOBs(WebsiteExample example);

    List<Website> selectByExample(WebsiteExample example);

    Website selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Website record, @Param("example") WebsiteExample example);

    int updateByExampleWithBLOBs(@Param("record") Website record, @Param("example") WebsiteExample example);

    int updateByExample(@Param("record") Website record, @Param("example") WebsiteExample example);

    int updateByPrimaryKeySelective(Website record);

    int updateByPrimaryKeyWithBLOBs(Website record);

    int updateByPrimaryKey(Website record);
}