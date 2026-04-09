package com.seo.seotoolshub.controller;

import com.seo.seotoolshub.model.SeoResult;
import com.seo.seotoolshub.service.SeoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seo")
public class SeoController {

    private final SeoService seoService;

    // ✅ Constructor Injection
    public SeoController(SeoService seoService) {
        this.seoService = seoService;
    }

    @GetMapping("/analyze")
    public SeoResult analyze(@RequestParam String url,
                             @RequestParam String keyword) {

        return seoService.analyze(url, keyword);
    }
}