package vip.hewe.data.dao;

import org.apache.ibatis.annotations.Mapper;
import vip.hewe.data.domain.Mprofile;

/**
 *
 */
@Mapper
public interface ProfileDao {
    String add(Mprofile mprofile);

    String remove(String id);

    Mprofile get(String id);

    String update(Mprofile mprofile);

    String validate(String identity, String passwd);
}
