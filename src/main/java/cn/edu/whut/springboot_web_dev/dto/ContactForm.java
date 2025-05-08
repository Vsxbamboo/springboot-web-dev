package cn.edu.whut.springboot_web_dev.dto;

import lombok.Data;

@Data
public class ContactForm {
    private String name;
    private String province;
    private String city;
    private String address;
    private String postalCode;
    private java.time.LocalDateTime date;
}
