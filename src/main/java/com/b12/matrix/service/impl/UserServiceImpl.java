package com.b12.matrix.service.impl;

import com.b12.matrix.entity.User;
import com.b12.matrix.mapper.UserMapper;
import com.b12.matrix.service.IUserService;
import com.b12.matrix.utils.Md5Utils;
import com.b12.matrix.vo.request.RequestUserRegisterVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * User服务层
 * */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService {

    /**
     * 通过电话号码查询用户
     * */
    @Override
    public User getByTelephone(String telephone) {
        //QueryWrapper<User>构建查询条件的工具
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_tel",telephone);
        return getOne(queryWrapper);

    }

    /**
     * 用户注册
     * */
    @Override
    public boolean register(RequestUserRegisterVo requestUserRegisterVo) {

        User user = new User();
        //拷贝属性（类型名相同,名称相同）
        BeanUtils.copyProperties(requestUserRegisterVo,user);
        //使用Md5加密密码
        user.setUserPassword(requestUserRegisterVo.getUserPassword());
        user.setUserName(requestUserRegisterVo.getUserName());
        return save(user);
    }

    @Override
    public User getByUserName(String userName) {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_name",userName);
        return getOne(queryWrapper);

    }


}
