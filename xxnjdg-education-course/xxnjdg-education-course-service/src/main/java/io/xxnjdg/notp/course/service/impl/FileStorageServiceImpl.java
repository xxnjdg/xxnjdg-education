package io.xxnjdg.notp.course.service.impl;

import io.xxnjdg.notp.course.object.persistent.FileStorage;
import io.xxnjdg.notp.course.mapper.FileStorageMapper;
import io.xxnjdg.notp.course.service.FileStorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文件存储表 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
@Service
public class FileStorageServiceImpl extends ServiceImpl<FileStorageMapper, FileStorage> implements FileStorageService {

}
