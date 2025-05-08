package cn.edu.whut.springboot_web_dev.controller;

import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.whut.springboot_web_dev.dto.ImgUploadResponse;
import cn.edu.whut.springboot_web_dev.service.ImgService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/images")
public class ImgController {

    @Autowired
    private ImgService imgService;

    @PostMapping
    public ResponseEntity<ImgUploadResponse> uploadImg(@RequestParam("file") MultipartFile file) throws IOException, NoSuchAlgorithmException {
        URI location = imgService.save(file);
        ImgUploadResponse response = new ImgUploadResponse();
        response.setUrl(location.toString());
        return ResponseEntity.ok(response);
    }
    // 获取图片接口，参数为图片的文件名
    @GetMapping("/{avatarId}")
    public ResponseEntity<Resource> getImg(@PathVariable("avatarId") String avatarId) throws IOException {
        try {
            Path imagePath = Paths.get("uploads/images").resolve(avatarId).normalize();
            Resource resource = new UrlResource(imagePath.toUri());

            if (!resource.exists()) {
                return ResponseEntity.notFound().build();
            }

            Tika tika = new Tika();
            String contentType = tika.detect(imagePath.toFile());

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);

        } catch (MalformedURLException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
