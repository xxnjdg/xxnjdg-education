package io.xxnjdg.notp.course.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import io.xxnjdg.notp.course.object.business.CourseIntroduceAuditBO;
import io.xxnjdg.notp.course.object.convert.CourseIntroduceAuditMapStruct;
import io.xxnjdg.notp.course.object.data.transfer.CourseIntroduceAuditDTO;
import io.xxnjdg.notp.course.object.error.CourseIntroduceAuditEnum;
import io.xxnjdg.notp.course.object.persistent.CourseIntroduceAudit;
import io.xxnjdg.notp.course.mapper.CourseIntroduceAuditMapper;
import io.xxnjdg.notp.course.service.CourseIntroduceAuditService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.utils.config.SnowFlakeId;
import io.xxnjdg.notp.utils.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

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
    public CourseIntroduceAuditBO insertCourseIntroduceAudit(CourseIntroduceAuditDTO courseIntroduceAuditDTO) {

        //生成主键id
        Snowflake snowflake = IdUtil.createSnowflake(snowFlakeId.getWorkerId(), snowFlakeId.getDataCenterId());
        long id = snowflake.nextId();

        CourseIntroduceAudit courseIntroduceAudit =
                new CourseIntroduceAudit()
                        .setId(id)
                        .setIntroduce(courseIntroduceAuditDTO.getIntroduce());

        boolean save = this.save(courseIntroduceAudit);

        if (!save){
            throw new BaseException(CourseIntroduceAuditEnum.INSERT_ERROR);
        }

        return CourseIntroduceAuditMapStruct.INSTANCE.convertD2B(courseIntroduceAudit);
    }

    @Override
    public CourseIntroduceAuditBO getCourseIntroduceAuditById(CourseIntroduceAuditDTO courseIntroduceAuditDTO) {
        LambdaQueryWrapper<CourseIntroduceAudit> wrapper = new QueryWrapper<CourseIntroduceAudit>()
                .lambda()
                .eq(CourseIntroduceAudit::getId, Long.valueOf(courseIntroduceAuditDTO.getId()));

        CourseIntroduceAudit one = this.getOne(wrapper);
        if (one == null){
            throw new BaseException(CourseIntroduceAuditEnum.GET_ERROR);
        }

        return CourseIntroduceAuditMapStruct.INSTANCE.convertD2B(one);
    }

    @Override
    public CourseIntroduceAuditBO updateCourseIntroduceAudit(CourseIntroduceAuditDTO courseIntroduceAuditDTO) {
        Long id = Long.valueOf(courseIntroduceAuditDTO.getId());
        String introduce = courseIntroduceAuditDTO.getIntroduce();
        LocalDateTime now = LocalDateTime.now();

        LambdaUpdateWrapper<CourseIntroduceAudit> wrapper = new UpdateWrapper<CourseIntroduceAudit>()
                .lambda()
                .eq(CourseIntroduceAudit::getId, id)
                .set(CourseIntroduceAudit::getGmtModified, now)
                .set(CourseIntroduceAudit::getIntroduce, introduce);

        //更新
        boolean update = this.update(wrapper);
        if (!update){
            throw new BaseException(CourseIntroduceAuditEnum.UPDATE_ERROR);
        }

        return new CourseIntroduceAuditBO()
                .setId(id)
                .setIntroduce(introduce)
                .setGmtModified(now);
    }
}
