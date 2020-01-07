package com.example.exception;

import com.example.model.common.ResultEnum;
import com.example.model.common.ResultResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpStatusCodeException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity handleException (Exception e)  {
//        ErrorResponse errorResponse = parseErrorResponse(e);
//        int status = Integer.parseInt(errorResponse.getStatus());
//        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(status));
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setResultCode(ResultEnum.UNKNOWN_ERROR);
        return null;
    }

    @ExceptionHandler(DataErrorException.class)
    @ResponseBody
    public ResponseEntity handleDataErrorException(){
        return null;
    }


    @ExceptionHandler(DataNotFoundException.class)
    @ResponseBody
    public ResponseEntity handleDataNotFoundException(){

        return null;
    }
}
