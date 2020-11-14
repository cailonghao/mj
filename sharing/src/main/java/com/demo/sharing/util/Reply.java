package com.demo.sharing.util;

import com.demo.sharing.util.exception.SharingException;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description TODO
 * @Date 2020/11/13 14:15
 * @Created by cai
 */
@Setter
@Getter
public class Reply {
    private Boolean success;
    private Integer code;
    private String msg;
    private Object data;

    public Reply(Boolean success, Integer code, String msg, Object data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Reply defineError(SharingException e) {
        return new Reply(false, e.getErrorCode(), e.getErrorMsg(), null);
    }

    public static Reply otherError(ReplyEnum e) {
        return new Reply(true, e.getErrorCode(), e.getErrorMsg(), null);
    }
}
