package com.miaomiao.doufuwanzi.exception;

import com.miaomiao.doufuwanzi.enums.ErrorCode;
import com.miaomiao.doufuwanzi.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Objects;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({BusinessException.class})
    public Result<?> handleBusinessException(BusinessException exception) {
        log.error("GlobalExceptionHandler [BusinessException] Exception code : {}  Exception message : {} ",
                exception.getCode(), exception.getMessage());
        //业务异常只获取发生的地方，不用全部打印整个调用链路
        if (Objects.nonNull(exception.getStackTrace()) && exception.getStackTrace().length > 0) {
            log.error("GlobalExceptionHandler [BusinessException] Exception cause : {}",
                    exception.getStackTrace()[0]);
        }
        return Result.fail(exception.getMessage(), exception.getCode());
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public Result<?> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        return Result.fail(ErrorCode.PARAMETER_ERROR.getMsg(), ErrorCode.PARAMETER_ERROR.getCode());
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    public Result<?> handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        log.error("GlobalExceptionHandler [BusinessException] Exception message : {} ",
                exception.getMessage());
        //业务异常只获取发生的地方，不用全部打印整个调用链路
        if (Objects.nonNull(exception.getStackTrace()) && exception.getStackTrace().length > 0) {
            log.error("GlobalExceptionHandler [BusinessException] Exception cause : {}",
                    exception.getStackTrace()[0]);
        }
        return Result.fail(ErrorCode.DATA_INTEGRITY_VIOLATION.getMsg(), ErrorCode.DATA_INTEGRITY_VIOLATION.getCode());
    }

    @ExceptionHandler({Exception.class})
    public Result<?> handleBusinessException(Exception exception) {
        log.error("GlobalExceptionHandler [Exception] Exception : {}", exception);
        return Result.fail(ErrorCode.INTERNAL_SERVER_ERROR.getMsg(), ErrorCode.INTERNAL_SERVER_ERROR.getCode());
    }
}
