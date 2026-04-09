package com.seo.seotoolshub.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import com.seo.seotoolshub.model.AuditResult;
import com.seo.seotoolshub.repository.AuditResultRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AuditService {

    @Autowired
    private AuditResultRepository repository;

    public AuditResult auditWebsite(String url) {

        AuditResult result = new AuditResult();

        try {
            Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0").get();

            result.setUrl(url);
            result.setTitle(doc.title());
            result.setDescription(
                    doc.select("meta[name=description]").attr("content")
            );

        } catch (Exception e) {
            result.setUrl(url);
            result.setTitle("Error");
            result.setDescription("Failed");
        }

        return repository.save(result); // ✅ SAVE EVERY TIME
    }
}