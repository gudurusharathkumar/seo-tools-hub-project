package com.seo.seotoolshub.controller;

import com.seo.seotoolshub.service.KeywordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seo")
public class KeywordController {

    private final KeywordService service;

    public KeywordController(KeywordService service) {
        this.service = service;
    }

    @GetMapping("/keywords")
    public List<String> keywords(@RequestParam String keyword) {
        return service.getKeywords(keyword);
    }
}