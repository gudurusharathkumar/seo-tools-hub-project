package com.seo.seotoolshub.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import com.seo.seotoolshub.model.BacklinkResult;
import com.seo.seotoolshub.repository.BacklinkResultRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CheckerService {

    @Autowired
    private BacklinkResultRepository repository;

    public BacklinkResult checkBacklinks(String url) {

        BacklinkResult result = new BacklinkResult();

        try {
            Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0").get();
            int links = doc.select("a[href]").size();

            result.setUrl(url);
            result.setBacklinks(links);

        } catch (Exception e) {
            result.setUrl(url);
            result.setBacklinks(0);
        }

        return repository.save(result); //  SAVE EVERY TIME
    }
}