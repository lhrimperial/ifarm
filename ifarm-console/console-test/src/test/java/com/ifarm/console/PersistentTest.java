package com.ifarm.console;

import com.alibaba.fastjson.JSON;
import com.ifarm.console.mapper.UserMapper;
import com.ifarm.console.shared.domain.dto.UserInfoVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 */
public class PersistentTest extends AbstractTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        UserInfoVO userInfoVO = userMapper.findByUserName("admin");
        System.out.println(JSON.toJSONString(userInfoVO));
    }
}
