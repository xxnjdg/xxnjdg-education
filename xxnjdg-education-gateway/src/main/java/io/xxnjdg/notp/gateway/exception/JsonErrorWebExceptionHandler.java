package io.xxnjdg.notp.gateway.exception;

import io.xxnjdg.notp.utils.exception.BaseException;
import io.xxnjdg.notp.utils.interfaces.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-27 上午4:04
 */
public class JsonErrorWebExceptionHandler extends DefaultErrorWebExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(JsonErrorWebExceptionHandler.class);

    public JsonErrorWebExceptionHandler(ErrorAttributes errorAttributes,
                                        ResourceProperties resourceProperties,
                                        ErrorProperties errorProperties,
                                        ApplicationContext applicationContext) {
        super(errorAttributes, resourceProperties, errorProperties, applicationContext);
    }

    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
    }

    @Override
    protected int getHttpStatus(Map<String, Object> errorAttributes) {
        // 这里其实可以根据errorAttributes里面的属性定制HTTP响应码
        return HttpStatus.OK.value();
    }

    @Override
    protected Map<String, Object> getErrorAttributes(ServerRequest request, boolean includeStackTrace) {
        // 这里其实可以根据异常类型进行定制化逻辑
        Throwable error = super.getError(request);
        Map<String, Object> errorAttributes = new HashMap<>(8);

        if (error instanceof BaseException){
            BaseResponse baseResponse = ((BaseException) error).getBaseResponse();
            errorAttributes.put("status", baseResponse.status());
            errorAttributes.put("statusText", baseResponse.statusText());
            errorAttributes.put("data", "");
        }else {
            errorAttributes.put("statusText", error.getMessage());
            errorAttributes.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            errorAttributes.put("data", "");


            logger.error(error.getMessage());
            logger.error(error.getLocalizedMessage());
        }


        return errorAttributes;
    }


}
