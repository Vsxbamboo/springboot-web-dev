package cn.edu.whut.springboot_web_dev.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.whut.springboot_web_dev.dto.PwdUpdateRequest;
import cn.edu.whut.springboot_web_dev.mapper.UserMapper;
import cn.edu.whut.springboot_web_dev.model.User;
import cn.edu.whut.springboot_web_dev.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    
    @Override
    public void createUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public User findUserByUsername(String username) {
        User user = userMapper.findByUsername(username);
        return user;
    }

    @Override
    public Boolean updatePassword(PwdUpdateRequest request) {
        User user = userMapper.findByUsername(request.getUsername());
        if (user == null || !user.getPassword().equals(request.getPassword())) {
            return false;
        }
        userMapper.updatePassword(request);
        return true;
    }
}
