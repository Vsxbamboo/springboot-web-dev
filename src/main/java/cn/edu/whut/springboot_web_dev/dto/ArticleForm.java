package cn.edu.whut.springboot_web_dev.dto;

import lombok.Data;

@Data
public class ArticleForm {
    private String author;
    private String title;
    private String content;
}
