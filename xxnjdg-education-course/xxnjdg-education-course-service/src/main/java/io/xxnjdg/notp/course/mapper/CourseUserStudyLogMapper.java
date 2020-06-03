package io.xxnjdg.notp.course.mapper;

import cn.hutool.core.date.DateTime;
import io.xxnjdg.notp.course.object.persistent.CourseUserStudyLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 课程用户学习日志 Mapper 接口
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
public interface CourseUserStudyLogMapper extends BaseMapper<CourseUserStudyLog> {

    /**
     * 分页查询CourseUserStudyLog列表
     * @param userNo
     * @param offset
     * @param size
     * @return
     */
    List<CourseUserStudyLog> listCourseUserStudyLogByPage(@Param("userNo") Long userNo,@Param("offset") Integer offset,@Param("size") Integer size);

    /**
     * 分页查询CourseUserStudyLog列表
     * @param userNo
     * @param beginGmtCreate
     * @param endGmtCreate
     * @param offset
     * @param size
     * @return
     */
    List<CourseUserStudyLog> listCourseUserStudyLogAdminByPage(
            @Param("userNo") Long userNo,
            @Param("beginGmtCreate") DateTime beginGmtCreate,
            @Param("endGmtCreate") DateTime endGmtCreate,
            @Param("offset") Integer offset,
            @Param("size") Integer size);
}
