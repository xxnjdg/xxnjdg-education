package io.xxnjdg.notp.user.object.convert;

import io.xxnjdg.notp.user.object.business.LecturerExtBO;
import io.xxnjdg.notp.user.object.view.LecturerVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-8 下午11:42
 */
@Mapper
public interface LecturerExtBOToVO {
    LecturerExtBOToVO INSTANCE = Mappers.getMapper(LecturerExtBOToVO.class);

    /**
     * 转换
     * @param lecturerBO
     * @return
     */
    LecturerVO convert(LecturerExtBO lecturerBO);
}