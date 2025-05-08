package cn.edu.whut.springboot_web_dev.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.whut.springboot_web_dev.dto.ArticleCount;
import cn.edu.whut.springboot_web_dev.dto.ArticleForm;
import cn.edu.whut.springboot_web_dev.mapper.ArticleMapper;
import cn.edu.whut.springboot_web_dev.mapper.UserMapper;
import cn.edu.whut.springboot_web_dev.model.Article;
import cn.edu.whut.springboot_web_dev.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<ArticleCount> getArticleCounts() {
        List<String> usernames = userMapper.getAllUsernames();
        List<ArticleCount> articleCounts = new ArrayList<>();
        for (String username : usernames) {
            Integer count = articleMapper.countArticleByUsername(username);
            ArticleCount articleCount = new ArticleCount();
            articleCount.setAuthor(username);
            articleCount.setCount(count);
            articleCounts.add(articleCount);
        }
        return articleCounts;
    }

    @Override
    public List<Article> getArticlesByAuthor(String author) {
        return articleMapper.getArticlesByAuthor(author);
    }

    @Override
    public void addArticle(ArticleForm form) {
        articleMapper.insert(form);
    }

    @Override
    public void deleteArticle(Integer articleId) {
        articleMapper.delete(articleId);
    }

    @Override
    public void updateArticle(Integer articleId, ArticleForm form) {
        articleMapper.update(articleId, form);
    }

}
