package io.xxnjdg.notp.user.mapper;

import io.xxnjdg.notp.user.object.persistent.Lecturer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.xxnjdg.notp.user.object.view.LecturerVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 分页查询列表
     * @param statusId
     * @param lecturerMobile
     * @param lecturerName
     * @param offset
     * @param size
     * @return
     */
    List<Lecturer> listLecturerByPage(
            @Param("statusId") Integer statusId,
            @Param("lecturerMobile") String lecturerMobile,
            @Param("lecturerName") String lecturerName,
            @Param("offset") Integer offset,
            @Param("size") Integer size);

}
