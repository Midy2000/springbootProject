package jiedai_app.service.impl;

import jiedai_app.mapper.UsersMapper;
import jiedai_app.pojo.Users;
import jiedai_app.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;
    public List<Users> list(){
        return usersMapper.list();
    }
    public void createUser(Users users){
        if (users.getRole().equals("2")){
            users.setRole("input");
        }else if (users.getRole().equals("1")){
            users.setRole("approve");
        }
        users.setRegTime(LocalDateTime.now());
        users.setCreator("administrator");
        usersMapper.createUser(users);
    }
    public void doLogout(){

    }
    public Users userInfo(Users users){
        Users user = usersMapper.userInfo(users);
        return user;
    }
}
