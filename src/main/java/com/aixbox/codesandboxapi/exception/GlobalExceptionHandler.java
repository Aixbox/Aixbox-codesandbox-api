package com.aixbox.codesandboxapi.exception;


import com.aixbox.codesandboxapi.common.BaseResponse;
import com.aixbox.codesandboxapi.common.ErrorCode;
import com.aixbox.codesandboxapi.common.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author <a href="https://github.com/Aixbox">Aixbox</a>
 * @from <a href="https://www.aixbox.top">Aixbox-blog</a>
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public BaseResponse<?> businessExceptionHandler(BusinessException e) {
        log.error("BusinessException", e);
        return ResultUtils.error(e.getCode(), e.getMessage());
    }



    @ExceptionHandler(Exception.class)
    public BaseResponse<?> exceptionHandler(RuntimeException e) {
        log.error("Exception", e);
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR, "系统错误");
    }
}
