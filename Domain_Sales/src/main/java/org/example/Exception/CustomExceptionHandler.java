package org.example.Exception;


import org.example.Exception.ApiException.CustomerNotFoundException;
import org.example.Exception.ApiException.OrderNotFoundException;
import org.example.Exception.utilsException.ProductMapInternalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value= {CustomerNotFoundException.class, OrderNotFoundException.class})
    public ResponseEntity<Object> ObjectNotFoundException(RuntimeException exception){
        CustomException res=new CustomException(
                exception.getMessage(),exception.getCause()
                , HttpStatus.NOT_FOUND ,
                LocalDateTime.now());
        return new ResponseEntity<>(res, res.getHttpStatus());

    }

    @ExceptionHandler(value= ProductMapInternalException.class)
    public ResponseEntity<Object> MappingInternalException(RuntimeException exception){
        CustomException res=new CustomException(
                exception.getMessage(),exception.getCause()
                , HttpStatus.INTERNAL_SERVER_ERROR ,
                LocalDateTime.now());
        return new ResponseEntity<>(res, res.getHttpStatus());

    }


}
