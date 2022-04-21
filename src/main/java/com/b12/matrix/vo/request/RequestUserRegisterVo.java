package com.b12.matrix.vo.request;

import lombok.Data;

/**
 * 用户注册请求Vo
 * */
@Data
public class RequestUserRegisterVo {


    private String id;

    private String userName;

    private String userPassword;


    private String userTel;

}
