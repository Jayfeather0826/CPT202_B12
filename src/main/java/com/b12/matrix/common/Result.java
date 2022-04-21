package com.b12.matrix.common;

import lombok.Data;

@Data
public class Result<T> {

    private Integer code;   //错误码
    private String msg;     //提示信息
    private T data;         //返回内容

    public Result(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Result setData(T data){
        this.data = data;
        return this;
    }

    public Result setMsg(String msg){
        this.msg = msg;
        return this;
    }

    public static Result getSuccess(){
        return new Result(200,"Success");
    }

    public static  Result getFailure(){
        return new Result(400,"Failure");
    }

}
