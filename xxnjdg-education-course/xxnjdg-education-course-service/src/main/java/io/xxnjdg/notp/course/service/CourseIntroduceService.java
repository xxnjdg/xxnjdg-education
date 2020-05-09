package io.xxnjdg.notp.course.service;

import io.xxnjdg.notp.course.object.business.CourseIntroduceBO;
import io.xxnjdg.notp.course.object.persistent.CourseIntroduce;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程介绍信息 服务类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
public interface CourseIntroduceService extends IService<CourseIntroduce> {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    CourseIntroduceBO getCourseIntroduceById(Long id);

}
