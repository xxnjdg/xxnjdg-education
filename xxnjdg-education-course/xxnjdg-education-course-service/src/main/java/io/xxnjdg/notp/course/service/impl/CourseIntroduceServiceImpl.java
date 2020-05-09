package io.xxnjdg.notp.course.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.xxnjdg.notp.course.object.business.CourseIntroduceBO;
import io.xxnjdg.notp.course.object.convert.CourseIntroduceDOToBO;
import io.xxnjdg.notp.course.object.error.CourseIntroduceEnum;
import io.xxnjdg.notp.course.object.persistent.CourseIntroduce;
import io.xxnjdg.notp.course.mapper.CourseIntroduceMapper;
import io.xxnjdg.notp.course.service.CourseIntroduceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.utils.exception.BaseException;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程介绍信息 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
@Service
public class CourseIntroduceServiceImpl extends ServiceImpl<CourseIntroduceMapper, CourseIntroduce> implements CourseIntroduceService {

    @Override
    public CourseIntroduceBO getCourseIntroduceById(Long id) {

        LambdaQueryWrapper<CourseIntroduce> queryWrapper =
                new QueryWrapper<CourseIntroduce>()
                        .lambda()
                        .eq(CourseIntroduce::getId, id);

        CourseIntroduce one = this.getOne(queryWrapper);
        if (one == null){
            throw new BaseException(CourseIntroduceEnum.COURSE_INTRODUCE_NOT_FOUND_ERROR);
        }
        return CourseIntroduceDOToBO.INSTANCE.convert(one);
    }
}
