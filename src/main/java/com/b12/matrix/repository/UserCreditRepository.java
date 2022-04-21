//用户积分表dao层接口

package com.b12.matrix.repository;

import com.b12.matrix.data_object.UserCredit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserCreditRepository extends JpaRepository <UserCredit,Integer> {
    UserCredit findByUserTel(String userTel);

    void deleteUserCreditByUserTel(String userTel);

}
