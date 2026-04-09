#  SEO Tools Hub (Backend Project)

##  Overview

SEO Tools Hub is a backend application developed using Spring Boot that provides multiple SEO-related functionalities through REST APIs.
It allows users to analyze websites, generate SEO data, and retrieve useful insights in real-time.

---

##  Features

###  1. SEO Analysis

* Analyze a website using URL and keyword
* Returns:

  * Word count
  * Keyword count
  * SEO score

---

###  2. SEO Audit

* Extracts important SEO elements from a webpage
* Returns:

  * Title
  * Meta description

---

###  3. Keyword Tool

* Generates keyword suggestions based on input keyword

---

###  4. Backlink Checker

* Provides backlink count for a given URL

---

###  5. SEO Generators

####  Meta Tag Generator

* Generates HTML meta tags:

  * Title
  * Description
  * Keywords

####  Sitemap Generator

* Generates XML sitemap for given URLs

---

##  Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Jsoup
* Postman

---

##  Project Structure

```
com.seo.seotoolshub
 ├── controller
 ├── service
 ├── repository
 ├── model
```

---

##  How to Run

1. Clone the repository
2. Open in IntelliJ / Eclipse
3. Configure MySQL in `application.properties`
4. Run the main class:

   ```
   SeoToolsHubApplication.java
   ```
5. Server starts at:

   ```
   http://localhost:8080
   ```

---

##  API Endpoints

###  SEO Analysis

```
GET /seo/analyze?url={url}&keyword={keyword}
```

###  SEO Audit

```
GET /seo/audit?url={url}
```

###  Keyword Tool

```
GET /seo/keywords?keyword={keyword}
```

###  Backlink Checker

```
GET /seo/backlinks?url={url}
```

###  Meta Generator

```
POST /seo/meta
```

#### Sample Body:

```json
{
  "title": "My Website",
  "description": "Best SEO tools",
  "keywords": "seo, tools, website"
}
```

---

###  Sitemap Generator

```
POST /seo/sitemap
```

#### Sample Body:

```json
{
  "urls": [
    "https://google.com",
    "https://github.com"
  ]
}
```

---

##  Testing

* All APIs tested using Postman
* Real-time results verified
* Database entries confirmed in MySQL

---

##  Highlights

* Clean layered architecture (Controller → Service → Repository)
* Real-time web scraping using Jsoup
* RESTful API design
* MySQL database integration
* No dummy/static data

---

##  Conclusion

This project demonstrates backend development skills using Spring Boot, including API development, database integration, and real-time data processing.

---

##  Author

**Sharath Kumar**

---
