package com.b12.matrix.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class BaseExceptionHandler {

    @ExceptionHandler
    public Result exception(Exception e){
        log.error("Error：{}",e.getMessage());
        return Result.getFailure().setData(e.getMessage());
    }

}
