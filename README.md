# Payment System Application README

## Overview

This application is a robust payment system designed to handle transactions securely. It leverages PostgreSQL for database management, integrated via Spring Compose framework. Key features include duplication of user transactions in a local database for redundancy, basic authentication for secure access, and the capability to handle webhooks.

## Features

1. **Payment System Implementation**:
    - Provides comprehensive functionality for processing payments securely.
    - Ensures efficient management of user transactions.

2. **PostgreSQL Integration**:
    - Utilizes PostgreSQL database for data storage and retrieval.
    - Seamlessly interacts with the database through Spring Compose framework.

3. **Local Database Duplication**:
    - Duplicates all user transactions within a local database to ensure data redundancy and backup.

4. **Basic Authentication**:
    - Implements basic authentication to authenticate and authorize users securely.

5. **Webhook Handling (TODO)**:
    - Incorporates functionality to handle webhooks for seamless integration with external services.

6. **Test Coverage Expansion (TODO)**:
    - Enhances test coverage to ensure comprehensive testing of application functionalities.

## Database Access

To access the PostgreSQL database within the Docker container, use the following command:
```
psql -U myuser -d mydatabase
```
## Usage

1. **Clone Repository**: Clone the repository to your local machine.
2. **Build and Run**: Build and run the application using your preferred Java IDE or by running the appropriate Maven commands.
3. **Accessing the Payment System**: Access the payment system through its defined endpoints.
4. **Database Management**: Interact with the PostgreSQL database using the provided command within the Docker container.

