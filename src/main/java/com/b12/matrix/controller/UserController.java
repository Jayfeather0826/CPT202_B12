package com.b12.matrix.controller;

import com.b12.matrix.common.Result;
import com.b12.matrix.common.StringConstants;
import com.b12.matrix.data_object.UserCredit;
import com.b12.matrix.data_object.UserMoney;
import com.b12.matrix.entity.User;
import com.b12.matrix.entity.UserScore;
import com.b12.matrix.repository.UserCreditRepository;
import com.b12.matrix.repository.UserMoneyRepository;
import com.b12.matrix.repository.UserScoreRepository;
import com.b12.matrix.service.IUserService;
import com.b12.matrix.service.implement.UserCreditImplement;
import com.b12.matrix.service.implement.UserMoneyImplement;
import com.b12.matrix.utils.FormatUtils;
import com.b12.matrix.utils.Md5Utils;
import com.b12.matrix.vo.request.RequestUserRegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * user控制层
 * */
@RestController
//    @Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private IUserService userService;   //使用通过电话号码查询用户interface

    @Autowired
    private UserCreditImplement userCreditImplement;

    @Autowired
    private UserMoneyImplement userMoneyImplement;

    @Autowired
    private UserCreditRepository userCreditRepository;

    @Autowired
    private UserMoneyRepository userMoneyRepository;

    @Autowired
    private UserScoreRepository userScoreRepository;


    @PostMapping("register")
    public Object register(RequestUserRegisterVo requestUserRegisterVo){
        //判断电话号码格式
        User user = userService.getByTelephone(requestUserRegisterVo.getUserTel());
        //user是否为空，不为空证明已经注册
        if (user!=null){
            return Result.getFailure().setMsg(StringConstants.USER_EXIST);
        }
        if(userService.register(requestUserRegisterVo)){
            return Result.getSuccess().setMsg(StringConstants.REGISTRATION_SUCCESSS).setData(user);
        }else {
            return Result.getFailure().setMsg(StringConstants.REGISTRATION_FAIL);
        }

    }


    @PostMapping("zhuxiao")
    public Object zhuxiao(RequestUserRegisterVo requestUserRegisterVo){
        User user = userService.getByTelephone(requestUserRegisterVo.getUserTel());
        if (user==null){
            return Result.getFailure().setMsg("The current user does not exist and cannot log out！");
        }
        Map<String, Object> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("user_tel",user.getUserTel());
        userService.removeByMap(stringStringHashMap);
        return Result.getSuccess().setMsg("Logout succeeded！");

    }

    @PostMapping("getUserMoney")
    @ResponseBody
    public UserMoney getUserMoney(UserCredit credit){
        UserMoney userMoney = userMoneyRepository.findByUserTel(credit.getUserTel());
        if (userMoney==null){
            UserMoney userMoney1 = new UserMoney();
            userMoney1.setMoneyNumber("0");
            return userMoney1;
        }
        return userMoney;
    }


    @PostMapping("login")
    public Object login(RequestUserRegisterVo requestUserRegisterVo){
        //判断账号是否存在
        User user = userService.getByTelephone(requestUserRegisterVo.getUserTel());
        //user是否为空，不为空证明已经注册
        if (user==null){
            return Result.getFailure().setMsg(StringConstants.USER_NOT_EXIST);
        }
        if (user.getUserPassword().equals(requestUserRegisterVo.getUserPassword())) {
            return Result.getSuccess().setMsg(StringConstants.LogINSUCESS).setData(user);
        }else {
            return Result.getFailure().setMsg(StringConstants.LogINERROR);
        }
    }



    @PostMapping("tranceMoney")
    //积分换钱
    public Object moneyTransform(UserCredit credit){
        //积分查询
        UserCredit userCredit = userCreditImplement.findByUserTel(credit.getUserTel());
        if (userCredit!=null){
            //需要换钱的积分
            Integer creditNumber = credit.getCreditNumber();
            //总积分
            Integer allCreditNumber = userCredit.getCreditNumber();
            if (allCreditNumber-creditNumber>=0){
                //积分足够
                //扣除积分 1
                //添加余额到金钱表里
                userCredit.setCreditNumber(allCreditNumber-creditNumber);
                userCreditRepository.delete(userCredit);
                userCreditRepository.save(userCredit);
                UserMoney userMoney = userMoneyRepository.findByUserTel(credit.getUserTel());
                if (userMoney==null){
                    //创建钱包
                    UserMoney newUserMoney = new UserMoney();
                    newUserMoney.setMoneyNumber(credit.getTranceMoney());
                    newUserMoney.setUserTel(userCredit.getUserTel());
                    userMoneyRepository.save(newUserMoney);
                }else{
                    //更新钱包
                    userMoney.setMoneyNumber(String.valueOf(credit.getTranceMoney()));
                    userMoneyRepository.delete(userMoney);
                    userMoneyRepository.save(userMoney);
                }
                return Result.getSuccess().setMsg(StringConstants.SUCCESS_MONEY);
            }else {
                //积分不足
                return Result.getFailure().setMsg(StringConstants.FAILURE_NOWE);
            }
        }
        return Result.getFailure().setMsg(StringConstants.FAILURE_NOWE);
    }


    //查询积分接口
    @ResponseBody
    @PostMapping("getCreaditByUser")
    public UserCredit getCreadit(User user){
        UserCredit byUserTel = userCreditImplement.findByUserTel(user.getUserTel());
        return byUserTel;
    }

    @PostMapping("submitScore")
    public Object submitScore(UserScore userScore){
        UserScore byUserTel = userScoreRepository.findByUserTel(userScore.getUserTel());
        if (byUserTel!=null){
            return Result.getFailure().setMsg("Current users have already rated！").setData(byUserTel);
        }
        userScoreRepository.save(userScore);
        return Result.getSuccess().setMsg("Evaluation of success");    }

}
