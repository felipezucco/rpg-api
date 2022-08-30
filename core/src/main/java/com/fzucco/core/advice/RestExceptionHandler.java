package com.fzucco.core.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    @ExceptionHandler({Exception.class})
//    protected ResponseEntity<Object> handlerException(RuntimeException ex, WebRequest request) {
//        Map<String, String> json = new HashMap<>();
//        json.put("hello", "world");
//
//        logger.error("Erro ao executar: " + ex.getMessage(), ex);
//        return handleExceptionInternal(ex, json, new HttpHeaders(), HttpStatus.OK, request);
//    }

}
