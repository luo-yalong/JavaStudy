package com.lyl.mybatis_demo.common.config;

import com.lyl.mybatis_demo.common.pojo.Result;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 罗亚龙
 * @date 2021/10/28 8:56
 */
@RestControllerAdvice(annotations = RestController.class)
public class MyExceptionHandler {


    @ExceptionHandler(Exception.class)
    public Result executeException(Exception e, HttpServletRequest request){
        Map<String,Object> map = new LinkedHashMap<>(5);
        map.put("method", request.getMethod());
        map.put("uri", request.getRequestURL());
        map.put("param", request.getParameterMap());
        map.put("errorMsg", e.getLocalizedMessage());
        map.put("exception", e);
        return Result.fail("请求异常",map);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result onHttpMessageNotReadableException(HttpMessageNotReadableException e,HttpServletRequest request){
        Map<String,Object> map = new LinkedHashMap<>(4);
        map.put("method", request.getMethod());
        map.put("uri", request.getRequestURL());
        map.put("param", request.getParameterMap());
        map.put("errorMsg", "请求体json数据缺失");
        return Result.fail("请求异常",map);
    }

    @ExceptionHandler(AsyncRequestTimeoutException.class)
    public Result handException(AsyncRequestTimeoutException e) {
        Map<String,Object> map = new LinkedHashMap<>(2);
        map.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        map.put("status", 500);
        return Result.fail("请求超时",map);
    }

}
