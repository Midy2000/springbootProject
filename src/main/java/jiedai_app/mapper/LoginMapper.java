package jiedai_app.mapper;

import jiedai_app.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {
    @Select("select * from t_user where username= #{username} and password =#{password}")
    Users login(Users users);
}
