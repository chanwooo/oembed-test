package com.example.oembedtest.controller;

import com.example.oembedtest.service.OEmbedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OEmbedApiController {

    private final OEmbedService oEmbedService;

    @GetMapping("oembed")
    String getOEmbed(@RequestParam final String url) {
        String oEmbedUrl = oEmbedService.oEmbedUrlConverter(url);
        return oEmbedService.httpGet(oEmbedUrl);
    }
}
