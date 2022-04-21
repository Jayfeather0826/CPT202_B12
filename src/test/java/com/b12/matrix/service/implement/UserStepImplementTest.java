//用户步数表service层接口实现测试

package com.b12.matrix.service.implement;

import com.b12.matrix.data_object.UserStep;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class )
@SpringBootTest
public class UserStepImplementTest extends TestCase {
    @Autowired
    private UserStepImplement userStepService;

    //根据id查找其余用户信息
    @Test
    public void testFindOne() {
        UserStep userStep=userStepService.findOne(1);
        Assert.assertEquals(new Integer(1),userStep.getStepId());
    }

    //根据tel查找其余用户信息（除了主键以外的查找需要在dao接口声明，即在repository接口声明）
    @Test
    public void testFindByUserTel() {
        UserStep userStep=userStepService.findByUserTel("13721790694");
        Assert.assertEquals(new String("13721790694"),userStep.getUserTel());
    }

    //保存（用于添加修改）
    @Test
    public void testSave() {
        UserStep userStep=new UserStep();
        userStep.setUserTel("12345678900");
        userStep.setStepNumber(9999);
        UserStep result=userStepService.save(userStep);
        Assert.assertNotNull(result);
    }
}