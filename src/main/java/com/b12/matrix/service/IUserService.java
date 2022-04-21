package com.b12.matrix.service;

import com.b12.matrix.entity.User;
import com.b12.matrix.vo.request.RequestUserRegisterVo;
import com.baomidou.mybatisplus.extension.service.IService;


public interface IUserService extends IService<User> {

    /**
     * 通过电话号码查询用户
     * */
    User getByTelephone(String telephone);

    boolean register(RequestUserRegisterVo requestUserRegisterVo);

    User getByUserName(String userName);


}
