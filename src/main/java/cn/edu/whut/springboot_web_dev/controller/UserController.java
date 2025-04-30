package cn.edu.whut.springboot_web_dev.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/login")
    public String login() {
        return "login success";
    }
    @GetMapping("/{username}")
    public String getUserByUsername(@PathVariable String username) {
        return "vsx";
    }
}