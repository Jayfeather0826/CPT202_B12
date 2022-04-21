//用户信息表dao层接口测试

package com.b12.matrix.repository;

import com.b12.matrix.data_object.UserInfo;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoRepositoryTest extends TestCase {
    @Autowired
    private  UserInfoRepository repository;

    //查找方法
    @Test
    public void findOneTest(){
        UserInfo userInfo=repository.findById(1).orElse(null);
        System.out.println(userInfo.toString());
    }

    //保存方法
    @Test
    public void saveTest(){
        UserInfo userInfo=new UserInfo();
        userInfo.setUserTel("12345678912");
        userInfo.setUserName("MotherFucker");
        userInfo.setUserPassword("123456");
        repository.save(userInfo);
    }

    //修改方法
    @Test
    public void updateTest(){
        UserInfo userInfo=repository.findById(2).orElse(null);
        userInfo.setUserName("PieceOfShit");
        repository.save(userInfo);
    }

}