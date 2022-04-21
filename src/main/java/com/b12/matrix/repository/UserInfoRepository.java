//用户信息表dao层接口

package com.b12.matrix.repository;

import com.b12.matrix.data_object.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//userInfo dao层接口
public interface UserInfoRepository extends JpaRepository <UserInfo,Integer>{
    Optional<UserInfo> findByUserTel(String userTel);
}

