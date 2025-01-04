# To-Do List Application

## Description
This project is a web-based To-Do List application built with Spring Boot, Thymeleaf, and H2 Database. The application allows users to manage tasks, track completed actions, and maintain a history of all actions performed on tasks.

## Features
- **Task Management**: Add, complete, and delete tasks.
- **Action Logs**: Track all actions performed on tasks, including timestamps.
- **Responsive UI**: User-friendly interface built with Thymeleaf and styled with custom CSS.

## Technologies Used
- **Spring Boot**: For building the backend.
- **Thymeleaf**: For server-side rendering of HTML templates.
- **H2 Database**: In-memory database for testing and development.
- **Maven**: For dependency management.

## Prerequisites
- Java 17 or later.
- Maven 3.8 or later.

## Getting Started

### Clone the Repository
```bash
git clone <repository-url>
cd todolist
```

### Run the Application
1. Build the project using Maven:
   ```bash
   mvn clean install
   ```
2. Start the application:
   ```bash
   mvn spring-boot:run
   ```

3. Access the application at `http://localhost:8080`.

## Project Structure
- **Controller**:
  - `TaskController`: Handles all HTTP requests and interacts with repositories.
- **Model**:
  - `Task`: Represents a task entity.
  - `ActionLog`: Tracks all actions performed on tasks.
- **Repository**:
  - `TaskRepository`: CRUD operations for tasks.
  - `ActionLogRepository`: CRUD operations for action logs.
- **Templates**:
  - `index.html`: The main UI for managing tasks and viewing action logs.
- **Static Resources**:
  - CSS styling for the application.

## Configuration
### Database
The application uses H2 Database for testing and development. Configuration can be found in `application.properties`:
```properties
spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_ON_EXIT=TRUE
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
```

### Logging
Hibernate SQL logging is enabled for debugging purposes:
```properties
logging.level.org.hibernate.sql=DEBUG
```

## Example Usage
1. **Add a Task**:
   - Enter a task description in the input field and click "Add Task".
2. **Complete a Task**:
   - Click the "Complete" button next to the task.
3. **Delete a Task**:
   - Click the "Delete" button next to the task.
4. **View Action Logs**:
   - The action log table displays all actions performed on tasks with timestamps.

## Dependencies
Dependencies are defined in the `pom.xml` file:
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <version>2.2.224</version>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## License
This project is open-source and available under the [MIT License](LICENSE).
