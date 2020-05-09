package io.xxnjdg.notp.user.apis;

import io.xxnjdg.notp.user.object.view.LecturerVO;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-28 下午1:38
 */
@FeignClient("xxnjdg-user-service")
public interface LecturerControllerApi {

    /**
     * 使用lecturerUserNo获取Lecturer
     * @param lecturerUserNo lecturerUserNo
     * @return LecturerVO
     */
    @GetMapping("/feign/user/lecturer/getByLecturerUserNo/{lecturerUserNo}")
    ResponseResult<LecturerVO> getLecturerByLecturerUserNo(@PathVariable("lecturerUserNo") Long lecturerUserNo);

}
