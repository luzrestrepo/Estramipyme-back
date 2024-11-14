## 🚀 **MVP Guide for the Backend Project**

### 1. **Define the MVP Scope and Requirements**

- **Core Features**:

  - CRUD operations for managing data such as activities, administrators, professors, students, and companies.
  - Tests for measuring company status.
  - Data visualizations for monitoring registered companies and completed tests.
  - **User Registration and Login**:

    - Endpoints for user registration and login authentication.

  - **Technical Requirements**:
    - **Database**: Structure to store essential data for each CRUD.
    - **REST API**: Implement HTTP methods (GET, POST, PUT, DELETE).
    - **Data Validation**: Basic validation to ensure secure data handling.

---

### 2. **Design the Backend Architecture**

- **Language and Framework**:
  - **Java + Spring Boot** for reliable backend performance.
- **Route and Controller Management**:
  - Modular routes organized by functionalities.

---

### 3. **Configure the Database with Aiven**

- **Database**:
  - Using **MySQL**.
  - Database configuration in `src/main/resources/application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://your-database-url
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    spring.jpa.hibernate.ddl-auto=update
    ```
- **Migrations and Seed Data**:
  - Scripts for database migrations and initial setup data.

---

### 4. **Create REST API Endpoints**

- **CRUD Operations**:
  - Endpoints for each resource:
    - `/activities`
    - `/admins`
    - `/teachers`
    - `/students`
    - `/companies`
    - `/alerts`
    - `/answers`
    - `/graphs`
    - `/tests`
  - **Data Validation**:
    - Validate input for each endpoint to ensure data integrity.

---

### 5. **Authentication and Security**

- **JWT Authentication**:
  - Use **JSON Web Tokens (JWT)** to authenticate users in the system.
  - Tokens should be generated at login and verified on each protected request.
- **Role-Based Access**:
  - Implement access control for specific endpoints based on user roles.
- **Security Validation**:
  - Validate and protect input data against common attacks.

---

### 6. **Data Visualization and Testing**

- **Company Status Testing**:
  - API for tracking the operational status of companies.
- **Graph Controls**:
  - Endpoints for visualizing registered companies and completed tests.

---

## 🛠 **Technologies Used**

## Backend Stack 🚀

- ![Java](https://img.icons8.com/color/48/000000/java-coffee-cup-logo--v1.png) **Java**
- ![Spring Boot](https://img.icons8.com/color/48/000000/spring-logo.png) **Spring Boot**
- ![Maven](https://img.icons8.com/color/48/000000/apache-maven.png) **Maven**
- ![SQL](https://img.icons8.com/ios-filled/50/000000/database.png) **SQL** (using Aiven)
- ![Aiven](https://aiven.io/_next/static/media/logo.aee7ea12.svg) **Aiven**
- ![JWT](https://img.icons8.com/color/48/000000/json-web-token.png) **JWT**
- ![Cloudinary](https://res.cloudinary.com/demo/image/upload/q_auto,f_auto,fl_lossy,dpr_2.0,w_48/cloudinary_icon.png) **Cloudinary** for image management
