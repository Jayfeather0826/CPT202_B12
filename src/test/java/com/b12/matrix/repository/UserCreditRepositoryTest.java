//用户积分表dao层接口测试

package com.b12.matrix.repository;

import com.b12.matrix.data_object.UserCredit;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserCreditRepositoryTest extends TestCase {
    @Autowired
    private UserCreditRepository repository;

    //查找方法
    @Test
    public void findOneTest() {
        UserCredit userCredit = repository.findById(1).orElse(null);
        System.out.println(userCredit.toString());
    }

    //保存方法
    @Test
    public void saveTest() {
        UserCredit userCredit = new UserCredit();
        userCredit.setUserTel("12345678912");
        userCredit.setCreditNumber(4444);
        repository.save(userCredit);
    }

    //修改方法
    @Test
    public void updateTest() {
        UserCredit userCredit = repository.findById(1).orElse(null);
        userCredit.setCreditNumber(7777);
        repository.save(userCredit);
    }

}