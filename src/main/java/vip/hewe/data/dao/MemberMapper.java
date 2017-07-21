package vip.hewe.data.dao;

import org.apache.ibatis.annotations.Mapper;
import vip.hewe.data.domain.Member;

@Mapper
public interface MemberMapper {
    int deleteByPrimaryKey(String id);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
}