package com.kirill.aws_example_project.controller;

import com.kirill.aws_example_project.service.S3Service;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;

@AllArgsConstructor
@Controller
@Slf4j
public class ImageController {
    private final S3Service s3Service;

    @GetMapping("/view")
    public String showImage(Model model) {
        model.addAttribute("streamEndpoint", "/image/stream?key=images/4084DC16-DC83-4270-882F-62EE3FD909AB.png");
        model.addAttribute("refreshMs", 1200);
        return "stream-image";
    }

    @GetMapping(value = "/image/stream", produces = MediaType.IMAGE_PNG_VALUE)
    public StreamingResponseBody imageStream(@RequestParam("key") String key) {
        log.info("Start ask an imag");
        return outputStream -> {
            try(ResponseInputStream<GetObjectResponse> input = s3Service.getFileFromS3(key)) {
                input.transferTo(outputStream);
            }
        };
    }
}
