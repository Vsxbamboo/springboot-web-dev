package cn.edu.whut.springboot_web_dev.controller;

import cn.edu.whut.springboot_web_dev.model.User;
import cn.edu.whut.springboot_web_dev.service.UserService;
import cn.edu.whut.springboot_web_dev.util.JwtUtil;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.whut.springboot_web_dev.dto.PwdUpdateRequest;
import cn.edu.whut.springboot_web_dev.dto.RegistryRequest;
import cn.edu.whut.springboot_web_dev.dto.UserInfo;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired 
    private UserService userService;

    @PostMapping
    public ResponseEntity<Void> register(@RequestBody RegistryRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setBalance(BigDecimal.ZERO);
        user.setBirthday(request.getBirthday());
        user.setAvatarId(request.getAvatarId());
        userService.createUser(user);
        return ResponseEntity.ok().build();
    }
    @GetMapping()
    public ResponseEntity<UserInfo> getUserInfo() {
        String username = JwtUtil.getCurrentUsername();
        User user = userService.findUserByUsername(username);
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(user.getUsername());
        userInfo.setEmail(user.getEmail());
        userInfo.setBalance(user.getBalance());
        userInfo.setBirthday(user.getBirthday());
        userInfo.setAvatarId(user.getAvatarId());
        return ResponseEntity.ok(userInfo);
    }
    @GetMapping("/{username}")
    public ResponseEntity<UserInfo> getUserInfo(@PathVariable String username) {
        User user = userService.findUserByUsername(username);
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(user.getUsername());
        userInfo.setEmail(user.getEmail());
        userInfo.setBalance(user.getBalance());
        userInfo.setBirthday(user.getBirthday());
        userInfo.setAvatarId(user.getAvatarId());
        return ResponseEntity.ok(userInfo);
    }
    @PutMapping
    public ResponseEntity<Void> updateUserInfo(@RequestBody PwdUpdateRequest request) {
        userService.updatePassword(request);
        return ResponseEntity.ok().build();
    }
}