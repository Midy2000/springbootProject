package jiedai_app.controller;

import jiedai_app.pojo.Result;
import jiedai_app.pojo.Users;
import jiedai_app.service.LoginService;
import jiedai_app.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/api/user/login")
    public Result login(@RequestBody Users users){
        Users user = loginService.login(users);
        if (user!=null){
            Map<String,Object> claims =new HashMap<>();
            claims.put("role",user.getRole());
            claims.put("username",user.getUsername());
            String jwt = JwtUtils.generateJwt(claims);
            Map<String,Object> map =new HashMap<>();
            map.put("token",jwt);
            map.put("role",user.getRole());
            return Result.success(map);
        }
        return Result.error("登录失败");
    }
}
