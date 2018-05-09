package com.ifarm.console;

import com.alibaba.fastjson.JSON;
import com.ifarm.console.mapper.ResourceMapper;
import com.ifarm.console.mapper.UserMapper;
import com.ifarm.console.shared.domain.dto.SimpleResourceDTO;
import com.ifarm.console.shared.domain.po.ResourcePO;
import com.ifarm.console.shared.domain.po.UserInfoPO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class PersistentTest extends AbstractTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ResourceMapper resourceMapper;

    @Test
    public void test3(){
        Map<String, Object> params = new HashMap<>();
        params.put("roleId", null);
        params.put("parentCode", "console_1");
        List<SimpleResourceDTO> list = resourceMapper.findDistributeResourceByParent(params);
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void test2(){
//        List<SimpleResourceDTO> list = resourceMapper.findAllDistributeResourceByParent("root");
//        System.out.println(JSON.toJSONString(list));
    }

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
