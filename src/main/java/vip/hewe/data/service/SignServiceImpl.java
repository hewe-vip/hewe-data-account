package vip.hewe.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.hewe.api.domain.Member;
import vip.hewe.api.service.SignService;
import vip.hewe.data.dao.MemberMapper;

/**
 *
 */
@Service("signService")
public class SignServiceImpl implements SignService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return memberMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Member record) {
        return memberMapper.insert(record);
    }

    @Override
    public int insertSelective(Member record) {
        return memberMapper.insertSelective(record);
    }

    @Override
    public Member selectByPrimaryKey(String id) {
        return memberMapper.selectByPrimaryKey(id);
    }

    @Override
    public String selectByCelPass(String cel, String passwd) {
        return memberMapper.selectByCelPass(cel, passwd);
    }

    @Override
    public String selectByEmailPass(String email, String passwd) {
        return memberMapper.selectByEmailPass(email, passwd);
    }

    @Override
    public int updateByPrimaryKeySelective(Member record) {
        return updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Member record) {
        return memberMapper.updateByPrimaryKey(record);
    }
}
