package jiedai_app.controller;

import jiedai_app.pojo.Result;
import jiedai_app.pojo.Users;
import jiedai_app.service.UsersService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UsersController {
    @Autowired
    private UsersService usersService;
    @GetMapping("/api/user/list")
    public Result list(){
        List<Users> usersList= usersService.list();
        return Result.success(usersList);
    }
    @PostMapping("/api/permission/createUser")
    public Result createUser(@RequestBody Users user){
        usersService.createUser(user);
        return Result.success("数据新增成功");
    }
    @PostMapping("/api/user/logout")
    public Result doLogout(){
        usersService.doLogout();
        return Result.logout();
    }
    @PostMapping("/api/user/info")
    public Result userInfo(@RequestBody Users users){
        Users info = usersService.userInfo(users);
        Map<String,Object> dataMap =new HashMap<>();
        dataMap.put("info","获取成功");
        dataMap.put("roles",info.getRole());
        return Result.success(dataMap);
    }
}
