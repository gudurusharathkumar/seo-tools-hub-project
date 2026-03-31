package com.seo.seotoolshub.model;

public class SeoResponse {

    private String title;
    private String description;
    private int wordCount;
    private int score;
    private int keywordCount;

    public SeoResponse(String title, String description, int wordCount, int score, int keywordCount) {
        this.title = title;
        this.description = description;
        this.wordCount = wordCount;
        this.score = score;
        this.keywordCount = keywordCount;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getWordCount() {
        return wordCount;
    }
    public int getScore() {
        return score;
    }
    public int getKeywordCount() {
        return keywordCount;
    }
}