# Hotel
This is a client-server application for the employees of a hotel. The application has two types of users (a regular user represented by the receptionist, and an administrator user) which have to provide a username and a password in order to use the application.
The regular user can perform the following operations:
-Calculate room rates. If a client has reserved a room several times in the past automatically apply a reduction for loyalty.
-Book rooms for clients.
-Cancel room bookings.
-Issue invoices.
The administrator can perform the following operations:
-CRUD operations on user accounts.
-Issue reports in txt format with the clients that have the largest number of reservations.
This project has the following components:
-Repositories: Package that contains the repositories, classes that facilitate the DB access.
-Entities: An entity represents a table from the relational database and each instance of the entity corresponds to a row from the database.
-Services:This layer represents the business logic layer of the Spring application. It translates the Data Transfer Objects (DTOs) into entities and back, also performing more complex operations.
-DTOs: A Data Transfer Object (DTO) is a special object exposed outside the application (to the UI or APIs). It contains only part of the
underlying Entities.
-Controller: The layer that exposes the application functionality as an API able to handle HTTP REST requests.
-Config with the configuration classes:
          -AppConfig: describes the packages that are scanned for annotations during the application.
          -PersistenceConfig: configures the beans which are responsible for the communication with the database.
          -WebMvcConfig: together with the associated annotations enables Spring MVC.
