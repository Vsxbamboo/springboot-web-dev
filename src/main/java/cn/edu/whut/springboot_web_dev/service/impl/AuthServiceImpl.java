package cn.edu.whut.springboot_web_dev.service.impl;

import cn.edu.whut.springboot_web_dev.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.whut.springboot_web_dev.mapper.UserMapper;
import cn.edu.whut.springboot_web_dev.service.AuthService;
import cn.edu.whut.springboot_web_dev.util.JwtUtil;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String login(String username, String password) {
        User user = userMapper.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return JwtUtil.generateToken(username);
        }
        throw new RuntimeException("用户名或密码错误");
    }
}