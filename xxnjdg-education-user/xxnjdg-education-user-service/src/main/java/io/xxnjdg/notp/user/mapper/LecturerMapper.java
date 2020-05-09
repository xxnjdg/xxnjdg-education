package io.xxnjdg.notp.user.mapper;

import io.xxnjdg.notp.user.object.persistent.Lecturer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.xxnjdg.notp.user.object.view.LecturerVO;

/**
 * <p>
 * 讲师信息 Mapper 接口
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-20
 */
public interface LecturerMapper extends BaseMapper<Lecturer> {

    /**
     * s
     * @param lecturerUserNo lecturerUserNo
     * @return LecturerVO
     */
    LecturerVO getLecturerByLecturerUserNo(Long lecturerUserNo);
}
