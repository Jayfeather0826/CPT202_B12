package com.b12.matrix;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {
//    private final Logger logger= LoggerFactory.getLogger(LoggerTest.class);
    @Test
    public void test1(){
        log.error("Message：error");
        log.warn("Message：warn");
        log.info("Message：info");
        log.debug("Message：debug");
        log.trace("Message：trace");
        String name="Jay";
        String id="1929471";
        log.info("Name={},Id={}",name,id);

    }
}
