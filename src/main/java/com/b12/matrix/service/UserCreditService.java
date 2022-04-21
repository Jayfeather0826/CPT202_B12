//用户积分表service层接口

package com.b12.matrix.service;

import com.b12.matrix.data_object.UserCredit;

public interface UserCreditService {
    //根据id查找其余用户信息
    UserCredit findOne(Integer creditId);

    //根据tel查找其余用户信息（除了主键以外的查找需要在dao接口声明，即在repository接口声明）
    UserCredit findByUserTel(String userTel);

    //保存（用于添加修改）
    UserCredit save(UserCredit userCredit);
}
