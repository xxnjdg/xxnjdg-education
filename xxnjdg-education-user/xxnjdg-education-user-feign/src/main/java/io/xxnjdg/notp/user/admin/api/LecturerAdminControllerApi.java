package io.xxnjdg.notp.user.admin.api;

import io.xxnjdg.notp.user.admin.object.view.LecturerVO;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/23 15:48
 */
@FeignClient(value = "xxnjdg-user-service",contextId = "LecturerAdminControllerApi")
public interface LecturerAdminControllerApi {

    /**
     * 通过ids获取Lecturer列表
     * @param ids
     * @return
     */
    @RequestMapping(value = "/feign/user/lecturer/getByLecturerUserNo", method = RequestMethod.GET)
    ResponseResult<List<LecturerVO>> getLecturerByIds(@RequestParam("ids") Collection<Long> ids);
}
