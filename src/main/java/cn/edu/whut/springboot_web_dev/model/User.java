package cn.edu.whut.springboot_web_dev.model;

import lombok.Data;

@Data
public class User {
    private String username;
    private String password;
    private String email;
    private java.math.BigDecimal balance;
    private java.time.LocalDate birthday;
    private String avatarId;
}
