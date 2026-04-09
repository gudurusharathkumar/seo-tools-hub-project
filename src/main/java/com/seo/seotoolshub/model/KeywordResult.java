package com.seo.seotoolshub.model;

import jakarta.persistence.*;

@Entity
public class KeywordResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String keyword;

    @Column(length = 2000)
    private String results;

    // getters & setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getKeyword() { return keyword; }
    public void setKeyword(String keyword) { this.keyword = keyword; }

    public String getResults() { return results; }
    public void setResults(String results) { this.results = results; }
}