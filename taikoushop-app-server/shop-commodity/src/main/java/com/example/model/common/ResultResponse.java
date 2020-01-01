package com.example.model.common;

import lombok.Data;

@Data
public class ResultResponse<T> {
    private Integer code;
    private String msg;
    private T data;

    public void setResultCode( ResultEnum result){
        this.code = result.getCode();
        this.msg = result.getMsg();
    }
}
