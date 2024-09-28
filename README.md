Employee Management System
A simple Employee Management System built with Spring Boot for backend REST APIs, Angular for the frontend, and MySQL for the database.

Features
Add, update, delete, and view employee details
Full CRUD operations for employees
Cross-origin request handling for Angular
Technologies Used
Backend: Spring Boot, Spring Data JPA
Frontend: Angular (http://localhost:4200)
Database: MySQL
Tools: Maven, Eclipse/VS Code
Setup Instructions
Clone the repository:

bash
git clone https://github.com/your-username/employee-management-system.git
Backend Setup:

Update application.properties with your MySQL credentials.
Run the Spring Boot application:
bash
mvn spring-boot:run

Frontend Setup:
Set up Angular frontend and start it:
bash
ng serve

Database Setup:
Create a MySQL database named employee_management_system.
The database schema will automatically update on application startup.
API Endpoints
GET /employees: Fetch all employees
GET /employees/{id}: Fetch employee by ID
POST /employees: Add a new employee
PUT /employees/{id}: Update employee by ID
DELETE /employees/{id}: Delete employee by ID
