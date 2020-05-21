package io.xxnjdg.notp.course.admin.object.convert;

import io.xxnjdg.notp.course.admin.object.business.ZoneCourseBO;
import io.xxnjdg.notp.course.admin.object.data.transfer.ZoneCourseDTO;
import io.xxnjdg.notp.course.admin.object.view.ZoneCoursePageVO;
import io.xxnjdg.notp.course.object.persistent.ZoneCourse;
import io.xxnjdg.notp.utils.response.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/21 14:42
 */
@Mapper
public interface ZoneCourseMapStruct {
    ZoneCourseMapStruct INSTANCE = Mappers.getMapper(ZoneCourseMapStruct.class);

    /**
     * P2B
     * @param zone
     * @return
     */
    ZoneCourse DT2P(ZoneCourseDTO zone);

    /**
     * P2B
     * @param zone
     * @return
     */
    ZoneCourseBO P2B(ZoneCourse zone);


    /**
     * P2B
     * @param zoneList
     * @return
     */
    List<ZoneCourseBO> P2B(List<ZoneCourse> zoneList);

    /**
     * B2V
     * @param zoneBO
     * @return
     */
//    ZoneVO B2V(ZoneBO zoneBO);

    /**
     * B2V
     * @param zoneCourseBO
     * @return
     */
    ZoneCoursePageVO B2PV(ZoneCourseBO zoneCourseBO);

    /**
     * B2V
     * @param zoneCourseBOList
     * @return
     */
    List<ZoneCoursePageVO> B2PV(List<ZoneCourseBO> zoneCourseBOList);

    /**
     * B2V
     * @param result
     * @return
     */
    PageResult<ZoneCoursePageVO> B2PV(PageResult<ZoneCourseBO> result);
}