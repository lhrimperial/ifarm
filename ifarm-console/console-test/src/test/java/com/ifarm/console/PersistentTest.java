package com.ifarm.console;

import com.alibaba.fastjson.JSON;
import com.ifarm.console.mapper.ResourceMapper;
import com.ifarm.console.mapper.UserMapper;
import com.ifarm.console.shared.domain.po.ResourcePO;
import com.ifarm.console.shared.domain.po.UserInfoPO;
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
        List<ResourcePO> list = resourceMapper.findMenuResources("admin");
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void test() {
        UserInfoPO userInfoVO = userMapper.findByUserName("admin");
        System.out.println(JSON.toJSONString(userInfoVO));
    }
}
