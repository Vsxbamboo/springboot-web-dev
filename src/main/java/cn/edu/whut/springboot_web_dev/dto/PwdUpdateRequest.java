package cn.edu.whut.springboot_web_dev.dto;

import lombok.Data;

@Data
public class PwdUpdateRequest {
    private String username;
    private String password;
    private String newPassword;
}
