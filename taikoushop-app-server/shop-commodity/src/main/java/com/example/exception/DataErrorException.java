package com.example.exception;

import lombok.Data;

@Data
public class DataErrorException extends Exception{
    private String msg;
    public DataErrorException(String msg){
        this.msg = msg;
    }
}
