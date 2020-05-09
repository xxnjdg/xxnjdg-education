package io.xxnjdg.notp.course.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.xxnjdg.notp.course.object.business.CourseChapterPeriodBO;
import io.xxnjdg.notp.course.object.convert.CourseChapterPeriodDOToBO;
import io.xxnjdg.notp.course.object.persistent.CourseChapterPeriod;
import io.xxnjdg.notp.course.mapper.CourseChapterPeriodMapper;
import io.xxnjdg.notp.course.service.CourseChapterPeriodService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.utils.constant.RowStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 课时信息 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
@Service
public class CourseChapterPeriodServiceImpl extends ServiceImpl<CourseChapterPeriodMapper, CourseChapterPeriod> implements CourseChapterPeriodService {

    @Override
    public List<CourseChapterPeriodBO> listCourseChapterPeriodByChapterId(Long chapterId) {

        LambdaQueryWrapper<CourseChapterPeriod> courseChapterPeriodLambdaQueryWrapper =
                new QueryWrapper<CourseChapterPeriod>()
                        .lambda()
                        .eq(CourseChapterPeriod::getChapterId, chapterId)
                        .eq(CourseChapterPeriod::getStatusId, RowStatus.ENABLE)
                        .orderByAsc(CourseChapterPeriod::getSort);

        List<CourseChapterPeriod> list = this.list(courseChapterPeriodLambdaQueryWrapper);


        return CourseChapterPeriodDOToBO.INSTANCE.convert(list);
    }
}
