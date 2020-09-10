package com.ifarm.console;

import com.github.framework.starter.core.ApplicationContexts;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
public abstract class AbstractTest {

    static {
        ApplicationContexts.setProfileIfNotExists("dev");
    }



}
