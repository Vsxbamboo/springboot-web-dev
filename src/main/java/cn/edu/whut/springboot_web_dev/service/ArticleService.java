package cn.edu.whut.springboot_web_dev.service;

import java.util.List;

import cn.edu.whut.springboot_web_dev.dto.ArticleCount;
import cn.edu.whut.springboot_web_dev.dto.ArticleForm;
import cn.edu.whut.springboot_web_dev.model.Article;

public interface ArticleService {
    public List<ArticleCount> getArticleCounts();
    public List<Article> getArticlesByAuthor(String author);
    public void addArticle(ArticleForm form);
    public void deleteArticle(Integer articleId);
    public void updateArticle(Integer articleId, ArticleForm form);
}
