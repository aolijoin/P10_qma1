package cn.jiyun.service;

import cn.jiyun.entity.User;
import cn.jiyun.result.Result;

import javax.servlet.http.HttpSession;

public interface UserService {
    Result login(User user, HttpSession session, String token);

    Result jwtLogin(Integer id);
}
