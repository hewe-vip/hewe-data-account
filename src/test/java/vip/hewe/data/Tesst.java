package vip.hewe.data;

import grpc.service.MemberMsg;
import grpc.service.MemberMsgOrBuilder;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import vip.hewe.data.domain.Member;

/**
 *
 */
public class Tesst {
    @Test
    public void testbean(){
        Member member = new Member("2","ad","13","daf","adf");
        MemberMsg.Builder builder = MemberMsg.newBuilder();
        MemberMsg memberMsg = builder.setCel(member.getCel()).setEmail(member.getEmail()).setId(member.getId()).build();
        Member member1 = new Member();
        BeanUtils.copyProperties(memberMsg,member1);
        System.out.println(member1.toString());
    }
}
