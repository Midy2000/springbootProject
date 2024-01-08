package jiedai_app.mapper;

import jiedai_app.pojo.Users;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UsersMapper {
    @Select("select * from t_user")
    List<Users> list();
    @Insert("insert into t_user(username, password, role, reg_time, creator) VALUES (#{username},#{password},#{role},#{regTime},#{creator})")
    void createUser(Users users);
    @Select("select username, password, role from t_user where username=#{username}")
    Users userInfo(Users users);
}
