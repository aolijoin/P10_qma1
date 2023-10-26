package cn.jiyun.controller;

import cn.jiyun.entity.User;
import cn.jiyun.result.Result;
import cn.jiyun.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Slf4j
@RequestMapping("user")
@RestController
public class UserController {
    @Resource
    private UserService userService;


    @RequestMapping("login")
    public Result login(@RequestBody User user, HttpSession session,String token) {
        return userService.login(user,session,token);
    }

    @RequestMapping("jwtLogin")
    public Result jwtLogin(Integer id){
        return userService.jwtLogin(id);
    }
}
