package io.xxnjdg.notp.course.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import io.xxnjdg.notp.course.object.business.CourseIntroduceAuditBO;
import io.xxnjdg.notp.course.object.convert.CourseIntroduceAuditMapStruct;
import io.xxnjdg.notp.course.object.error.CourseIntroduceAuditEnum;
import io.xxnjdg.notp.course.object.persistent.CourseIntroduceAudit;
import io.xxnjdg.notp.course.mapper.CourseIntroduceAuditMapper;
import io.xxnjdg.notp.course.service.CourseIntroduceAuditService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.utils.config.SnowFlakeId;
import io.xxnjdg.notp.utils.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程介绍信息-审核 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
@Service
public class CourseIntroduceAuditServiceImpl extends ServiceImpl<CourseIntroduceAuditMapper, CourseIntroduceAudit> implements CourseIntroduceAuditService {

    @Autowired
    private SnowFlakeId snowFlakeId;

    @Override
    public CourseIntroduceAuditBO insertCourseIntroduceAudit(String introduce) {

        //生成主键id
        Snowflake snowflake = IdUtil.createSnowflake(snowFlakeId.getWorkerId(), snowFlakeId.getDataCenterId());
        long id = snowflake.nextId();

        CourseIntroduceAudit courseIntroduceAudit =
                new CourseIntroduceAudit()
                        .setId(id)
                        .setIntroduce(introduce);

        boolean save = this.save(courseIntroduceAudit);

        if (!save){
            throw new BaseException(CourseIntroduceAuditEnum.INSERT_ERROR);
        }

        return CourseIntroduceAuditMapStruct.INSTANCE.convertD2B(courseIntroduceAudit);
    }
}
