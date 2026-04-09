package com.seo.seotoolshub.model;

import jakarta.persistence.*;

@Entity
public class AuditResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String url;
    private String title;

    @Column(length = 2000)
    private String description;

    // getters & setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}