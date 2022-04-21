//用户积分表service层接口实现测试

package com.b12.matrix.service.implement;

import com.b12.matrix.data_object.UserCredit;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class )
@SpringBootTest
public class UserCreditImplementTest extends TestCase {
    @Autowired
    private UserCreditImplement userCreditService;

    //根据id查找其余用户信息
    @Test
    public void testFindOne() {
        UserCredit userCredit=userCreditService.findOne(1);
        Assert.assertEquals(new Integer(1),userCredit.getCreditId());
    }

    //根据tel查找其余用户信息（除了主键以外的查找需要在dao接口声明，即在repository接口声明）
    @Test
    public void testFindByUserTel() {
        UserCredit userCredit=userCreditService.findByUserTel("13721790694");
        Assert.assertEquals(new String("13721790694"),userCredit.getUserTel());
    }

    //保存（用于添加修改）
    @Test
    public void testSave() {
        UserCredit userCredit=new UserCredit();
        userCredit.setUserTel("12345678900");
        userCredit.setCreditNumber(9999);
        UserCredit result=userCreditService.save(userCredit);
        Assert.assertNotNull(result);
    }
}