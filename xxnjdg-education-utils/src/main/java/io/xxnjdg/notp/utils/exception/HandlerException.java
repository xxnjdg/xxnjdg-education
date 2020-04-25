package io.xxnjdg.notp.utils.exception;

import io.xxnjdg.notp.utils.constant.HttpStatus;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-18 下午12:44
 *
 * 全局捕获异常
 */
@RestControllerAdvice
public class HandlerException {

    private Logger logger = LoggerFactory.getLogger(HandlerException.class);

    /**
     * 自定义异常
     * @param baseException 自定义异常
     * @return ResponseResult
     */
    @ExceptionHandler(BaseException.class)
    public ResponseResult customException(BaseException baseException){
        return ResponseResult.error(baseException.getBaseResponse());
    }

    /**
     * 方法参数校验
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        logger.error(e.getMessage());
        return ResponseResult.error(e.getBindingResult().getFieldError().getDefaultMessage());
    }

    /**
     * ValidationException
     */
    @ExceptionHandler(ValidationException.class)
    public ResponseResult handleValidationException(ValidationException e) {
        logger.error(e.getMessage(), e);
        return ResponseResult.error();
    }

    /**
     * ConstraintViolationException
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseResult handleConstraintViolationException(ConstraintViolationException e) {
        logger.error(e.getMessage(), e);

        String message = e.getMessage();
        String[] split = e.getMessage().split(": ");
        if (split.length == 2){
            message = split[1];
        }

        return ResponseResult.error(message);
    }

    /**
     * 404
     * @param e
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseResult handlerNoFoundException(Exception e) {
        logger.error(e.getMessage(), e);
        return ResponseResult.error(HttpStatus.NOT_FOUND);
    }

    /**
     * 捕获了 Exception
     * @param e 异常
     * @return 错误
     */
    @ExceptionHandler({ Exception.class })
    public ResponseResult processException(Exception e) {
        logger.error("Exception", e);
        return ResponseResult.error();
    }
}
