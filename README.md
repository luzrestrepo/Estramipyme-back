<p align="right">
  <img src="https://visitor-badge.laobi.icu/badge?page_id=estramipyme.backend" />
</p>

<p align="center">
  <img src="https://user-images.githubusercontent.com/74038190/240906093-9be4d344-6782-461a-b5a6-32a07bf7b34e.gif">
</p>

<div align="center">
  <h1>📘 EstramiPyme Backend Project</h1>
  <p>
    A backend platform to digitize strategic business tools inspired by Universidad EAFIT's MBA book.<br>
    🚀 Designed to empower businesses nationally and internationally.
  </p>
</div>

---

## 📋 MVP Guide for EstramiPyme Backend Project

### 1️⃣ Project Context
EstramiPyme is a platform inspired by a book developed by the MBA program at **Universidad EAFIT**. The project aims to digitize historical business strategies, making them accessible in modern environments.  

---

### 2️⃣ MVP Scope and Requirements

#### **Core Features**
1. **Authentication and Authorization (future developments):**
   - User registration and login.
   - Secure session management using **JWT**.
   - Role-based access: Administrators, Students, and Teachers.

2. **Data Management:**
   - CRUD operations for entities like:
     - `/activities`  
     - `/admins`  
     - `/alerts`  
     - `/answers`  
     - `/companies`  
     - `/graphs`  
     - `/questions`  
     - `/students`  
     - `/teachers`  
     - `/tests`

3. **API for Frontend Integration:**
   - RESTful endpoints for seamless backend-frontend communication.

#### **Technical Requirements**
- **Database:** MySQL for critical entities.
- **REST API:** Full CRUD implementation.
- **Validation:** Strict rules to ensure data integrity.

---

### 🖥️ Frontend Architecture

#### **Repository:** EstramiPyme Frontend  
- **Technologies Used:**
  - Language: **TypeScript (Angular)**
  - Styling: **Tailwind CSS**
- **Key Features:**
  - User registration and login.
  - Admin dashboard to manage users, view tests, and graphs.

---

### ⚙️ Backend Architecture

#### **Technologies Used:**

## 🚀 Tecnologías Principales  

<div align="center">

  <table>
    <tr>
      <td align="center">
        <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" alt="Java" width="60" height="60">
        <br />
        <strong>Java 17</strong>
        <br />
        <span>Lenguaje de programación principal</span>
      </td>
      <td align="center">
        <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original-wordmark.svg" alt="Spring Boot" width="60" height="60">
        <br />
        <strong>Spring Boot 3.3.4</strong>
        <br />
        <span>Framework para la creación de aplicaciones Java</span>
      </td>
      <td align="center">
        <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original-wordmark.svg" alt="MySQL" width="60" height="60">
        <br />
        <strong>MySQL</strong>
        <br />
        <span>Base de datos relacional</span>
      </td>
    </tr>
    <tr>
      <td align="center">
        <img src="https://www.vectorlogo.zone/logos/hibernate/hibernate-icon.svg" alt="Hibernate" width="60" height="60">
        <br />
        <strong>Hibernate ORM</strong>
        <br />
        <span>Gestión de entidades y acceso a la base de datos</span>
      </td>
      <td align="center">
        <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/jsonwebtokens/jsonwebtokens-plain.svg" alt="JWT" width="60" height="60">
        <br />
        <strong>JWT</strong>
        <br />
        <span>Autenticación y autorización de usuarios</span>
      </td>
    </tr>
  </table>

</div>

#### **Structure:**
- Controllers: Handle HTTP requests.
- Services: Contain business logic.
- Repositories: Manage database access.
- DTOs: Structure data exchange between layers.

---

### 🌐 Endpoints Overview

#### Supported HTTP Methods:
- **GET**: Retrieve information.
- **POST**: Create new records.
- **PUT**: Update existing records.
- **DELETE**: Delete records.

#### **Main Endpoints:**
- `/activities`: Manage business activities.
- `/admins`: Handle system administrators.
- `/alerts`: Record important alerts.
- `/answers`: Manage answers to system questions.
- `/auth`: Handle user registration and login.
- `/companies`: Manage registered companies.
- `/graphs`: Generate and query business graphs.
- `/questions`: Configure and edit system questions.
- `/students`: Manage enrolled students.
- `/teachers`: Administer associated teachers.
- `/tests`: Manage assessments and evaluations.

---

### 👥 Project Collaborators

#### **Current Team:**
- **Project Owner:** MBA EAFIT Team - Strategic goal definition.
- **Mentor:** David Arias Fuentes
- **Backend Developers:**
  - [Luz Restrepo](#)
  - [Judy Alexandra Cuartas Osorio](#)
  - [Didian Alejandro Valencia](#)
  - [Sebastian Perez Jimenez](#)
  - [Simon Diaz David](#)

#### **Open Roles:**
- **QA Tester:** Validate API and endpoints using Postman.
- **UX/UI Designer:** Enhance platform interface experience.
- **Data Analyst:** Optimize graphs and visualizations.

#### **Project Timeline:**
- **Management Tool:** JIRA
- **Duration:** October 7, 2024 – November 19, 2024

---

### 🔒 System Security (Future Developments)
- **Secure Authentication:** JWT for session management.
- **Data Protection:** Password encryption with bcrypt.
- **API Security:**
  - Configured CORS policies.
  - Strict input validation.
  - SQL injection prevention using prepared statements.

---

### 🚀 Optimization and Feedback
- **Feedback Collection:** Surveys for user and admin feedback.
- **Continuous Improvements:**
  - Database indexing for faster queries.
  - Reducing API response times.

---

<div align="center">
  <h2>⚒️ Technologies ⚒️</h2>
  <img src="https://skillicons.dev/icons?i=java,spring,mysql,maven,angular,tailwind, />
</div>

---

<div align="center">
  <h3>
    <img src="https://readme-typing-svg.herokuapp.com/?font=Righteous&size=25&center=true&vCenter=true&width=500&height=70&duration=4000&lines=Thanks+for+visiting!+✌️;+Let's+build+something+great+together!">
  </h3>
</div>

<div>
# 📂 Estructura de Carpetas de EstramiPyme Backend

```plaintext
EstramiPyme-Backend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── estramipyme/
│   │   │           ├── controller/         # Controladores HTTP
│   │   │           ├── service/            # Lógica de negocio
│   │   │           ├── repository/         # Acceso a la base de datos
│   │   │           ├── model/              # Clases de entidades
│   │   │           ├── dto/                # Data Transfer Objects
│   │   │           └── configuration/      # Configuraciones del proyecto
│   │   └── resources/
│   │       ├── static/                     # Archivos estáticos (si aplica)
│   │       ├── templates/                  # Plantillas (si aplica)
│   │       └── application.properties      # Configuración de Spring Boot
│   └── test/
│       └── java/
│           └── com/
│               └── estramipyme/
│                   └── test/               # Clases de pruebas unitarias
├── target/                                 # Archivos generados por Maven
├── .gitignore                              # Archivos y carpetas ignoradas por Git
├── pom.xml                                 # Archivo de configuración de Maven
└── README.md                               # Documentación del proyecto

</div>
