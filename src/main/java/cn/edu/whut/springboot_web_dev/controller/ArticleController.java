package cn.edu.whut.springboot_web_dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.whut.springboot_web_dev.dto.ArticleCount;
import cn.edu.whut.springboot_web_dev.dto.ArticleForm;
import cn.edu.whut.springboot_web_dev.model.Article;
import cn.edu.whut.springboot_web_dev.service.ArticleService;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @GetMapping
    public List<ArticleCount> getArticleCounts() {
        return articleService.getArticleCounts();
    }
    @GetMapping("/{author}")
    public List<Article> getArticlesByAuthor(@PathVariable String author) {
        return articleService.getArticlesByAuthor(author);
    }
    @PostMapping
    public ResponseEntity<Void> addArticle(@RequestBody ArticleForm form) {
        articleService.addArticle(form);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{articleId}")
    public ResponseEntity<Void> updateArticle(@PathVariable Integer articleId, @RequestBody ArticleForm form) {
        articleService.updateArticle(articleId, form);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{articleId}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Integer articleId) {
        articleService.deleteArticle(articleId);
        return ResponseEntity.ok().build();
    }
}
