package io.xxnjdg.notp.course.mapper;

import io.xxnjdg.notp.course.model.FileStorage;
import io.xxnjdg.notp.course.model.FileStorageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FileStorageMapper {
    long countByExample(FileStorageExample example);

    int deleteByExample(FileStorageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FileStorage record);

    int insertSelective(FileStorage record);

    List<FileStorage> selectByExample(FileStorageExample example);

    FileStorage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FileStorage record, @Param("example") FileStorageExample example);

    int updateByExample(@Param("record") FileStorage record, @Param("example") FileStorageExample example);

    int updateByPrimaryKeySelective(FileStorage record);

    int updateByPrimaryKey(FileStorage record);
}