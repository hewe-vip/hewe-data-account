package vip.hewe.data.dao;

import org.apache.ibatis.annotations.Mapper;
import vip.hewe.data.domain.Member;

/**
 *
 */
@Mapper
public interface MemberDao {
    String add(Member member);

    String remove(String id);

    Member get(String id);

    String update(Member member);

    String validate(String identity, String passwd);
}
