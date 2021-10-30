package com.lyl.mybatis_demo.common.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Collections;

/**
 * @author 罗亚龙
 * @date 2021/10/27 15:15
 */
@Data
@Accessors(chain = true)
public class Result {
    /**
     * 状态
     */
    private Boolean state;
    /**
     * 消息
     */
    private String msg;
    /**
     * 数据
     */
    private Object data;

    public static Result success(){
        return success("执行成功",Collections.EMPTY_LIST);
    }

    public static Result success(String msg){
        return success(msg, Collections.EMPTY_LIST);
    }

    public static Result success(Object obj){
        return success("执行成功",obj);
    }


    public static Result success(String msg,Object obj){
        Result result = new Result();
        result.setState(true);
        result.setMsg(msg);
        result.setData(obj);
        return result;
    }

    public static Result fail(){
        return fail("执行失败",Collections.EMPTY_LIST);
    }

    public static Result fail(String msg){
        return fail(msg,Collections.EMPTY_LIST);
    }

    public static Result fail(Object obj){
        return fail("执行失败",obj);
    }

    public static Result fail(String msg,Object obj){
        Result result = new Result();
        result.setState(false);
        result.setMsg(msg);
        result.setData(obj);
        return result;
    }
}
