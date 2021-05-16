package edu.guet.user_center.controller;


import edu.guet.common.JwtUtils;
import edu.guet.common.R;
import edu.guet.user_center.entity.User;
import edu.guet.user_center.entity.vo.RegisterVo;
import edu.guet.user_center.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author xuan
 * @since 2021-05-03
 */
@RestController
@CrossOrigin
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

    @PostMapping("register")
    public R registerUser(@RequestBody RegisterVo registerVo) {
        System.out.println(registerVo);
        String registerInfo = memberService.register(registerVo);
        if("OK".equals(registerInfo)){
            return R.ok();
        }else {
            return R.error().message(registerInfo);
        }
    }

    //根据token获取用户信息
    @GetMapping("getUserInfo")
    public R getUserInfo(HttpServletRequest request) {
        //调用jwt工具类的方法。根据request对象获取头信息，返回用户id
        String userId = JwtUtils.getUserIdByJwtToken(request.getHeader("token"));
        //查询数据库根据用户id获取用户信息
        User user = memberService.getById(userId);
        if (null == user){
            return R.error();
        }else {
            return R.ok().data("userInfo",user);
        }
    }
}

