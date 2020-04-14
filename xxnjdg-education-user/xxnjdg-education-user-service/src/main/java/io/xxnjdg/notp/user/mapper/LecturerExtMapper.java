package io.xxnjdg.notp.user.mapper;

import io.xxnjdg.notp.user.model.LecturerExt;
import io.xxnjdg.notp.user.model.LecturerExtExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LecturerExtMapper {
    long countByExample(LecturerExtExample example);

    int deleteByExample(LecturerExtExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LecturerExt record);

    int insertSelective(LecturerExt record);

    List<LecturerExt> selectByExample(LecturerExtExample example);

    LecturerExt selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LecturerExt record, @Param("example") LecturerExtExample example);

    int updateByExample(@Param("record") LecturerExt record, @Param("example") LecturerExtExample example);

    int updateByPrimaryKeySelective(LecturerExt record);

    int updateByPrimaryKey(LecturerExt record);
}