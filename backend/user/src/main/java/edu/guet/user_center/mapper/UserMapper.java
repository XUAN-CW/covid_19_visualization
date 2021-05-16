package edu.guet.user_center.mapper;

import edu.guet.user_center.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author xuan
 * @since 2021-05-03
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
