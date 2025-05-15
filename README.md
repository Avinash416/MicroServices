# MicroServices

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
Add environment variables in the Environment variables field for each service:
```
USERSERVICE_DB_URL=something url
USERSERVICE_DB_USERNAME=abcd
USERSERVICE_DB_PASSWORD=something
```

</br>

Option 2: .env File (For Local Development)

Create a .env file in the root or each service folder:

env
```
USERSERVICE_DB_URL=something url
USERSERVICE_DB_USERNAME=abcd
USERSERVICE_DB_PASSWORD=something
```

Use a Gradle plugin like env file to automatically read it, or configure your shell to export them before running:
```
source .env
```

</br>

🔐 Security and Authentication

- This project uses OAuth2 authentication via Okta to secure service endpoints.
- Okta Integration: Configured using Spring Security's OAuth2 client support.
- Environment Variables: Authentication details like OKTA_ISSUER_URI and OKTA_CLIENT_ID are provided via environment variables.
- Protected Routes: Microservices endpoints are secured and require valid OAuth2 tokens.

⚠️ Make sure you set the required environment variables before running the services.

```
OKTA_ISSUER_URI=https://dev-xxxxxx.okta.com/oauth2/default
OKTA_CLIENT_ID=your-okta-client-id
OKTA_CLIENT_SECRET=your-okta-client-secret
```

🌐 Endpoints

Use API Gateway as the unified entry point:
```
GET http://localhost:8084/users
GET http://localhost:8084/hotels
GET http://localhost:8084/ratings
```
