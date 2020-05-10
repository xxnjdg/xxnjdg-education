package io.xxnjdg.notp.course.object.convert;

import io.xxnjdg.notp.course.object.business.CourseIntroduceAuditBO;
import io.xxnjdg.notp.course.object.persistent.CourseIntroduceAudit;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-10 下午1:45
 */
@Mapper
public interface CourseIntroduceAuditMapStruct {
    CourseIntroduceAuditMapStruct INSTANCE = Mappers.getMapper(CourseIntroduceAuditMapStruct.class);

    /**
     * 转换
     * @param courseIntroduceAudit
     * @return
     */
    CourseIntroduceAuditBO convertD2B(CourseIntroduceAudit courseIntroduceAudit);
}