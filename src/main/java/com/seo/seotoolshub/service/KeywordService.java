package com.seo.seotoolshub.service;

import com.seo.seotoolshub.model.KeywordResult;
import com.seo.seotoolshub.repository.KeywordResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KeywordService {

    @Autowired
    private KeywordResultRepository repository;

    public List<String> getKeywords(String keyword) {

        List<String> list = new ArrayList<>();

        list.add(keyword + " tutorial");
        list.add(keyword + " course");
        list.add(keyword + " examples");
        list.add(keyword + " interview questions");

        KeywordResult result = new KeywordResult();
        result.setKeyword(keyword);
        result.setResults(String.join(", ", list));

        repository.save(result); // ✅ SAVE EVERY TIME

        return list;
    }
}