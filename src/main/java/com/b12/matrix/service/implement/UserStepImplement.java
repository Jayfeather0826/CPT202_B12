//用户步数表service层接口实现

package com.b12.matrix.service.implement;

import com.b12.matrix.data_object.UserStep;
import com.b12.matrix.repository.UserStepRepository;
import com.b12.matrix.service.UserStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //所有的实现类需要加一个Service的注解
public class UserStepImplement implements UserStepService {
    @Autowired //自动填充公共dao层对象
    private UserStepRepository repository;

    //根据id查找其余用户信息
    @Override
    public UserStep findOne(Integer stepId) {return repository.findById(1).orElse(null);}

    //根据tel查找其余用户信息（除了主键以外的查找需要在dao接口声明，即在repository接口声明）
    @Override
    public UserStep findByUserTel(String userTel) {return repository.findByUserTel(userTel);}

    //保存（用于添加修改）
    @Override
    public UserStep save(UserStep userStep) {return repository.save(userStep);}

}
