package cn.edu.whut.springboot_web_dev.service;

import cn.edu.whut.springboot_web_dev.dto.PwdUpdateRequest;
import cn.edu.whut.springboot_web_dev.model.User;

public interface UserService {
    public void createUser(User user);
    public User findUserByUsername(String username);
    public Boolean updatePassword(PwdUpdateRequest request);
}
