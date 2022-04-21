package com.b12.matrix.controller;

import com.b12.matrix.common.Result;
import com.b12.matrix.data_object.UserCredit;
import com.b12.matrix.data_object.UserInfo;
import com.b12.matrix.data_object.UserMoney;
import com.b12.matrix.data_object.UserStep;
import com.b12.matrix.entity.User;
import com.b12.matrix.repository.UserCreditRepository;
import com.b12.matrix.repository.UserInfoRepository;
import com.b12.matrix.repository.UserMoneyRepository;
import com.b12.matrix.repository.UserStepRepository;
import com.b12.matrix.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User的steps控制层
 * */
@RestController
@RequestMapping("/set/")
public class UserStepController {

    @Autowired
    private UserStepRepository userStepRepository;

    @Autowired
    private IUserService userService;   //使用通过电话号码查询用户interface


    @Autowired
    private UserMoneyRepository userMoneyRepository;

    @Autowired
    private UserCreditRepository userCreditRepository;

    //插入步数
    @PostMapping("insert")
    public Object insertStep(UserStep userStep){
        if (userStep.getUserTel()!=null){
            UserStep byUserTel = userStepRepository.findByUserTel(userStep.getUserTel());
            if (byUserTel!=null){
                int i = byUserTel.getStepNumber() + userStep.getStepNumber();
                byUserTel.setStepNumber(i);
                userStepRepository.deleteById(byUserTel.getStepId());
                userStepRepository.save(byUserTel);
            }else {
                UserStep newSet = new UserStep();
                newSet.setUserTel(userStep.getUserTel());
                newSet.setStepNumber(userStep.getStepNumber());
                userStepRepository.save(newSet);
            }
            return Result.getSuccess().setMsg("Increase the number of steps successfully！");
        }
        return Result.getFailure().setMsg("Please login and try again！");
    }

    //查询当前用户步数
    @PostMapping("selectSet")
    public Object selectSet(UserStep user){
        if (user.getUserTel() != null) {
                UserStep byUserTel = userStepRepository.findByUserTel(user.getUserTel());
                if (byUserTel!=null){
                    return Result.getSuccess().setMsg("Get data successfully！").setData(byUserTel);
                }
        }
        return Result.getFailure().setMsg("Failed to get data, please login and try again！");
    }


    @PostMapping("stepTranceCreit")
    public Object stepTranceCreit(UserStep step){
        if (step.getUserTel()!=null){
            UserStep byUserTel = userStepRepository.findByUserTel(step.getUserTel());
            UserCredit byUserTel1 = userCreditRepository.findByUserTel(step.getUserTel());
            if (byUserTel!=null){
                if (byUserTel.getStepNumber()-step.getStepNumber()>=0) {
                    byUserTel.setStepNumber(byUserTel.getStepNumber()-step.getStepNumber());
                    //更新步数表
                    userStepRepository.delete(byUserTel);
                    userStepRepository.save(byUserTel);
                    //更新积分信息
                    if (byUserTel1!=null){
                        byUserTel1.setCreditNumber(byUserTel1.getCreditNumber()+step.getStepNumber());
                        userCreditRepository.delete(byUserTel1);
                        userCreditRepository.save(byUserTel1);
                    }else {
                        //插入新记录
                        UserCredit userCredit = new UserCredit();
                        userCredit.setUserTel(step.getUserTel());
                        userCredit.setCreditNumber(step.getStepNumber());
                        userCreditRepository.save(userCredit);
                    }
                    return Result.getFailure().setMsg("conversion succeeded！");
                }else {
                    return Result.getFailure().setMsg("Insufficient credits currently！");
                }

            }else {

                return Result.getFailure().setMsg("Conversion failed！");
            }
        }
        return Result.getFailure().setMsg("Please log in and try again！");
    }



    @PostMapping("submitScore")
    public void submitScore(){

    }


}
