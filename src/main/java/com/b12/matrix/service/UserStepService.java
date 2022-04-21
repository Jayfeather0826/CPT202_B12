//用户步数表service层接口

package com.b12.matrix.service;

import com.b12.matrix.data_object.UserStep;

public interface UserStepService {
    //根据id查找其余用户信息
    UserStep findOne(Integer stepId);

    //根据tel查找其余用户信息（除了主键以外的查找需要在dao接口声明，即在repository接口声明）
    UserStep findByUserTel(String userTel);

    //保存（用于添加修改）
    UserStep save(UserStep userStep);
}
