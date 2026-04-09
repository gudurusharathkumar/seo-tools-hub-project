package com.seo.seotoolshub.controller;

import com.seo.seotoolshub.model.AuditResult;
import com.seo.seotoolshub.service.AuditService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seo")
public class AuditController {

    private final AuditService auditService;

    public AuditController(AuditService auditService) {
        this.auditService = auditService;
    }

    @GetMapping("/audit")
    public AuditResult audit(@RequestParam String url) {
        return auditService.auditWebsite(url); //  FIXED
    }
}