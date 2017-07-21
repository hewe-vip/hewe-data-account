package vip.hewe.data.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import vip.hewe.common.util.Validator;
import vip.hewe.data.dao.MemberMapper;
import vip.hewe.data.dao.MprofileMapper;
import vip.hewe.data.domain.Member;
import vip.hewe.data.domain.Mprofile;

import java.util.Date;
import java.util.UUID;

/**
 *
 */
@Service
public class SignService {
    private static final Logger log = LoggerFactory.getLogger(SignService.class.getName());

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private MprofileMapper mprofileMapper;

    /**
     * @param member 必须:    未加密的密码,邮箱或手机号
     * @return 保存成功的用户id
     * @throws SignException
     */
    public String signOut(Member member) throws SignException {
        if (StringUtils.isEmpty(member.getCel()) && StringUtils.isEmpty(member.getEmail())) {
            throw new SignException("provide least one for cel or email");
        }
        if (StringUtils.isEmpty(member.getPasswd())) {
            throw new SignException("password is empty");
        }

        //设置盐
        String tempSalt = member.getCel() == null ? member.getEmail() : member.getCel();
        member.setSalt(DigestUtils.md5DigestAsHex(tempSalt.getBytes()));

        //加密密码
        String tempPass = member.getPasswd();
        tempSalt = member.getSalt();
        member.setPasswd(DigestUtils.md5DigestAsHex((tempPass + tempSalt).getBytes()));

        //生成id
        String result = UUID.randomUUID().toString();
        member.setId(result);
        try {
            memberMapper.insert(member);
        } catch (Exception exc) {
            log.error(String.format("save exception:    {0} message:    {1}", member.toString(), exc));
            throw new SignException("save exception");
        }
        Mprofile mprofile = new Mprofile();
        mprofile.setId(result);
        mprofile.setBth(new Date());
        mprofile.setName("user0");
        mprofile.setSex(0);
        //保存个人信息
        try {
            mprofileMapper.insert(mprofile);
        } catch (Exception exec) {
            log.error(String.format("save profile exception:    {0} message:    {1}", mprofile.toString(), exec));
            throw new SignException("save profile exception");
        }
        return result;
    }

    /**
     * @param identity
     * @param password
     * @return
     */
    public String validate(String identity, String password) {
        if (StringUtils.isEmpty(identity) || StringUtils.isEmpty(password)) {
            return null;
        }
        if (Validator.isCel(identity)) {
            String result = memberMapper.selectByCelPass(identity, password);
            return result;
        } else if (Validator.isEmail(identity)) {
            String result = memberMapper.selectByEmailPass(identity, password);
            return result;
        } else {
            return null;
        }
    }
}
