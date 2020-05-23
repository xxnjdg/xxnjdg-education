package io.xxnjdg.notp.course.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.course.admin.service.CourseChapterPeriodAdminService;
import io.xxnjdg.notp.course.mapper.CourseChapterPeriodMapper;
import io.xxnjdg.notp.course.object.persistent.CourseChapterPeriod;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/22 21:16
 */
@Service
public class CourseChapterPeriodAdminServiceImpl extends ServiceImpl<CourseChapterPeriodMapper, CourseChapterPeriod> implements CourseChapterPeriodAdminService {
    @Override
    public List<CourseChapterPeriod> listCourseChapterPeriodByCourseId(Long courseId) {
        LambdaQueryWrapper<CourseChapterPeriod> wrapper = new QueryWrapper<CourseChapterPeriod>()
                .lambda()
                .eq(CourseChapterPeriod::getCourseId, courseId);
        return this.list(wrapper);
    }
}
