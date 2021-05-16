package edu.guet.covid_19_visualization.user_center;

import edu.guet.UserCenterApplication;
import edu.guet.user_center.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = UserCenterApplication.class)
public class UserCenterApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    public void contextLoads() {
        System.out.println(userMapper.selectList(null));
    }

}
