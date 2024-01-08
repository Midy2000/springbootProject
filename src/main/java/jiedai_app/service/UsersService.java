package jiedai_app.service;

import jiedai_app.pojo.Users;

import java.util.List;

public interface UsersService {
    List<Users> list();

    void createUser(Users users);

    Users userInfo(Users users);

    void doLogout();
}
