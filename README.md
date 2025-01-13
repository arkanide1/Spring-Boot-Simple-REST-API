# Spring-Boot-Simple-REST-API
Spring WEB, POSTGRESQL, Spring DATA JPA

## Steps to Setup

### 1. Clone the Application

```bash
git clone https://github.com/arkanide1/Spring-Boot-Simple-REST-API
```
### 2. Create PostgreSQL Database
```
CREATE DATABASE student;
```
### 3. Configure PostgreSQL Username and Password

```
spring.datasource.url=jdbc:postgresql://localhost:5432/student
spring.datasource.username=your_postgres_username
spring.datasource.password=your_postgres_password
```

### 4. Run the Application
```
mvn spring-boot:run
```
The application will start running at:

http://localhost:8080


