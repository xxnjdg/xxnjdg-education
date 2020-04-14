package io.xxnjdg.notp.user.mapper;

import io.xxnjdg.notp.user.model.Lecturer;
import io.xxnjdg.notp.user.model.LecturerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LecturerMapper {
    long countByExample(LecturerExample example);

    int deleteByExample(LecturerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Lecturer record);

    int insertSelective(Lecturer record);

    List<Lecturer> selectByExample(LecturerExample example);

    Lecturer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Lecturer record, @Param("example") LecturerExample example);

    int updateByExample(@Param("record") Lecturer record, @Param("example") LecturerExample example);

    int updateByPrimaryKeySelective(Lecturer record);

    int updateByPrimaryKey(Lecturer record);
}