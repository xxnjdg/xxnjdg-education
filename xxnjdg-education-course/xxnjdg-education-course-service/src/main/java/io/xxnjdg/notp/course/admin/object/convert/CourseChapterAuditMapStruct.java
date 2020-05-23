package io.xxnjdg.notp.course.admin.object.convert;

import io.xxnjdg.notp.course.admin.object.business.CourseChapterAuditBO;
import io.xxnjdg.notp.course.object.persistent.CourseChapter;
import io.xxnjdg.notp.course.object.persistent.CourseChapterAudit;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/22 21:37
 */
@Mapper
public interface CourseChapterAuditMapStruct {
    CourseChapterAuditMapStruct INSTANCE = Mappers.getMapper(CourseChapterAuditMapStruct.class);

    /**
     * CIA2CI
     * @param courseIntroduceAudit
     * @return
     */
    CourseChapter CCA2CC(CourseChapterAudit courseIntroduceAudit);


    /**
     * P2B
     * @param courseCategory
     * @return
     */
    CourseChapterAuditBO P2B(CourseChapterAudit courseCategory);


    /**
     * P2B
     * @param courseCategoryList
     * @return
     */
    List<CourseChapterAuditBO> P2B(List<CourseChapterAudit> courseCategoryList);
}