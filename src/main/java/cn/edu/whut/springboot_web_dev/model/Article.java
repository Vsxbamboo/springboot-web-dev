package cn.edu.whut.springboot_web_dev.model;

import lombok.Data;

@Data
public class Article {
    private Integer articleId;
    private String author;
    private String title;
    private String content;
}
