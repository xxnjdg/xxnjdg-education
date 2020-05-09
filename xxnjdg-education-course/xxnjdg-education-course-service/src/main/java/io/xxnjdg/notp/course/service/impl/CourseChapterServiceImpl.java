package io.xxnjdg.notp.course.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.xxnjdg.notp.course.object.business.CourseChapterBO;
import io.xxnjdg.notp.course.object.convert.CourseChapterDOToBO;
import io.xxnjdg.notp.course.object.persistent.CourseChapter;
import io.xxnjdg.notp.course.mapper.CourseChapterMapper;
import io.xxnjdg.notp.course.object.view.CourseChapterLevelVO;
import io.xxnjdg.notp.course.service.CourseChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.utils.constant.RowStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 章节信息 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
@Service
public class CourseChapterServiceImpl extends ServiceImpl<CourseChapterMapper, CourseChapter> implements CourseChapterService {

    @Override
    public List<CourseChapterLevelVO> queryCourseChapterLevelListByCourseId(Long courseId) {
        return this.baseMapper.queryCourseChapterLevelListByCourseId(courseId);
    }

    @Override
    public List<CourseChapterBO> listCourseChapterByCourseId(Long courseId) {
        LambdaQueryWrapper<CourseChapter> wrapper = new QueryWrapper<CourseChapter>()
                .lambda()
                .eq(CourseChapter::getCourseId, courseId)
                .eq(CourseChapter::getStatusId, RowStatus.ENABLE)
                .orderByAsc(CourseChapter::getSort);

        List<CourseChapter> list = this.list(wrapper);

        return CourseChapterDOToBO.INSTANCE.convert(list);
    }
}
