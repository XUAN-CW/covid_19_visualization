package edu.guet.user_center.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.guet.common.JwtUtils;
import edu.guet.common.MD5;
import edu.guet.user_center.entity.User;
import edu.guet.user_center.mapper.UserMapper;
import edu.guet.user_center.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author xuan
 * @since 2021-05-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    //登录的方法
    @Override
    public String login(User user) {
        //获取登录手机号和密码
        String mobile = user.getMobile();
        String password = user.getPassword();

        //手机号和密码非空判断
        if(StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)) {
            return null;
        }

        //判断手机号是否正确
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile",mobile);
        User mobileUser = baseMapper.selectOne(wrapper);
        //判断查询对象是否为空
        if(mobileUser == null) {//没有这个手机号
            return null;
        }

        //判断密码
        //因为存储到数据库密码肯定加密的
        //把输入的密码进行加密，再和数据库密码进行比较
        //加密方式 MD5
        if(!MD5.encrypt(password).equals(mobileUser.getPassword())) {
            return null;
        }

        //判断用户是否禁用
        if(mobileUser.getIsDisabled()) {
            return null;
        }

        //登录成功
        //生成token字符串，使用jwt工具类
        String jwtToken = JwtUtils.getJwtToken(mobileUser.getId(), mobileUser.getNickname());
        return jwtToken;
    }
}
