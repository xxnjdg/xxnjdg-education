package io.xxnjdg.notp.course.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.PageUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.xxnjdg.notp.course.object.business.CourseUserStudyLogBO;
import io.xxnjdg.notp.course.object.convert.CourseUserStudyLogMapStruct;
import io.xxnjdg.notp.course.object.data.transfer.ListCourseUserStudyLogDTO;
import io.xxnjdg.notp.course.object.domain.OrderInfoListDO;
import io.xxnjdg.notp.course.object.persistent.CourseUserStudyLog;
import io.xxnjdg.notp.course.mapper.CourseUserStudyLogMapper;
import io.xxnjdg.notp.course.object.view.OrderInfoListVO;
import io.xxnjdg.notp.course.service.CourseUserStudyLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.utils.constant.DefaultPageValue;
import io.xxnjdg.notp.utils.custom.utils.PageObjectUtil;
import io.xxnjdg.notp.utils.objects.PageObject;
import io.xxnjdg.notp.utils.response.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 课程用户学习日志 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
@Service
public class CourseUserStudyLogServiceImpl extends ServiceImpl<CourseUserStudyLogMapper, CourseUserStudyLog> implements CourseUserStudyLogService {

    @Override
    public PageResult<CourseUserStudyLogBO> listCourseUserStudyLogByPage(ListCourseUserStudyLogDTO listCourseUserStudyLogDTO) {

        Long userNo = listCourseUserStudyLogDTO.getUserNo();
        PageResult<CourseUserStudyLogBO> result = new PageResult<>();

        //算总数
        LambdaQueryWrapper<CourseUserStudyLog> wrapper = new QueryWrapper<CourseUserStudyLog>()
                .lambda()
                .eq(CourseUserStudyLog::getUserNo, userNo);

        int count = this.count(wrapper);

        //条数为0
        if (count == 0){
            return result;
        }

        PageObject pageObject = PageObjectUtil.countPageOffsetAndSize(
                listCourseUserStudyLogDTO.getPageCurrent(), listCourseUserStudyLogDTO.getPageSize(), count);

        //查询
        List<CourseUserStudyLog> courseUserStudyLogs =
                this.baseMapper.listCourseUserStudyLogByPage(userNo, pageObject.getOffset(), pageObject.getSize());

        return result
                .setCurrentList(CourseUserStudyLogMapStruct.INSTANCE.convertD2B(courseUserStudyLogs))
                .setTotalCount((long) count);
    }
}
