package com.seo.seotoolshub.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GeneratorService {

    //  META TAG GENERATOR (ONLY LOGIC)
    public String generateMetaTags(Map<String, String> data) {

        String title = data.getOrDefault("title", "").trim();
        String description = data.getOrDefault("description", "").trim();
        String keywords = data.getOrDefault("keywords", "").trim();

        //  prevent invalid input
        if (title.isEmpty() || description.isEmpty()) {
            return "Invalid meta data";
        }

        return "<title>" + title + "</title>\n" +
                "<meta name=\"description\" content=\"" + description + "\">\n" +
                "<meta name=\"keywords\" content=\"" + keywords + "\">";
    }

    //  SITEMAP GENERATOR (STRICT + CLEAN)
    public String generateSitemap(Map<String, Object> data) {

        StringBuilder sitemap = new StringBuilder();

        sitemap.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        sitemap.append("<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">\n");

        boolean hasData = false;

        try {
            if (data.containsKey("urls")) {
                List<String> urls = (List<String>) data.get("urls");

                if (urls != null && !urls.isEmpty()) {
                    for (String url : urls) {
                        if (url != null && !url.trim().isEmpty()) {

                            sitemap.append("   <url>\n");
                            sitemap.append("      <loc>").append(url.trim()).append("</loc>\n");
                            sitemap.append("      <changefreq>daily</changefreq>\n");
                            sitemap.append("      <priority>0.8</priority>\n");
                            sitemap.append("   </url>\n");

                            hasData = true;
                        }
                    }
                }
            }

            else if (data.containsKey("url")) {
                String url = data.get("url").toString().trim();

                if (!url.isEmpty()) {

                    sitemap.append("   <url>\n");
                    sitemap.append("      <loc>").append(url).append("</loc>\n");
                    sitemap.append("      <changefreq>daily</changefreq>\n");
                    sitemap.append("      <priority>0.8</priority>\n");
                    sitemap.append("   </url>\n");

                    hasData = true;
                }
            }

        } catch (Exception e) {
            return "Invalid input";
        }

        sitemap.append("</urlset>");

        if (!hasData) {
            return "No valid URL provided";
        }

        return sitemap.toString();
    }
}