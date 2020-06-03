package io.xxnjdg.notp.course.portal.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.course.mapper.OrderInfoMapper;
import io.xxnjdg.notp.course.object.persistent.Course;
import io.xxnjdg.notp.course.object.persistent.OrderInfo;
import io.xxnjdg.notp.course.portal.object.business.OrderInfoBO;
import io.xxnjdg.notp.course.portal.object.convert.OrderInfoMapStruct;
import io.xxnjdg.notp.course.portal.object.data.transfer.order.info.OrderInfoPageDTO;
import io.xxnjdg.notp.course.portal.service.CoursePortalService;
import io.xxnjdg.notp.course.portal.service.OrderInfoPortalService;
import io.xxnjdg.notp.utils.custom.utils.PageObjectUtil;
import io.xxnjdg.notp.utils.objects.PageObject;
import io.xxnjdg.notp.utils.response.PageResult;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/29 20:23
 */
@Service
public class OrderInfoPortalServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoPortalService {

    @Autowired
    private CoursePortalService coursePortalService;

    @Override
    public PageResult<OrderInfoBO> listOrderInfoByPage(OrderInfoPageDTO orderInfoPageDTO) {

        PageResult<OrderInfoBO> result = new PageResult<>();
        Long userNo = orderInfoPageDTO.getUserNo();

        //算总数
        LambdaQueryWrapper<OrderInfo> wrapper = new QueryWrapper<OrderInfo>()
                .lambda()
                .eq(OrderInfo::getUserNo, userNo)
                .eq(OrderInfo::getIsShowUser,1);

        Integer orderStatus = orderInfoPageDTO.getOrderStatus();
        if (orderStatus!=null && !ObjectUtil.equal(orderStatus,0)){
            wrapper.eq(OrderInfo::getOrderStatus,orderStatus);
        }else{
            orderStatus = null;
        }

        int count = this.count(wrapper);

        //条数为0
        if (count == 0) {
            return result;
        }

        PageObject pageObject = PageObjectUtil.countPageOffsetAndSize(
                orderInfoPageDTO.getPageCurrent(), orderInfoPageDTO.getPageSize(), count);

        //查询
        List<OrderInfo> orderInfoList =
                this.baseMapper.listOrderInfoPortalByPage(userNo, orderStatus, pageObject.getOffset(), pageObject.getSize());

        List<OrderInfoBO> orderInfoBOList = OrderInfoMapStruct.INSTANCE.P2B(orderInfoList);

        //设置logo
        Set<Long> ids = orderInfoBOList.stream().map(OrderInfoBO::getCourseId).collect(Collectors.toSet());

        //查询没带statusId课程,只需要logo没什么问题
        List<Course> courseList = coursePortalService.listByIds(ids);

        if (CollUtil.isNotEmpty(courseList)){
            orderInfoBOList.forEach(orderInfoBO -> courseList.forEach(course -> {
                if (ObjectUtil.equal(course.getId(),orderInfoBO.getCourseId())){
                    orderInfoBO.setCourseLogo(course.getCourseLogo());
                }
            }));
        }

        return result
                .setCurrentList(orderInfoBOList)
                .setTotalCount((long) count)
                .setTotalPage(pageObject.getTotalPage())
                .setCurrentPage(pageObject.getCurrentPage())
                .setCurrentListSize((long) orderInfoBOList.size());
    }
}
