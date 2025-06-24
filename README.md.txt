🧊 Refrigerator API


A Java 21 / Spring Boot 3.5 REST API for tracking fridge and freezer goods — built with PostgreSQL, Docker, MapStruct, Lombok, and OpenAPI.

📦 Tech Stack
Java 21

Spring Boot 3.5

PostgreSQL

Docker + Docker Compose

MapStruct

Lombok

OpenAPI (Swagger UI via springdoc-openapi)

🚀 Getting Started
🔧 Prerequisites
Docker Desktop

Java 21

Maven

🐳 Run with Docker Compose
Make sure to build your application JAR first:

bash
Copy
Edit
./mvnw clean package -DskipTests
Then run:

bash
Copy
Edit
docker compose up --build
Swagger UI available at: http://localhost:8080/swagger-ui.html

📑 API Documentation
After running the application, access interactive API docs at:

http://localhost:8080/swagger-ui.html

OpenAPI spec available at:

http://localhost:8080/v3/api-docs

📝 Usage Example
Sample request to fetch all goods:

http
Copy
Edit
GET /api/goods HTTP/1.1
Host: localhost:8080
🎯 CI/CD
A simple GitHub Actions CI pipeline is set up to:

Build the project

Run tests

Optionally build a Docker image

Workflow config: .github/workflows/ci.yml

📃 License
No license — all rights reserved.

📬 Contact
Nikola Torma — GitHub