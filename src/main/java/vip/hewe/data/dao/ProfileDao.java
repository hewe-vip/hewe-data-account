package vip.hewe.data.dao;

import org.apache.ibatis.annotations.Mapper;
import vip.hewe.data.domain.Profile;

/**
 *
 */
@Mapper
public interface ProfileDao {
    int deleteByPrimaryKey(String id);

    int insert(Profile record);

    Profile selectByPrimaryKey(String id);

    int updateByPrimaryKey(Profile record);
}
