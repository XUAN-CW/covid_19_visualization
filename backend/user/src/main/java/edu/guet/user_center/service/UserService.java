package edu.guet.user_center.service;

import edu.guet.user_center.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import edu.guet.user_center.entity.vo.RegisterVo;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author xuan
 * @since 2021-05-03
 */
public interface UserService extends IService<User> {
    //登录的方法
    String login(User member);

    //注册的方法
    String register(RegisterVo registerVo);
}
