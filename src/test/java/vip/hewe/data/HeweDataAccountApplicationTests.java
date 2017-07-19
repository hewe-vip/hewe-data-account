package vip.hewe.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import vip.hewe.data.dao.ProfileDao;
import vip.hewe.data.dao.SubscriberDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HeweDataAccountApplicationTests {
	@Autowired
	private ProfileDao profileDao;
	@Autowired
	private SubscriberDao subscriberDao;

	@Test
	public void contextLoads() {
		profileDao.selectByPrimaryKey("dsf");
		subscriberDao.selectByidentity("daf");
	}

}
