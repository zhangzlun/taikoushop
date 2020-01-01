package com.example.exception;

import lombok.Data;

@Data
public class DataNotFoundException extends Exception{
    private String msg;
    public DataNotFoundException(String msg){
        this.msg = msg;
    }
}
