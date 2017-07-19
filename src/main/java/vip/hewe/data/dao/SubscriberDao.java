package vip.hewe.data.dao;

import org.apache.ibatis.annotations.Mapper;
import vip.hewe.data.domain.Subscriber;

/**
 *
 */
@Mapper
public interface SubscriberDao {
    int insert(Subscriber record);

    Subscriber selectByPrimaryKey(String id);

    int updateByPrimaryKey(Subscriber record);

    /**
     * @param identity 手机号邮箱或登录名
     * @return
     */
    Subscriber selectByidentity(String identity);
}
