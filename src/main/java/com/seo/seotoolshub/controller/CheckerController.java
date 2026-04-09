package com.seo.seotoolshub.controller;

import com.seo.seotoolshub.model.BacklinkResult;
import com.seo.seotoolshub.service.CheckerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seo")
public class CheckerController {

    private final CheckerService service;

    public CheckerController(CheckerService service) {
        this.service = service;
    }

    @GetMapping("/backlinks")
    public BacklinkResult backlinks(@RequestParam String url) {
        return service.checkBacklinks(url); //  FIXED
    }
}