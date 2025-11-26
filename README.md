# redis-demo

A simple demo project built with **Spring Boot**, using **PostgreSQL** and **Redis** running inside Docker containers.  
The project demonstrates basic CRUD operations on a `Book` entity and caching with Redis.

---
 
## 🧱 Project Architecture

The application consists of three main components:

- **Spring Boot application** — runs on port `8080`
- **demo-postgres** — PostgreSQL database container
- **demo-redis** — Redis cache container

All services run inside the `demo-network` Docker network.

---

## 🚀 How to Run the Project

### 1. Clone the repository

```bash
git clone https://github.com/maksimtest/redis-demo.git
```

## 🚀 Run Docker containers
```
docker compose up -d
```

This starts:

PostgreSQL on localhost:5433

Redis on localhost:6379

Spring Boot app on localhost:8080 (when you start it)

---
## 🚀 Running the Spring Boot Application
⚠️ Important for Windows Users

To avoid timezone issues with PostgreSQL, add this JVM option:
```
-Duser.timezone=Europe/Kyiv
```
Example (IntelliJ IDEA)

Run > Edit Configurations > VM Options:

-Duser.timezone=Europe/Kyiv

Example (command line)
java -Duser.timezone=Europe/Kyiv -jar redis-demo.jar

---
## 🚀 Available Endpoints
1. Initialize database with sample data
GET http://localhost:8080/init

2. Get list of all Book entities
GET http://localhost:8080/book

3. Create a new Book
POST http://localhost:8080/book
Content-Type: application/json
{
  "title": "Sample Book",
  "author": "John Doe"
}

---
## 🧰 Redis CLI Usage
Enter Redis CLI inside the container
```
docker exec -it demo-redis redis-cli
```
---
## 🔧 Useful Redis Commands
Get all keys related to books
```
keys book::*
```
Get value by key
```
get <key>
```
Remove all data from Redis
```
flushall
```

⚠️ Warning: flushall deletes all keys in all databases.
---
✔️ Summary

This project demonstrates how to:
- Use Redis as a cache in Spring Boot
- Run PostgresSQL and Redis inside Docker
- Create and read Book entities
- Manage Redis keys from the command line
