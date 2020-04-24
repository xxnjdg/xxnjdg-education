package io.xxnjdg.notp.utils.exception;

import io.xxnjdg.notp.utils.interfaces.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-23 下午8:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseException extends RuntimeException  {

    /**
     * 返回消息
     */
    private BaseResponse baseResponse;
}
