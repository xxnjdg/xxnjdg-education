package io.xxnjdg.notp.user.object.convert;

import io.xxnjdg.notp.user.object.business.LecturerBO;
import io.xxnjdg.notp.user.object.business.LecturerExtBO;
import io.xxnjdg.notp.user.object.view.LecturerExtVO;
import io.xxnjdg.notp.user.object.view.LecturerUserNoVO;
import io.xxnjdg.notp.user.object.view.LecturerVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-8 下午10:31
 */
@Mapper
public interface LecturerBOToVO {
    LecturerBOToVO INSTANCE = Mappers.getMapper(LecturerBOToVO.class);

    /**
     * 转换
     * @param lecturerBO
     * @return
     */
    LecturerUserNoVO convert(LecturerBO lecturerBO);

    /**
     * 转换
     * @param lecturerBO lecturerBO
     * @return
     */
    LecturerVO convertLecturerVO(LecturerBO lecturerBO);

    /**
     * 转换
     * @param lecturerExtBO lecturerExtBO
     * @return
     */
    LecturerExtVO convertLecturerExtVO(LecturerExtBO lecturerExtBO);
}