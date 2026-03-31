package com.seo.seotoolshub.service;

import com.seo.seotoolshub.repository.SeoResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.seo.seotoolshub.model.SeoResult;
import com.seo.seotoolshub.model.SeoResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
public class SeoService {

    @Autowired
    private SeoResultRepository repository;

    public SeoResponse analyze(String url, String keyword) {
        try {
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
                    .header("Accept-Language", "en-US")
                    .timeout(10000)
                    .get();

            String title = doc.title();
            String description = doc.select("meta[name=description]").attr("content");
            String bodyText = doc.body().text().toLowerCase();

            int keywordCount = bodyText.split(keyword.toLowerCase(), -1).length - 1;
            int wordCount = doc.body().text().split("\\s+").length;
            int score = 0;

            if (title.length() >= 30 && title.length() <= 60) {
                score += 30;
            }

            if (description.length() >= 50 && description.length() <= 160) {
                score += 30;
            }

            if (wordCount > 300) {
                score += 40;
            }

            //  SAVE DATA INTO MYSQL
            SeoResult result = new SeoResult();
            result.setUrl(url);
            result.setKeyword(keyword);
            result.setScore(score);
            result.setWordCount(wordCount);
            result.setKeywordCount(keywordCount);

            repository.save(result);

            return new SeoResponse(title, description, wordCount, score, keywordCount);

        } catch (Exception e) {
            return new SeoResponse("Error", "Unable to fetch data", 0, 0, 0);
        }
    }
}