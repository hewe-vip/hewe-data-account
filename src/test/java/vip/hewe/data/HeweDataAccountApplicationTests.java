package vip.hewe.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import vip.hewe.data.dao.MemberMapper;
import vip.hewe.data.dao.MprofileMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HeweDataAccountApplicationTests {
    @Autowired
    private MemberMapper profileDao;
    @Autowired
    private MprofileMapper subscriberDao;

    @Test
    public void contextLoads() {
        profileDao.selectByPrimaryKey("dsf");
        subscriberDao.deleteByPrimaryKey("dsa");
    }

}
