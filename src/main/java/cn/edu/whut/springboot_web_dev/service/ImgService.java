package cn.edu.whut.springboot_web_dev.service;

import java.io.IOException;
import java.net.URI;
import java.security.NoSuchAlgorithmException;

import org.springframework.web.multipart.MultipartFile;

public interface ImgService {
    public URI save(MultipartFile file) throws IOException, NoSuchAlgorithmException;
}
