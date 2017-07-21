package vip.hewe.data.dao;

import org.apache.ibatis.annotations.Mapper;
import vip.hewe.data.domain.Mprofile;

@Mapper
public interface MprofileMapper {
    int deleteByPrimaryKey(String id);

    int insert(Mprofile record);

    int insertSelective(Mprofile record);

    Mprofile selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Mprofile record);

    int updateByPrimaryKey(Mprofile record);
}