package io.xxnjdg.notp.course.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.course.admin.service.CourseChapterAdminService;
import io.xxnjdg.notp.course.mapper.CourseChapterMapper;
import io.xxnjdg.notp.course.object.persistent.CourseChapter;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/22 21:14
 */
@Service
public class CourseChapterAdminServiceImpl extends ServiceImpl<CourseChapterMapper, CourseChapter> implements CourseChapterAdminService {
    @Override
    public List<CourseChapter> listCourseChapterByCourseId(Long courseId) {
        LambdaQueryWrapper<CourseChapter> wrapper = new QueryWrapper<CourseChapter>()
                .lambda()
                .eq(CourseChapter::getCourseId, courseId);

        return this.list(wrapper);
    }
}
