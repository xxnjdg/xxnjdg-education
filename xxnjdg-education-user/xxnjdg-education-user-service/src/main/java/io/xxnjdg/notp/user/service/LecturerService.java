package io.xxnjdg.notp.user.service;

import io.xxnjdg.notp.user.object.business.LecturerBO;
import io.xxnjdg.notp.user.object.data.transfer.LecturerUserNoDTO;
import io.xxnjdg.notp.user.object.persistent.Lecturer;
import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.user.object.view.LecturerUserNoVO;
import io.xxnjdg.notp.user.object.view.LecturerVO;

/**
 * <p>
 * 讲师信息 服务类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-20
 */
public interface LecturerService extends IService<Lecturer> {


    /**
     * LecturerUserNo 获取导师
     * @param lecturerUserNoDTO
     * @return LecturerBO
     */
    LecturerBO getLecturerByLecturerUserNo(LecturerUserNoDTO lecturerUserNoDTO);

    /**
     * LecturerUserNo 获取导师和额外信息
     * @param lecturerUserNoDTO
     * @return
     */
    LecturerBO getLecturerAndExtByLecturerUserNo(LecturerUserNoDTO lecturerUserNoDTO);
}
