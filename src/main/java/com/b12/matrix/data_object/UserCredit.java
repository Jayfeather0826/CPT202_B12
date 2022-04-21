//用户积分表实体类

package com.b12.matrix.data_object;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.Transient;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //将数据库映射成实体类
@DynamicUpdate //动态生成（防止没有修改的字段自动设置为null）
@Data //减少getSet、toString等代码
public class UserCredit {
    @Id //主键加@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer creditId;
    private String userTel;
    private Integer creditNumber;
    //可以转换的钱
    private String tranceMoney;
}
