package cn.edu.whut.springboot_web_dev.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.edu.whut.springboot_web_dev.dto.ArticleForm;
import cn.edu.whut.springboot_web_dev.model.Article;

@Mapper
public interface ArticleMapper {
    @Select("SELECT COUNT(*) FROM articles WHERE author = #{username}")
    public Integer countArticleByUsername(String username);

    @Select("SELECT * FROM articles WHERE author = #{author}")
    public List<Article> getArticlesByAuthor(String author);

    @Insert("INSERT INTO articles (author, title, content) VALUES (#{author}, #{title}, #{content})")
    public void insert(ArticleForm form);

    @Delete("DELETE FROM articles WHERE article_id = #{articleId}")
    public void delete(Integer articleId);

    @Update("UPDATE articles SET author = #{form.author}, title = #{form.title}, content = #{form.content} WHERE article_id = #{articleId}")
    void update(@Param("articleId") Integer articleId, @Param("form") ArticleForm form);
}
