package edu.guet.user_center.controller;


import edu.guet.common.R;
import edu.guet.user_center.entity.User;
import edu.guet.user_center.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author xuan
 * @since 2021-05-03
 */
@RestController
@RequestMapping("/user_center/user")
public class UserController {

    @Autowired
    private UserService memberService;

    //登录
    @PostMapping("login")
    public R login(@RequestBody User user) {
        System.out.println(user);
        //member对象封装手机号和密码
        //调用service方法实现登录
        //返回token值，使用jwt生成
        String token = memberService.login(user);

        if(null == token){
            return R.error().message("登录失败！");
        } else {
            return R.ok().data("token",token);
        }
    }
}

