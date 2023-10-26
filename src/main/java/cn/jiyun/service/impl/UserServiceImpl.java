package cn.jiyun.service.impl;

import cn.jiyun.entity.User;
import cn.jiyun.mapper.UserMapper;
import cn.jiyun.result.Result;
import cn.jiyun.service.UserService;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public Result login(User user, HttpSession session, String token) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, user.getUsername());
        wrapper.eq(User::getPassword, user.getPassword());
        User login = userMapper.selectOne(wrapper);
        if (login != null) {
            session.setAttribute("login", login);
            if (token != null && !"".equals(token)) {
                redisTemplate.boundValueOps(login.getId() + "").set(JSONObject.toJSONString(login));
            }
            return Result.success(login);
        } else {
            return Result.error("账号或密码错误！！");
        }
    }

    @Override
    public Result jwtLogin(Integer id) {
        String login = (String) redisTemplate.boundValueOps(id + "").get();

        User loginUser = JSON.toJavaObject(login, User.class);

        if (loginUser != null) {
            return Result.success(loginUser);
        } else {
            return Result.error("登录失效，请重新登录");
        }

    }
}
