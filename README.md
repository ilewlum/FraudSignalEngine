# Fraud Signal Engine

A Spring Boot application that evaluates financial transactions for fraudulent activity using a rule-based fraud detection system.

## Overview

The Fraud Signal Engine is designed for small and medium businesses to detect potentially fraudulent transactions in real-time. It implements a pluggable rule-based architecture that allows for easy addition of new fraud detection rules.

## Features

- **Rule-Based Fraud Detection**: Extensible rule system for evaluating transactions
- **Geolocation Analysis**: Detects transactions from new or unusual locations
- **User Management**: Admin interface for managing users and their authentication
- **Transaction Tracking**: Complete transaction history with fraud evaluation results
- **Security**: Spring Security integration with role-based access control (ADMIN, SERVICE)
- **PostgreSQL Database**: Persistent storage of users, transactions, and evaluation results

## Technology Stack

- **Framework**: Spring Boot 4.0.1
- **Language**: Java 21
- **Database**: PostgreSQL
- **Build Tool**: Maven
- **Security**: Spring Security with BCrypt password encoding
- **ORM**: JPA/Hibernate

## Project Structure
```
src/
├── main/java/com/MulweliCoding/FraudSignalEngine/
│   ├── Config/       # Security and initialization configuration
│   ├── Controller/   # REST API endpoints
│   ├── Model/        # JPA entities
│   ├── Repository/   # Data access layer
│   ├── Rules/        # Fraud detection rules
│   ├── Services/     # Business logic
│   └── Scoring/      # Scoring utilities
└── test/             # Unit tests
```

## API Endpoints

### User Management
- `GET /api/v1/users/all` - Get all users (requires ADMIN role)
- `GET /api/v1/users/{id}` - Get user by ID
- `POST /api/v1/users/` - Create new user
- `PUT /api/v1/users/{id}` - Update user
- `DELETE /api/v1/users/{id}` - Delete user

### Fraud Engine
- `POST /api/v1/fraud-engine/evaluate` - Evaluate a transaction for fraud (requires SERVICE role)

## Configuration

### Database Connection
Update `src/main/resources/application.properties`:

```
spring.datasource.url=jdbc:postgresql://your-host:5432/your-database
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update
server.port=9090
```

Note: Never commit credentials to version control. The application.properties file should be in .gitignore.

### Default Users
The application initializes two default users on startup:

#### Admin User

- `Email`: admin@fraud.local
- `Password`: Admin1234
- `Role`: ADMIN
          
#### Service User

Email: service@fraud.local
Password: service1234
Role: SERVICE

Building and Running
Build

``` 
./mvnw clean install
```
Run
``` 
./mvnw spring-boot:run
```
The application will start on http://localhost:9090

### Fraud Rules
### GeoLocation Rule
Evaluates transactions based on geographical location:
- `Triggered:` When transaction occurs from a new location
- `Risk Score: 0` if location matches previous transactions
- `Risk Score: 20` if location is new or unusual


## Models
### User
Represents a system user with basic information.

### Transaction
Represents a financial transaction with:

- User ID
- Amount
- Timestamp
- Location

### EvaluateResponse
Contains fraud evaluation results:

- Fraud score (aggregated from all rules)
- List of triggered rules
- Boolean flag indicating if transaction is flagged as fraud
- Fraud threshold: Score ≥ 50

### UserAuthentication
Manages user credentials and roles (ADMIN, SERVICE, USER)

## Authentication
The application uses HTTP Basic Authentication with Spring Security:

All endpoints require authentication
- `/api/v1/users` endpoints require `ADMIN` role
- `/api/v1/fraud-engine` endpoints require `SERVICE` role

## Development
Running Tests:
```
./mvnw test
```
Adding New Fraud Rules:
- Create a new class implementing RuleInterface
- Implement the evaluate() method with your fraud logic
- Annotate with @Component for Spring auto-wiring
- The rule will automatically be picked up by FraudEngineService

Example:
```
@Component
public class MyFraudRule implements RuleInterface {
    @Override
    public EvaluateResponse evaluate(Transaction transaction) {
        // Your fraud detection logic here
        return new EvaluateResponse();
    }
}
```
## Dependencies
- Spring Boot Starters: Web, Data JPA, Security
- PostgreSQL Driver
- Lombok

`See pom.xml for complete dependency list.`
