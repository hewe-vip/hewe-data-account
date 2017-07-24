package vip.hewe.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;
import vip.hewe.data.domain.Member;
import vip.hewe.data.handler.SignException;
import vip.hewe.data.handler.SignHandler;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HeweDataAccountApplicationTests {
    Logger log = LoggerFactory.getLogger(HeweDataAccountApplication.class.getName());
    @Autowired
    private SignHandler signService;

    @Test
    public void contextLoads() {

    }

    @Test
    public void testSignOut() {
        StopWatch watch = new StopWatch();
        watch.start("创建对象");
        Member member = new Member();
        member.setPasswd("123");
        member.setEmail("272489473@qq.com");
        watch.stop();
        watch.start("保存实例");
        try {

            String id = signService.signOut(member);
            System.out.println(id);
        } catch (SignException e) {
            e.printStackTrace();
        }
        watch.stop();
        log.info(watch.prettyPrint());
    }
}
