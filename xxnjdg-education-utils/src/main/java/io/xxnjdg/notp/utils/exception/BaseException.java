package io.xxnjdg.notp.utils.exception;

import io.xxnjdg.notp.utils.interfaces.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-23 下午8:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class BaseException extends RuntimeException  {

    /**
     * 返回消息
     */
    private BaseResponse baseResponse;

    public BaseException(Integer status,String statusText){
        baseResponse = new BaseResponse() {
            @Override
            public Integer status() {
                return status;
            }

            @Override
            public String statusText() {
                return statusText;
            }
        };
    }
}
