package com.ifarm.console;

import com.alibaba.fastjson.JSON;
import com.ifarm.console.mapper.ResourceMapper;
import com.ifarm.console.mapper.UserMapper;
import com.ifarm.console.shared.domain.dto.ResourceVO;
import com.ifarm.console.shared.domain.dto.UserInfoVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *
 */
public class PersistentTest extends AbstractTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ResourceMapper resourceMapper;

    @Test
    public void test1() {
        List<ResourceVO> list = resourceMapper.findMenuResources("admin");
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void test() {
        UserInfoVO userInfoVO = userMapper.findByUserName("admin");
        System.out.println(JSON.toJSONString(userInfoVO));
    }
}
