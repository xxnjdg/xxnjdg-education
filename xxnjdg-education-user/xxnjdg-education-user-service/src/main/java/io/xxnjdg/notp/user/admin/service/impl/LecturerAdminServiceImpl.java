package io.xxnjdg.notp.user.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.user.admin.service.LecturerAdminService;
import io.xxnjdg.notp.user.mapper.LecturerMapper;
import io.xxnjdg.notp.user.object.persistent.Lecturer;
import org.springframework.stereotype.Service;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/23 15:51
 */
@Service
public class LecturerAdminServiceImpl extends ServiceImpl<LecturerMapper, Lecturer> implements LecturerAdminService {
}
