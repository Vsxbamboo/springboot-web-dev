package cn.edu.whut.springboot_web_dev.dto;

import lombok.Data;

@Data
public class RegistryRequest {
    private String username;
    private String password;
    private String email;
    private java.time.LocalDate birthday;
    private String avatarId;
}
