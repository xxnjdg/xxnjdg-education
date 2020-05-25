package io.xxnjdg.notp.user.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.user.admin.object.business.LecturerBO;
import io.xxnjdg.notp.user.admin.object.data.transfer.LecturerDTO;
import io.xxnjdg.notp.user.object.persistent.Lecturer;
import io.xxnjdg.notp.utils.response.PageResult;

import java.util.Collection;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/23 15:51
 */
public interface LecturerAdminService extends IService<Lecturer> {
    /**
     * 分页查询列表
     * @param lecturerDTO
     * @return
     */
    PageResult<LecturerBO> listLecturerByPage(LecturerDTO lecturerDTO);

    /**
     * 查询
     * @param lecturerName
     * @return
     */
    List<Lecturer> listLecturerByLecturerName(String lecturerName);

    /**
     * 查询
     * @param userNoList
     * @return
     */
    List<Lecturer> listLecturerByUserNos(Collection<Long> userNoList);

    /**
     * 更新
     * @param lecturerDTO
     * @return
     */
    Boolean updateLecturer(LecturerDTO lecturerDTO);

    /**
     * 查询
     * @param lecturerDTO
     * @return
     */
    LecturerBO getLecturer(LecturerDTO lecturerDTO);
}
