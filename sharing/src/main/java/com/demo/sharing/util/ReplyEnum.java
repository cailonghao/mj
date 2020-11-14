package com.demo.sharing.util;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description TODO
 * @Date 2020/11/13 14:23
 * @Created by cai
 */
@Getter
public enum ReplyEnum {
    SUCCESS(200, "成功");

    private Integer errorCode;

    private String errorMsg;

    ReplyEnum(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

}
