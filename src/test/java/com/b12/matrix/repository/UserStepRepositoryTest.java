//用户步数表dao层接口测试

package com.b12.matrix.repository;

import com.b12.matrix.data_object.UserStep;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserStepRepositoryTest extends TestCase {
    @Autowired
    private UserStepRepository repository;

    //查找方法
    @Test
    public void findOneTest() {
        UserStep userStep = repository.findById(1).orElse(null);
        System.out.println(userStep.toString());
    }

    //保存方法
    @Test
    public void saveTest() {
        UserStep userStep = new UserStep();
        userStep.setUserTel("12345678912");
        userStep.setStepNumber(4444);
        repository.save(userStep);
    }

    //修改方法
    @Test
    public void updateTest() {
        UserStep userStep = repository.findById(1).orElse(null);
        userStep.setStepNumber(7777);
        repository.save(userStep);
    }
}