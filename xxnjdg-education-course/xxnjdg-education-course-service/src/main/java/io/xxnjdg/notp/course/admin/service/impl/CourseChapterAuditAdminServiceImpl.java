package io.xxnjdg.notp.course.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.course.admin.service.CourseChapterAuditAdminService;
import io.xxnjdg.notp.course.mapper.CourseChapterAuditMapper;
import io.xxnjdg.notp.course.object.persistent.CourseChapterAudit;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/22 21:12
 */
@Service
public class CourseChapterAuditAdminServiceImpl extends ServiceImpl<CourseChapterAuditMapper, CourseChapterAudit> implements CourseChapterAuditAdminService {
    @Override
    public List<CourseChapterAudit> listCourseChapterAuditByCourseId(Long courseId) {
        LambdaQueryWrapper<CourseChapterAudit> wrapper = new QueryWrapper<CourseChapterAudit>()
                .lambda()
                .eq(CourseChapterAudit::getCourseId, courseId);

        return this.list(wrapper);
    }
}
