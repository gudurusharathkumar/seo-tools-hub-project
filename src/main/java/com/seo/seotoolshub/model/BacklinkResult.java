package com.seo.seotoolshub.model;

import jakarta.persistence.*;

@Entity
public class BacklinkResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String url;
    private int backlinks;

    // getters & setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public int getBacklinks() { return backlinks; }
    public void setBacklinks(int backlinks) { this.backlinks = backlinks; }
}