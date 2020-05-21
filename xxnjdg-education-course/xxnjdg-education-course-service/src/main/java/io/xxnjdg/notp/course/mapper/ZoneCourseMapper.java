package io.xxnjdg.notp.course.mapper;

import io.xxnjdg.notp.course.object.persistent.ZoneCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 专区课程关联表 Mapper 接口
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
public interface ZoneCourseMapper extends BaseMapper<ZoneCourse> {

    /**
     * 分页查询列表
     * @param zoneId
     * @param courseIds
     * @param offset
     * @param size
     * @return
     */
    List<ZoneCourse> listZoneCourseByPage(
            @Param("zoneId") Long zoneId,
            @Param("courseIds") List<Long> courseIds,
            @Param("offset") Integer offset,
            @Param("size") Integer size);
}
