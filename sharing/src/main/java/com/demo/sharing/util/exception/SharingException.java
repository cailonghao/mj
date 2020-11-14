package com.demo.sharing.util.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description TODO
 * @Date 2020/11/13 14:23
 * @Created by cai
 */
@Setter
@Getter
public class SharingException extends  RuntimeException{

    private Integer errorCode;
    private String errorMsg;

    public SharingException(Integer errorCode,String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
