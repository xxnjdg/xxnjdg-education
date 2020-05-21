package io.xxnjdg.notp.course.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.course.admin.object.business.ZoneCourseBO;
import io.xxnjdg.notp.course.admin.object.data.transfer.ZoneCourseDTO;
import io.xxnjdg.notp.course.object.persistent.ZoneCourse;
import io.xxnjdg.notp.utils.response.PageResult;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/21 14:37
 */
public interface ZoneCourseAdminService extends IService<ZoneCourse> {
    /**
     * 分页查询ZoneCourse列表
     * @param zoneCourseDTO
     * @return
     */
    PageResult<ZoneCourseBO> listZoneCourseByPage(ZoneCourseDTO zoneCourseDTO);

    /**
     * 插入
     * @param zoneCourseDTO
     * @return
     */
    Boolean saveZoneCourse(ZoneCourseDTO zoneCourseDTO);

    /**
     * 更新
     * @param zoneCourseDTO
     * @return
     */
    Boolean updateZoneCourseById(ZoneCourseDTO zoneCourseDTO);

    /**
     * 删除
     * @param zoneCourseDTO
     * @return
     */
    Boolean deleteZoneCourseById(ZoneCourseDTO zoneCourseDTO);
}
