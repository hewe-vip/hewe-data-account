package vip.hewe.data.service;

import org.springframework.stereotype.Service;
import vip.hewe.data.domain.Member;


/**
 *
 */
@Service
public interface SignService {
    int deleteByPrimaryKey(String id);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(String id);

    String selectByCelPass(String cel, String passwd);

    String selectByEmailPass(String email, String passwd);


    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
}
