//用户积分表service层接口实现

package com.b12.matrix.service.implement;

import com.b12.matrix.data_object.UserCredit;
import com.b12.matrix.repository.UserCreditRepository;
import com.b12.matrix.service.UserCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //所有的实现类需要加一个Service的注解
public class UserCreditImplement implements UserCreditService {
    @Autowired //自动填充公共dao层对象
    private UserCreditRepository repository;

    //根据id查找其余用户信息
    @Override
    public UserCredit findOne(Integer creditId) {return repository.findById(1).orElse(null);}

    //根据tel查找其余用户信息（除了主键以外的查找需要在dao接口声明，即在repository接口声明）
    @Override
    public UserCredit findByUserTel(String userTel) {
        UserCredit byUserTel = repository.findByUserTel(userTel);
        return byUserTel;
    }
    //保存（用于添加修改）
    @Override
    public UserCredit save(UserCredit userCredit) {
        return repository.save(userCredit);
    }

    public void deleteData(String userTel) {
        repository.deleteUserCreditByUserTel(userTel);
    }
}
