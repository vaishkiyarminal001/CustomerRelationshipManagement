# indigo-quarter-8668

![Example Image](CRM.png)



**##CRM Application**

The CRM (Customer Relationship Management) application is a Java-based system that allows users to perform various operations related to customer management and issue tracking. It provides functionality for user registration, login, providing feedback, checking issue status, and raising issues. The application uses a MySQL database to store customer information and track their issues.

__Features__
User Registration: Users can register by providing a username and password. The registration data is stored in the MySQL database.

Login: Registered users can log in using their username and password. The application verifies the credentials against the database.

Provide Feedback: Customers can provide feedback on resolved issues. They can view a list of their resolved issues and enter their feedback for each issue.

Check Issue Status: Customers can check the status of their raised issues. The application retrieves the status from the database based on the customer ID.

Raise Issue: Customers can raise new issues by providing a description. The application inserts the issue into the database with an initial status of "Open."

__Database Schema__
The application uses the following database schema:

Table: users

Columns: id (auto-generated), username, password
Table: Customer

Columns: id, name, email
Table: Issue

Columns: id (auto-generated), customerId, description, status, feedback
Table: csr

Columns: id (auto-generated), name, email
The Customer and CSR entities are mapped to their respective database tables using JPA (Java Persistence API) annotations.

__Dependencies__

The application requires the following dependencies:

Java MySQL Connector (JDBC driver) for connecting to the MySQL database.
Jakarta Persistence API (JPA) for object-relational mapping.


**How to Use**
Set up a MySQL database named "CRM" on your local machine. Update the DB_URL, DB_USERNAME, and DB_PASSWORD constants in the App class with your MySQL database connection details.

Compile and run the App class to start the CRM application.

The application will display a menu with options. Enter the corresponding number to perform the desired operation.

Follow the prompts to register, login, provide feedback, check issue status, or raise an issue.

Use the application as needed and exit by selecting option 0 from the menu.