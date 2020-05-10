package io.xxnjdg.notp.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import io.xxnjdg.notp.user.convert.LecturerToLecturerUserNoVO;
import io.xxnjdg.notp.user.object.business.LecturerBO;
import io.xxnjdg.notp.user.object.business.LecturerExtBO;
import io.xxnjdg.notp.user.object.convert.LecturerDOToBO;
import io.xxnjdg.notp.user.object.data.transfer.LecturerUserNoDTO;
import io.xxnjdg.notp.user.object.data.transfer.UpdateLecturerDTO;
import io.xxnjdg.notp.user.object.error.LecturerEnum;
import io.xxnjdg.notp.user.object.persistent.Lecturer;
import io.xxnjdg.notp.user.mapper.LecturerMapper;
import io.xxnjdg.notp.user.object.view.LecturerUserNoVO;
import io.xxnjdg.notp.user.object.view.LecturerVO;
import io.xxnjdg.notp.user.service.LecturerExtService;
import io.xxnjdg.notp.user.service.LecturerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.utils.constant.RowStatus;
import io.xxnjdg.notp.utils.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * <p>
 * 讲师信息 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-20
 */
@Service
public class LecturerServiceImpl extends ServiceImpl<LecturerMapper, Lecturer> implements LecturerService {

    @Autowired
    private LecturerExtService lecturerExtService;

    @Override
    public LecturerBO getLecturerAndExtByLecturerUserNo(LecturerUserNoDTO lecturerUserNoDTO) {
        LecturerBO lecturerBO = this.getLecturerByLecturerUserNo(lecturerUserNoDTO);
        LecturerExtBO lecturerExtBO =
                lecturerExtService.getLecturerExtByLecturerUserNo(lecturerUserNoDTO);
        lecturerBO.setLecturerExtVO(lecturerExtBO);

        return lecturerBO;
    }

    @Override
    public Boolean updateLecturer(UpdateLecturerDTO updateLecturerDTO) {
        Long lecturerUserNo = new Long(updateLecturerDTO.getLecturerUserNo());

        LambdaUpdateWrapper<Lecturer> wrapper = new UpdateWrapper<Lecturer>()
                .lambda()
                .eq(Lecturer::getLecturerUserNo, lecturerUserNo)
                .eq(Lecturer::getStatusId, RowStatus.ENABLE)
                .set(Lecturer::getLecturerName, updateLecturerDTO.getLecturerName())
                .set(Lecturer::getHeadImgUrl, updateLecturerDTO.getHeadImgUrl())
                .set(Lecturer::getIntroduce, updateLecturerDTO.getIntroduce());

        boolean update = this.update(wrapper);
        if (!update){
            throw new BaseException(LecturerEnum.LECTURER_UPDATE_ERROR);
        }
        return true;
    }

    @Override
    public LecturerBO getLecturerByLecturerUserNo(LecturerUserNoDTO lecturerUserNoDTO) {
        LambdaQueryWrapper<Lecturer> lecturerLambdaQueryWrapper = new QueryWrapper<Lecturer>().lambda()
                .eq(Lecturer::getStatusId, RowStatus.ENABLE)
                .eq(Lecturer::getLecturerUserNo, new Long(lecturerUserNoDTO.getLecturerUserNo()));

        Lecturer lecturer = this.getOne(lecturerLambdaQueryWrapper);

        if (lecturer == null){
            throw new BaseException(LecturerEnum.LECTURER_NULL);
        }

        return LecturerDOToBO.INSTANCE.convert(lecturer);
    }
}
