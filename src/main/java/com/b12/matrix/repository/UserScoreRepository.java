package com.b12.matrix.repository;

import com.b12.matrix.data_object.UserStep;
import com.b12.matrix.entity.UserScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserScoreRepository extends JpaRepository<UserScore,Integer> {
    UserScore findByUserTel(String tel);
}
