package io.xxnjdg.notp.course.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.xxnjdg.notp.course.object.business.CourseAuditBO;
import io.xxnjdg.notp.course.object.business.CourseChapterAuditBO;
import io.xxnjdg.notp.course.object.business.CourseChapterPeriodAuditBO;
import io.xxnjdg.notp.course.object.convert.CourseChapterAuditMapStruct;
import io.xxnjdg.notp.course.object.data.transfer.CourseAuditDTO;
import io.xxnjdg.notp.course.object.data.transfer.InsertCourseChapterAuditDTO;
import io.xxnjdg.notp.course.object.data.transfer.ListCourseChapterAuditDTO;
import io.xxnjdg.notp.course.object.data.transfer.ListCourseChapterPeriodAuditBTO;
import io.xxnjdg.notp.course.object.error.CourseChapterAuditEnum;
import io.xxnjdg.notp.course.object.persistent.CourseChapterAudit;
import io.xxnjdg.notp.course.mapper.CourseChapterAuditMapper;
import io.xxnjdg.notp.course.service.CourseAuditService;
import io.xxnjdg.notp.course.service.CourseChapterAuditService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.course.service.CourseChapterPeriodAuditService;
import io.xxnjdg.notp.utils.config.SnowFlakeId;
import io.xxnjdg.notp.utils.constant.RowStatus;
import io.xxnjdg.notp.utils.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 章节信息-审核 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
@Service
public class CourseChapterAuditServiceImpl extends ServiceImpl<CourseChapterAuditMapper, CourseChapterAudit> implements CourseChapterAuditService {

    @Autowired
    private CourseAuditService courseAuditService;

    @Autowired
    private SnowFlakeId snowFlakeId;

    @Autowired
    private CourseChapterPeriodAuditService courseChapterPeriodAuditService;

    @Override
    public List<CourseChapterAuditBO> listCourseChapterAudit(ListCourseChapterAuditDTO listCourseChapterAuditDTO) {

        LambdaQueryWrapper<CourseChapterAudit> wrapper = new QueryWrapper<CourseChapterAudit>()
                .lambda()
                .eq(CourseChapterAudit::getCourseId, new Long(listCourseChapterAuditDTO.getCourseId()))
                .eq(CourseChapterAudit::getStatusId, RowStatus.ENABLE)
                .orderByAsc(CourseChapterAudit::getSort);

        List<CourseChapterAudit> list = this.list(wrapper);
        List<CourseChapterAuditBO> courseChapterAuditBOS =
                CourseChapterAuditMapStruct.INSTANCE.convertD2B(list);

        ListCourseChapterPeriodAuditBTO listCourseChapterPeriodAuditBTO =
                new ListCourseChapterPeriodAuditBTO();
        if (courseChapterAuditBOS!=null){
            courseChapterAuditBOS.forEach(courseChapterAuditBO -> {
                listCourseChapterPeriodAuditBTO.setChapterId(courseChapterAuditBO.getId().toString());
                List<CourseChapterPeriodAuditBO> courseChapterPeriodAuditBOS =
                        courseChapterPeriodAuditService.listCourseChapterPeriodAudit(listCourseChapterPeriodAuditBTO);
                if(courseChapterPeriodAuditBOS!=null){
                    courseChapterAuditBO.setPeriodNum(courseChapterPeriodAuditBOS.size());
                }
            });
        }

        return courseChapterAuditBOS;
    }

    @Override
    @Transactional
    public CourseChapterAuditBO insertCourseChapterAudit(InsertCourseChapterAuditDTO insertCourseChapterAuditDTO) {
        CourseAuditDTO courseAuditDTO = new CourseAuditDTO()
                .setId(new Long(insertCourseChapterAuditDTO.getCourseId()))
                .setAuditStatus(0);

        CourseAuditBO courseAuditBO = courseAuditService
                .getCourseAuditById(courseAuditDTO);

        if (!ObjectUtil.equal(courseAuditBO.getLecturerUserNo(),insertCourseChapterAuditDTO.getUserNo())){
            throw new BaseException(CourseChapterAuditEnum.INSERT_ERROR);
        }

        //生成主键id
        Snowflake snowflake = IdUtil.createSnowflake(snowFlakeId.getWorkerId(), snowFlakeId.getDataCenterId());
        long id = snowflake.nextId();

        CourseChapterAudit courseChapterAudit = new CourseChapterAudit()
                .setId(id)
                .setSort(new Integer(insertCourseChapterAuditDTO.getSort()))
                .setAuditStatus(0)
                .setCourseId(new Long(insertCourseChapterAuditDTO.getCourseId()))
                .setChapterName(insertCourseChapterAuditDTO.getChapterName())
                .setIsFree(new Integer(insertCourseChapterAuditDTO.getIsFree()));

        boolean save = this.save(courseChapterAudit);
        if (!save){
            throw new BaseException(CourseChapterAuditEnum.INSERT_ERROR);
        }

        courseAuditService.updateCourseAudit(courseAuditDTO);

        return CourseChapterAuditMapStruct.INSTANCE.convertD2B(courseChapterAudit);
    }
}
