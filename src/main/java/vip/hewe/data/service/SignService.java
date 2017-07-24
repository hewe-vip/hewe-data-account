package vip.hewe.data.service;

import grpc.service.*;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.hewe.data.dao.MemberMapper;
import vip.hewe.data.domain.Member;


/**
 *
 */
@Service
public class SignService extends MemberDataServiceGrpc.MemberDataServiceImplBase {
    private static final Logger log = LoggerFactory.getLogger(SignService.class);

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public void insert(MemberMsg request, StreamObserver<RecordMsg> responseObserver) {

        String cel = request.getCel();
        String email = request.getEmail();
        String passwd = request.getPasswd();
        String id = request.getId();
        String salt = request.getSalt();
        Member member = new Member(id, cel, email, passwd, salt);

        log.info("insert:   {0}", member.toString());
        int result = memberMapper.insert(member);
        responseObserver.onNext(RecordMsg.newBuilder().setCount(result).build());
        responseObserver.onCompleted();
        //验证邮箱和手机号
//        if (!StringUtils.isEmpty(email) && Validator.isEmail(email)){
//            member.setEmail(email);
//        }
//        if (!StringUtils.isEmpty(cel) && Validator.isCel(cel)){
//            member.setCel(cel);
//        }
//        //验证密码
//        if (StringUtils.isEmpty(passwd)){
//            responseObserver.onError(new Exception("passwd must have value"));
//        }
//
//
//
//        if (StringUtils.isEmpty(email) && StringUtils.isEmpty(cel)) {
//            responseObserver.onError(new Exception("email or cel must have value"));
//        }

    }

    @Override
    public void selectById(MemberIdMsg request, StreamObserver<MemberMsg> responseObserver) {
        String id = request.getId();
        Member member = memberMapper.selectByPrimaryKey(id);
        MemberMsg.Builder builder = MemberMsg.newBuilder();
        if (member == null) {
            log.warn("user not found:   " + id);
            responseObserver.onError(new StatusException(Status.NOT_FOUND));
            return;
        }
        MemberMsg memberMsg = builder.setCel(member.getCel()).setEmail(member.getEmail()).setId(member.getId()).build();
        responseObserver.onNext(memberMsg);
        responseObserver.onCompleted();
    }

    @Override
    public void selectByCelPass(CelPassMsg request, StreamObserver<MemberIdMsg> responseObserver) {
        String id = memberMapper.selectByCelPass(request.getCel(), request.getPass());

        responseObserver.onNext(MemberIdMsg.newBuilder().setId(id).build());
        responseObserver.onCompleted();

    }

    @Override
    public void selectByEmailPass(EmailPassMsg request, StreamObserver<MemberIdMsg> responseObserver) {
        String id = memberMapper.selectByEmailPass(request.getEmail(), request.getPass());

        responseObserver.onNext(MemberIdMsg.newBuilder().setId(id).build());
        responseObserver.onCompleted();
    }

    @Override
    public void updateByPrimaryKey(MemberMsg request, StreamObserver<RecordMsg> responseObserver) {
        Member member = new Member();
        BeanUtils.copyProperties(request, member);
        if (member != null) {
            int record = memberMapper.updateByPrimaryKey(member);
            responseObserver.onNext(RecordMsg.newBuilder().setCount(record).build());
            responseObserver.onCompleted();
        }
    }
}
