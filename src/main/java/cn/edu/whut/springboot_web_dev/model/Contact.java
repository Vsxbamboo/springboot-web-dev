package cn.edu.whut.springboot_web_dev.model;

import lombok.Data;

@Data
public class Contact {
    private String username;
    private String name;
    private String province;
    private String city;
    private String address;
    private String postalCode;
    private java.time.LocalDateTime date;
}
