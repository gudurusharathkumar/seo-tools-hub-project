#  SEO Tools Hub (Backend Project)

##  Overview
SEO Tools Hub is a backend application developed using Spring Boot that provides multiple SEO-related functionalities through REST APIs. It allows users to analyze websites, generate SEO data, and retrieve useful insights in real-time.

---

##  Features

### 1. SEO Analysis
- Analyze a website using URL and keyword
- Returns:
    - Word count
    - Keyword count
    - SEO score

### 2. SEO Audit
- Extracts important SEO elements from a webpage
- Returns:
    - Title
    - Meta description

### 3. Keyword Tool
- Generates keyword suggestions based on input keyword

### 4. Backlink Checker
- Provides backlink count for a given URL

### 5. SEO Generators

#### Meta Tag Generator
- Generates HTML meta tags:
    - Title
    - Description
    - Keywords

#### Sitemap Generator
- Generates XML sitemap for given URLs

---

##  New Features (Frontend Integration)

### 6. Word Counter API
- Returns:
    - Word count
    - Character count
    - Sentence count
    - Reading time

### 7. Keyword Density API
- Returns:
    - Keyword frequency
    - Density percentage

### 8. SERP Preview API
- Returns:
    - Title
    - Description
    - URL preview

### 9. Site Health API
- Returns:
    - Status
    - Performance
    - SEO Score

---

##  CORS Configuration
Enabled for frontend:
http://localhost:3000

---

##  Tech Stack
- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Jsoup
- Postman

---

##  Project Structure
com.seo.seotoolshub  
├── controller  
├── service  
├── repository  
├── model  
├── config

---

##  How to Run
1. Clone the repository
2. Open in IntelliJ / Eclipse
3. Configure MySQL in application.properties
4. Run:
   SeoToolsHubApplication.java
5. Server starts at:
   http://localhost:8080

---

##  API Endpoints

### SEO Analysis
GET /seo/analyze?url={url}&keyword={keyword}

### SEO Audit
GET /seo/audit?url={url}

### Keyword Tool
GET /seo/keywords?keyword={keyword}

### Backlink Checker
GET /seo/backlinks?url={url}

### Meta Generator
POST /seo/meta

Sample Body:
{
"title": "My Website",
"description": "Best SEO tools",
"keywords": "seo, tools, website"
}

### Sitemap Generator
POST /seo/sitemap

Sample Body:
{
"urls": [
"https://google.com",
"https://github.com"
]
}

---

##  New API Endpoints

### Word Counter
POST /seo/wordcount

Body:
{
"text": "Java is powerful and easy"
}

### Keyword Density
POST /seo/keyword-density

Body:
{
"text": "java java spring java",
"keyword": "java"
}

### SERP Preview
POST /seo/serp-preview

Body:
{
"title": "Best SEO Tools",
"description": "Top tools for SEO analysis",
"url": "https://example.com"
}

### Site Health
GET /seo/health?url={url}

---

##  Testing
- Tested using Postman
- Verified real-time outputs
- MySQL database connected

---

##  Highlights
- Clean architecture (Controller → Service → Repository)
- REST API design
- Real-time processing using Jsoup
- MySQL integration
- CORS enabled for frontend
- No static/dummy data

---

##  Conclusion
This project demonstrates backend development using Spring Boot, including API design, database integration, and frontend-backend connectivity.

---

##  Author
Sharath Kumar