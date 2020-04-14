package io.xxnjdg.notp.course.mapper;

import io.xxnjdg.notp.course.model.Zone;
import io.xxnjdg.notp.course.model.ZoneExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZoneMapper {
    long countByExample(ZoneExample example);

    int deleteByExample(ZoneExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Zone record);

    int insertSelective(Zone record);

    List<Zone> selectByExample(ZoneExample example);

    Zone selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Zone record, @Param("example") ZoneExample example);

    int updateByExample(@Param("record") Zone record, @Param("example") ZoneExample example);

    int updateByPrimaryKeySelective(Zone record);

    int updateByPrimaryKey(Zone record);
}