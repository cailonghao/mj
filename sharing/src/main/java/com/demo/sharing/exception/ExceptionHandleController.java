package com.demo.sharing.exception;

import org.apache.ibatis.exceptions.IbatisException;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description TODO
 * @Date 2020/11/6 10:29
 * @Created by cai
 */
@RestControllerAdvice
public class ExceptionHandleController {
    @ExceptionHandler(value = DataAccessException.class)
    public String mybatisException(DataAccessException e) {
        return "数据操作异常";
    }

    @ExceptionHandler(value = RuntimeException.class)
    public String runtimeException(RuntimeException e) {
        return "运行时异常";
    }
}
