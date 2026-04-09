package com.seo.seotoolshub.service;

import com.seo.seotoolshub.model.SeoResult;
import com.seo.seotoolshub.repository.SeoResultRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
public class SeoService {

    private final SeoResultRepository repository;

    //  Constructor Injection (BEST PRACTICE)
    public SeoService(SeoResultRepository repository) {
        this.repository = repository;
    }

    public SeoResult analyze(String url, String keyword) {

        SeoResult result = new SeoResult();

        try {
            // 🔹 Fetch HTML using Jsoup
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0")
                    .header("Accept-Language", "en-US,en;q=0.9")
                    .timeout(10000)
                    .get();

            // 🔹 Extract text
            String text = doc.body().text().toLowerCase();

            // 🔹 Word count
            int wordCount = text.split("\\s+").length;

            // 🔹 Keyword count
            int keywordCount = 0;
            String lowerKeyword = keyword.toLowerCase();

            for (String word : text.split("\\s+")) {
                if (word.contains(lowerKeyword)) {
                    keywordCount++;
                }
            }

            // 🔹 SEO Score Logic
            int score = 0;
            if (wordCount > 300) score += 30;
            if (keywordCount > 5) score += 40;
            if (doc.title() != null && !doc.title().isEmpty()) score += 30;

            // 🔹 Set values
            result.setUrl(url);
            result.setKeyword(keyword);
            result.setWordCount(wordCount);
            result.setKeywordCount(keywordCount);
            result.setScore(score);

        } catch (Exception e) {
            e.printStackTrace();

            //  fallback values (but still saved)
            result.setUrl(url);
            result.setKeyword(keyword);
            result.setWordCount(0);
            result.setKeywordCount(0);
            result.setScore(0);
        }

        //  ALWAYS SAVE (IMPORTANT FIX)
        return repository.save(result);
    }
}