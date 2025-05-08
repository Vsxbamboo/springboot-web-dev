package cn.edu.whut.springboot_web_dev.dto;

import lombok.Data;

@Data
public class UserInfo {
    private String username;
    private String email;
    private java.math.BigDecimal balance;
    private java.time.LocalDate birthday;
    private String avatarId;
}
