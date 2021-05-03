package edu.guet.user_center.service.impl;

import edu.guet.user_center.entity.User;
import edu.guet.user_center.mapper.UserMapper;
import edu.guet.user_center.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
