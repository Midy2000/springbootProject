package jiedai_app.service.impl;

import jiedai_app.mapper.LoginMapper;
import jiedai_app.pojo.Users;
import jiedai_app.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    public Users login(Users users){
        Users user = loginMapper.login(users);
        return user;
    }
}
