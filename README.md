🚖 TripEase – Cab Booking Backend

<img width="1440" height="900" alt="Screenshot 2026-01-06 at 6 51 40 PM" src="https://github.com/user-attachments/assets/633ea875-1610-401b-b1a6-bc143799e966" />

TripEase is a cab booking management system backend built using Spring Boot.
It is a simplified version of platforms like Uber/Ola, focusing on core backend logic such as customer registration, cab allocation, booking lifecycle, and fare calculation.

🛠 Tech Stack
- Java 21  
- Spring Boot 3.x  
- Spring Data JPA (Hibernate)  
- MySQL  
- Maven  
- Spring Mail (Email Notifications)  
- Swagger / OpenAPI  
- Lombok  

---

📐 Architecture
The project follows a **Layered Architecture**:

Controller → Service → Repository → Database  
DTO ↔ Entity conversion using Transformers
            
### Layers
- Controller: Handles REST APIs  
- Service: Business logic  
- Repository: Database operations (JPA)  
- DTOs: Request & Response models  
- Transformer: Entity ↔ DTO conversion  
- Exception: Custom exception handling  

---

🧩 Core Modules
- Customer Management  
- Driver Management  
- Cab Management  
- Booking Management  
- Email Notification System  

---

📊Database Design

### Entities
- Customer  
- Driver  
- Cab  
- Booking  

### Relationships
- Customer → One-to-Many → Booking  
- Driver → One-to-One → Cab  
- Cab → One-to-Many → Booking  
- Booking → Many-to-One → Customer & Cab  

---

✨ Key Features
- Register customers and drivers  
- Register a cab for a driver  
- Book a cab with:
  - Automatic cab allocation  
  - Fare calculation (distance × per-km rate)  
  - Cab availability management  
- Prevents double booking  
- Cancel booking and free cab  
- Email confirmation on booking  
- Clean DTO-based API responses  
- Custom exception handling  

---

🔁 Booking Flow (High Level)

1. Customer requests booking  
2. System finds a random available cab  
3. Fare is calculated automatically  
4. Cab is marked unavailable  
5. Booking is saved  
6. Confirmation email is sent  

---

📮 API Endpoints (Sample)
### Customer
- `POST /customer/add`  
- `GET /customer/get/customer-id/{id}`  

### Driver
- `POST /driver/add`  

### Cab
- `POST /cab/register/driver/{driverId}`  

### Booking
- `POST /booking/book/customer/{customerId}`  
- `DELETE /booking/delete/{bookingId}` 

⚠️ Exception Handling
Custom exceptions like:
CustomerNotFoundException
DriverNotFoundException
CabNotFoundException
BookingNotFoundException

🧪 Testing
Basic Spring Boot test setup included
Scope for adding:
Unit tests (JUnit, Mockito)
Integration tests

🔐 Configuration
Sensitive data (DB credentials, email config) should be placed in:
application.properties
⚠️ This file is intentionally gitignored for security.

🚀 How to Run Locally
git clone git@github.com:Vedangmodi/TripEase.git
cd tripease
mvn spring-boot:run

🔮 Future Improvements
Spring Security (JWT Authentication)
Role-based access (Admin / Customer / Driver)
Payment gateway integration
Ride completion & ratings
Global exception handler (@ControllerAdvice)
Redis caching
Docker & cloud deployment
Microservices split

📌 Learning Outcomes
REST API design
Spring Boot best practices
JPA relationships
DTO & Transformer pattern
Real-world backend workflows
Clean code & layered architecture

👨‍💻 Author
Vedang Modi
Backend Developer | Java | Spring Boot
🔗 GitHub: Vedangmodi
