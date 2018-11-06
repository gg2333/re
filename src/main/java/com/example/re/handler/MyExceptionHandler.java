package com.example.re.handler;

import com.example.re.resp.BaseResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(MyExceptionHandler.class);

    @ExceptionHandler(value = MyException.class)
    @ResponseStatus(HttpStatus.OK)
    public BaseResp demoException(MyException e) {
        return BaseResp.error(e.getCode(), e.getMessage());
    }

//    @ExceptionHandler(value = MissingServletRequestParameterException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public Exception missingServletRequestParameterException(Exception e) {
//        return e;
//    }

//    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
//    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
//    public Exception httpRequestMethodNotSupportedException(Exception e) {
//        return e;
//    }

}
