//用户信息表dao层接口

package com.b12.matrix.repository;

import com.b12.matrix.data_object.UserStep;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserStepRepository extends JpaRepository <UserStep,Integer> {
    UserStep findByUserTel(String userTel);
}
