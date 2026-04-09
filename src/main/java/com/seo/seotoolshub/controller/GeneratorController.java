package com.seo.seotoolshub.controller;

import com.seo.seotoolshub.model.GeneratorResult;
import com.seo.seotoolshub.repository.GeneratorResultRepository;
import com.seo.seotoolshub.service.GeneratorService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/seo")
public class GeneratorController {

    private final GeneratorService service;
    private final GeneratorResultRepository repository;

    public GeneratorController(GeneratorService service,
                               GeneratorResultRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    // 🔥 META API
    @PostMapping("/meta")
    public String generateMeta(@RequestBody Map<String, String> data) {

        String result = service.generateMetaTags(data);

        // ❌ don't save invalid
        if (result.equals("Invalid meta data")) {
            return result;
        }

        GeneratorResult entity = new GeneratorResult();
        entity.setType("meta");
        entity.setOutput(result);

        repository.save(entity);

        return result;
    }

    // 🔥 SITEMAP API
    @PostMapping("/sitemap")
    public String generateSitemap(@RequestBody Map<String, Object> data) {

        String result = service.generateSitemap(data);

        // ❌ don't save invalid
        if (result.equals("No valid URL provided") || result.equals("Invalid input")) {
            return result;
        }

        GeneratorResult entity = new GeneratorResult();
        entity.setType("sitemap");
        entity.setOutput(result);

        repository.save(entity);

        return result;
    }
}