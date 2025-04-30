package cn.edu.whut.springboot_web_dev.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(@NonNull CorsRegistry registry) {
        registry.addMapping("/**")  // 配置哪些路径需要支持跨域
                .allowedOrigins("http://localhost:8081")  // 允许的源
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // 允许的方法
                .allowedHeaders("*")  // 允许的请求头
                .allowCredentials(true);  // 允许携带身份验证信息
    }
}

