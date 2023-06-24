### Module "Microservices" of Java Global Mentoring Program

This is an example application showcasing a microservices architecture using Spring Cloud, Eureka and Feign client.
The application consists of five services: 
* order
* users
* notification
* eureka
* gateway

The "eureka" service acts as the service registry, and the "gateway" service serves as the API gateway.

### Purpose
The purpose of this application is to demonstrate how microservices can be designed and implemented using Spring Cloud, Eureka, Feign client. It showcases the following features and technologies:

* **Microservices**: The application is divided into separate services, each responsible for a specific domain. This allows for better maintainability, scalability, and flexibility. 
* **Service Discovery**: Eureka is used for service discovery, where each service registers itself with the Eureka server. This enables dynamic service registration and lookup, making it easier to handle service instances and scaling. 
* **API Gateway**: The "gateway" service acts as an API gateway for the application - a centralized entry point for the microservices. It routes incoming requests to the appropriate microservice based on the defined routes and predicates. 
* **Feign Client**: The "order" service utilizes the Feign client with the @FeignClient annotation to communicate with the "notification" service. This enables seamless integration between services and simplifies the communication process.

### Service Description
#### Order Service
Endpoint: /api/order

Description: Handles order-related operations.

Methods

POST /{orderName}:

Creates a new order with the specified name. It also sends a notification using the "notification" service. 

GET /{id}:

Retrieves the order details for the given ID. It fetches user information from the "users" service. 

#### Users Service
Endpoint: /api/users 

Description: Manages user-related operations.


Methods:
GET /: Retrieves the list of all users.

GET /{id}: Retrieves user details for the given ID.

#### Notification Service
Endpoint: /sendNotification

Description: Handles notifications.

Methods:

POST /sendNotification:

Sends a notification with the provided content.

Please note that the "notification" service exposes the POST /sendNotification endpoint in the NotificationController. This endpoint is used by the "order" service to send notifications when a new order is created.
The "order" service makes an HTTP POST request to the /sendNotification endpoint with the order information to send the notification.

#### Gateway Service

Description: Acts as an API gateway for the entire application. 

Functionality: Routes incoming requests to the appropriate microservice based on the defined routes and predicates.

### Running the Application
To run the application, follow these steps:

1. Start the "eureka" service: This will act as the service registry. 
2. Start the "order", "users", "notification" services: These services will register themselves with the Eureka server. 
3. Start the "gateway" service: This will serve as the API gateway and handle incoming requests. 
4. Access the endpoints through the gateway service: Use the defined endpoints to perform operations on the respective services.

### Conclusion
This example demonstrates the benefits of a microservices architecture using Spring Cloud, Eureka and Feign client. It showcases how services can be registered, discovered, and communicated with ease. The API gateway provides a single entry point for the application, allowing for centralized routing and improved security. The use of Feign clients simplifies service integration, making it seamless to communicate between services.

By adopting a microservices architecture, the application gains scalability, flexibility, and maintainability, making it easier to develop and evolve the system over time.
