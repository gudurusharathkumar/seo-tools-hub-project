package com.seo.seotoolshub.controller;

import com.seo.seotoolshub.model.SeoResult;
import com.seo.seotoolshub.service.SeoService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/seo")
public class SeoController {

    private final SeoService seoService;

    // Constructor Injection
    public SeoController(SeoService seoService) {
        this.seoService = seoService;
    }

    // ================= EXISTING API =================
    @GetMapping("/analyze")
    public SeoResult analyze(@RequestParam String url,
                             @RequestParam String keyword) {

        return seoService.analyze(url, keyword);
    }

    // ================= NEW API 1: WORD COUNT =================
    @PostMapping("/wordcount")
    public Map<String, Object> wordCount(@RequestBody Map<String, String> request) {

        String text = request.get("text");

        int words = text.trim().split("\\s+").length;
        int characters = text.length();
        int sentences = text.split("[.!?]").length;
        int readingTime = Math.max(1, words / 200);

        Map<String, Object> response = new HashMap<>();
        response.put("wordCount", words);
        response.put("characterCount", characters);
        response.put("sentenceCount", sentences);
        response.put("readingTime", readingTime + " min");

        return response;
    }

    // ================= NEW API 2: KEYWORD DENSITY =================
    @PostMapping("/keyword-density")
    public Map<String, Object> keywordDensity(@RequestBody Map<String, String> request) {

        String text = request.get("text").toLowerCase();
        String keyword = request.get("keyword").toLowerCase();

        int totalWords = text.split("\\s+").length;
        int count = text.split(keyword, -1).length - 1;

        double density = ((double) count / totalWords) * 100;

        Map<String, Object> response = new HashMap<>();
        response.put("count", count);
        response.put("density", String.format("%.2f", density) + "%");

        return response;
    }

    // ================= NEW API 3: SERP PREVIEW =================
    @PostMapping("/serp-preview")
    public Map<String, String> serpPreview(@RequestBody Map<String, String> request) {

        Map<String, String> response = new HashMap<>();
        response.put("title", request.get("title"));
        response.put("description", request.get("description"));
        response.put("url", request.get("url"));

        return response;
    }

    // ================= NEW API 4: SITE HEALTH =================
    @GetMapping("/health")
    public Map<String, Object> siteHealth(@RequestParam String url) {

        Map<String, Object> response = new HashMap<>();
        response.put("status", "Good");
        response.put("performance", "Fast");
        response.put("seoScore", 85);

        return response;
    }
}