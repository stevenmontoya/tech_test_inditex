# Technical Test Inditex

The Hexagonal Java Spring Boot application! This application is designed to demonstrate the use of the hexagonal architecture in a Java Spring Boot application.

The hexagonal architecture is a software design pattern that helps to isolate the core business logic of an application from external interfaces such as the UI, database, and external APIs. This allows the core to be tested in isolation and makes the application more flexible and easier to maintain.

The application is divided into three main modules: the domain module, the infrastructure module, and the application module.

# Domain Module
The domain module contains the core business logic of the application. It is completely independent of any external interfaces and can be tested in isolation. The domain module typically includes domain objects (e.g. entities, value objects), domain services, and domain repositories.

# Infrastructure Module
The infrastructure module contains the external interfaces of the application. It includes components such as the UI, database, and external APIs. The infrastructure module communicates with the domain module through ports and adapters. The ports define the interface between the domain and infrastructure modules, and the adapters implement the interface.

# Application Module
The application module coordinates the flow of information between the domain and infrastructure modules. It typically includes use cases (also known as interactors) and controllers. The use cases contain the business logic for specific actions, and the controllers handle incoming requests and invoke the appropriate use case.

By following the hexagonal architecture, the core business logic of the application is isolated from external interfaces, allowing for better testability and maintainability. It also makes it easier to change or add new external interfaces without affecting the core business logic.

# Commands to run APP

### Build
``
 mvn clean install
``
### Run
``
mvn -pl main spring-boot:run
``