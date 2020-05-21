package io.xxnjdg.notp.course.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.course.admin.object.business.CourseBO;
import io.xxnjdg.notp.course.admin.object.convert.CourseMapStruct;
import io.xxnjdg.notp.course.admin.object.data.transfer.CourseDTO;
import io.xxnjdg.notp.course.admin.object.error.CourseEnum;
import io.xxnjdg.notp.course.admin.service.CourseAdminService;
import io.xxnjdg.notp.course.mapper.CourseMapper;
import io.xxnjdg.notp.course.object.persistent.Course;
import io.xxnjdg.notp.utils.exception.BaseException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/21 16:23
 */
@Service
public class CourseAdminServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseAdminService {
    @Override
    public List<CourseBO> getCourseByCourseName(CourseDTO courseDTO) {
        LambdaQueryWrapper<Course> wrapper = new QueryWrapper<Course>()
                .lambda()
                .like(Course::getCourseName, courseDTO.getCourseName());

        return CourseMapStruct.INSTANCE.P2B(this.list(wrapper));
    }

    @Override
    public CourseBO getCourseById(CourseDTO courseDTO) {
        Course course = this.getById(courseDTO.getId());
        if (course == null){
            throw new BaseException(CourseEnum.GET_ERROR);
        }
        return CourseMapStruct.INSTANCE.P2B(course);
    }

    @Override
    public List<CourseBO> getCourseByMap(CourseDTO courseDTO) {
        Course course = CourseMapStruct.INSTANCE.DT2P(courseDTO);
        Map<String, Object> map = BeanUtil.beanToMap(course, true, true);
        List<Course> courses = this.baseMapper.selectByMap(map);
        if (CollUtil.isEmpty(courses)){
            throw new BaseException(CourseEnum.GET_ERROR);
        }
        return CourseMapStruct.INSTANCE.P2B(courses);
    }
}
