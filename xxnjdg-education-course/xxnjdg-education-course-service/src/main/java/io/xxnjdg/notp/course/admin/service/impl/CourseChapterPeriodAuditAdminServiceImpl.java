package io.xxnjdg.notp.course.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.course.admin.service.CourseChapterPeriodAuditAdminService;
import io.xxnjdg.notp.course.mapper.CourseChapterPeriodAuditMapper;
import io.xxnjdg.notp.course.object.persistent.CourseChapterPeriodAudit;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/22 18:58
 */
@Service
public class CourseChapterPeriodAuditAdminServiceImpl extends ServiceImpl<CourseChapterPeriodAuditMapper, CourseChapterPeriodAudit> implements CourseChapterPeriodAuditAdminService {

    @Override
    public List<CourseChapterPeriodAudit> listCourseChapterPeriodAuditByCourseId(Long courseId) {
        LambdaQueryWrapper<CourseChapterPeriodAudit> wrapper = new QueryWrapper<CourseChapterPeriodAudit>()
                .lambda()
                .eq(CourseChapterPeriodAudit::getCourseId, courseId);

        return this.list(wrapper);
    }
}
