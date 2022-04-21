//用户金钱表service层接口实现

package com.b12.matrix.service.implement;

import com.b12.matrix.data_object.UserMoney;
import com.b12.matrix.repository.UserMoneyRepository;
import com.b12.matrix.service.UserMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //所有的实现类需要加一个Service的注解
public class UserMoneyImplement implements UserMoneyService {
    @Autowired //自动填充公共dao层对象
    private UserMoneyRepository repository;

    //根据id查找其余用户信息
    @Override
    public UserMoney findOne(Integer moneyId) {return repository.findById(1).orElse(null);}

    @Override
    public UserMoney findByUserTel(String userTel) {
        return null;
    }

    //根据tel查找其余用户信息（除了主键以外的查找需要在dao接口声明，即在repository接口声明）

    //保存（用于添加修改）
    @Override
    public UserMoney save(UserMoney userMoney) {return repository.save(userMoney);}


}
