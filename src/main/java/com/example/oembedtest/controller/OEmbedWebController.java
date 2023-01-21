package com.example.oembedtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OEmbedWebController {

    @GetMapping
    public String index() {
        return "index";
    }
}
