//用户金钱表dao层接口

package com.b12.matrix.repository;

import com.b12.matrix.data_object.UserMoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserMoneyRepository extends JpaRepository <UserMoney,Integer>{
    UserMoney findByUserTel(String userTel);

}
