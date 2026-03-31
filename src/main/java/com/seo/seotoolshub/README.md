#  SEO Tools Hub (Spring Boot Project)

##  Project Description

SEO Tools Hub is a Spring Boot based REST API project that analyzes a website's SEO performance.
It fetches webpage data using Jsoup and calculates important SEO metrics like title length, description length, word count, keyword frequency, and SEO score.

---

##  Features

* Analyze any website URL
* Extract:

    * Page Title
    * Meta Description
    * Word Count
    * Keyword Count
* Calculate SEO Score
* Store results in MySQL database
* REST API tested using Postman

---

##  Technologies Used

* Java 17
* Spring Boot
* Spring Data JPA
* MySQL
* Jsoup (for web scraping)
* Postman (API testing)
* IntelliJ IDEA

---

##  Project Structure

com.seo.seotoolshub
│── controller
│── service
│── repository
│── model
│── resources

---

##  API Endpoint

###  Analyze Website SEO

**Method:** GET

**URL:**
http://localhost:8080/seo/analyze

**Query Parameters:**

* url = Website URL
* keyword = Keyword to analyze

---

##  Example Request

http://localhost:8080/seo/analyze?url=https://wikipedia.org&keyword=wiki

---

##  Example Response

```json
{
  "title": "Wikipedia",
  "description": "Wikipedia is a free online encyclopedia...",
  "wordCount": 775,
  "score": 70,
  "keywordCount": 24
}
```

---

##  Database (MySQL)

Table Name: `seo_result`

Columns:

* id
* url
* keyword
* score
* word_count
* keyword_count

---

##  How to Run Project

1. Open project in IntelliJ IDEA
2. Run `SeoToolsHubApplication.java`
3. Server starts on port 8080
4. Open Postman
5. Send GET request

---

##  Testing

* Tool used: Postman
* API tested with multiple URLs
* Data stored successfully in MySQL

---

##  Future Improvements

* Add frontend UI (React / HTML)
* Add more SEO metrics
* Add authentication
* Export reports (PDF)

---

##  Author

Sharath Kumar

---

##  Note

This project is built for learning and demonstration purposes.
