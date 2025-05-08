package cn.edu.whut.springboot_web_dev.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cn.edu.whut.springboot_web_dev.service.ImgService;

@Service
public class ImgServiceImpl implements ImgService {

    // 设定图片保存路径（可在 application.properties 中配置）
    @Value("${images.dir}")
    private String uploadDir;

    @Override
    public URI save(MultipartFile file) throws IOException, NoSuchAlgorithmException {

        // 生成唯一文件名（避免重复）
        String filename = getFileMd5(file);

        // 确保目录存在
        Path uploadPath = Paths.get(uploadDir);
        Files.createDirectories(uploadPath);

        // 保存文件
        Path filePath = uploadPath.resolve(filename);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        // 构造文件访问 URI（假设你有个 GET /images/{filename} 显示图片）
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/images/")
                .path(filename)
                .build()
                .toUri();
        return location;
    }

    public String getFileMd5(MultipartFile file) throws IOException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(file.getBytes());

        // 转成十六进制字符串
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

}
