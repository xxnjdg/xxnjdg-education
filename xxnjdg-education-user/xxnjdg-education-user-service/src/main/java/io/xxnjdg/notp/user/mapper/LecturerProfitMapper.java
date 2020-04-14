package io.xxnjdg.notp.user.mapper;

import io.xxnjdg.notp.user.model.LecturerProfit;
import io.xxnjdg.notp.user.model.LecturerProfitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LecturerProfitMapper {
    long countByExample(LecturerProfitExample example);

    int deleteByExample(LecturerProfitExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LecturerProfit record);

    int insertSelective(LecturerProfit record);

    List<LecturerProfit> selectByExample(LecturerProfitExample example);

    LecturerProfit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LecturerProfit record, @Param("example") LecturerProfitExample example);

    int updateByExample(@Param("record") LecturerProfit record, @Param("example") LecturerProfitExample example);

    int updateByPrimaryKeySelective(LecturerProfit record);

    int updateByPrimaryKey(LecturerProfit record);
}