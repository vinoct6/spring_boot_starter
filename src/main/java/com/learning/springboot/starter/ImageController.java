package com.learning.springboot.starter;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/image")
public class ImageController {

    @GetMapping(produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage() throws IOException {
        System.out.println("i am inside");
        ClassPathResource classPathResource = new ClassPathResource("buildit1.jpg");
        return IOUtils.toByteArray(classPathResource.getInputStream());
    }
}
