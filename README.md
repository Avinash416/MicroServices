# MicroService

A complete microservices architecture built using Spring Boot, Spring Cloud, Eureka, Config Server, and API Gateway, using Gradle for build and dependency management. This system demonstrates modular microservices communicating securely with centralized configuration and service discovery.



📁 Project Structure
```
MicroServices/
├── ApiGateway/           # Entry point for all services (Spring Cloud Gateway)
├── HotelService/         # Microservice for hotel-related operations
├── RatingService/        # Microservice for user ratings
├── ServerConfiguration/  # Spring Cloud Config Server
├── ServiceRegistry/      # Eureka service discovery server
├── UserService/          # Manages user operations and integrates with other services
└── README.md             # Project documentation
```


</br>

🛠️ Tech Stack

- Java 21
- Spring Boot 3.xx
- Spring Cloud (Eureka, Config, Gateway)
- Spring Security
- MongoDB
- MySql
- Postgres
- Gradle


</br>

⚙️ Services Overview

| Service          | Port | Description                                 |
| ---------------- | ---- | ------------------------------------------- |
| Service Registry | 8761 | Eureka server for service discovery         |
| Config Server    | 8085 | Central config management for microservices |
| API Gateway      | 8084 | Routes client requests to services          |
| User Service     | 8081 | Manages users and their interactions        |
| Hotel Service    | 8082 | Manages hotel data                          |
| Rating Service   | 8083 | Handles ratings between users and hotels    |

</br>

🧪 Run Instructions (via Gradle)

Run each service independently using:
```
./gradlew bootRun
```

Example:

```
  cd ServiceRegistry
./gradlew bootRun
```

</br>

Start services in the following order:

- ServiceRegistry
- ServerConfiguration
- ApiGateway
- UserService
- HotelService
- RatingService


</br>

🔐 Environment Configuration

Use environment variables for sensitive data (e.g., OKTA credentials).

Option 1: IDE Setup
In IntelliJ or Eclipse:
Go to Run > Edit Configurations
Add environment variables in the Environment variables field:
```
OKTA_ISSUER_URI=https://your-okta/oauth2/default
OKTA_CLIENT_ID=your-client-id
OKTA_CLIENT_SECRET=your-client-secret
```

</br>

Option 2: .env File (For Local Development)

Create a .env file in the root or each service folder:

env
```
OKTA_ISSUER_URI=https://your-okta-domain/oauth2/default
OKTA_CLIENT_ID=your-client-id
OKTA_CLIENT_SECRET=your-client-secret
```

Use a Gradle plugin like env file to automatically read it, or configure your shell to export them before running:
```
source .env

```


</br>

🌐 Endpoints

Use API Gateway as the unified entry point:
```
GET http://localhost:8084/users
GET http://localhost:8084/hotels
GET http://localhost:8084/ratings
```


