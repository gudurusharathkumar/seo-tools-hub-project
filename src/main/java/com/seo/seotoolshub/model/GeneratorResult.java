package com.seo.seotoolshub.model;

import jakarta.persistence.*;

@Entity
public class GeneratorResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;

    @Column(length = 5000)
    private String output;

    // getters & setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getOutput() { return output; }
    public void setOutput(String output) { this.output = output; }
}