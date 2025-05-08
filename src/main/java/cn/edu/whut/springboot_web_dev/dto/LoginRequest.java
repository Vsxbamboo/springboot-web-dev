package cn.edu.whut.springboot_web_dev.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
