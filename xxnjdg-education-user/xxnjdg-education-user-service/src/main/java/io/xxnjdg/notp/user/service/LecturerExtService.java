package io.xxnjdg.notp.user.service;

import io.xxnjdg.notp.user.object.business.LecturerExtBO;
import io.xxnjdg.notp.user.object.data.transfer.LecturerUserNoDTO;
import io.xxnjdg.notp.user.object.persistent.LecturerExt;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 讲师账户信息表 服务类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-20
 */
public interface LecturerExtService extends IService<LecturerExt> {

    /**
     * LecturerUserNo 获取导师额外信息
     * @param lecturerUserNoDTO lecturerUserNoDTO
     * @return LecturerExtBO
     */
    LecturerExtBO getLecturerExtByLecturerUserNo(LecturerUserNoDTO lecturerUserNoDTO);

}
