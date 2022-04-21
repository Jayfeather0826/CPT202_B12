//用户金钱表dao层接口测试

package com.b12.matrix.repository;

import com.b12.matrix.data_object.UserMoney;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMoneyRepositoryTest extends TestCase {
    @Autowired
    private UserMoneyRepository repository;

    //查找方法
    @Test
    public void findOneTest() {
        UserMoney userMoney = repository.findById(1).orElse(null);
        System.out.println(userMoney.toString());
    }
//
//    //保存方法
//    @Test
//    public void saveTest() {
//        UserMoney userMoney = new UserMoney();
//        userMoney.setUserTel("12345678912");
//        userMoney.setMoneyNumber(4444.0);
//        repository.save(userMoney);
//    }
//
//    //修改方法
//    @Test
//    public void updateTest() {
//        UserMoney userMoney = repository.findById(1).orElse(null);
//        userMoney.setMoneyNumber(7777.0);
//        repository.save(userMoney);
//    }

}