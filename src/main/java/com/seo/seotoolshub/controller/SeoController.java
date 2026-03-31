package com.seo.seotoolshub.controller;

import com.seo.seotoolshub.model.SeoResponse;
import com.seo.seotoolshub.service.SeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seo")
@CrossOrigin
public class SeoController {

    @Autowired
    private SeoService seoService;

    @GetMapping("/analyze")
    public SeoResponse analyze(
            @RequestParam String url,
            @RequestParam String keyword
    ) {
        return seoService.analyze(url, keyword);
    }
}