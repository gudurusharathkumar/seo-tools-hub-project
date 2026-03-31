package com.seo.seotoolshub.model;

import jakarta.persistence.*;

@Entity
public class SeoResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;
    private String keyword;
    private int score;
    private int wordCount;
    private int keywordCount;

    // Getters and Setters
    public Long getId() { return id; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getKeyword() { return keyword; }
    public void setKeyword(String keyword) { this.keyword = keyword; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public int getWordCount() { return wordCount; }
    public void setWordCount(int wordCount) { this.wordCount = wordCount; }

    public int getKeywordCount() { return keywordCount; }
    public void setKeywordCount(int keywordCount) { this.keywordCount = keywordCount; }
}