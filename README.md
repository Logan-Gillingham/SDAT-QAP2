# Golf Club Tournament and Membership API

This project is a Spring Boot REST API for managing golf club members and tournaments. It provides endpoints for adding, retrieving, and searching members and tournaments, as well as managing member participation in tournaments.

## Supported Search APIs

### Members

* **Search by Name:**
    * Endpoint: `GET /members/search?name={name}`
    * Description: Retrieves members whose names contain the specified string (case-insensitive).
    * Example: `GET /members/search?name=John`
* **Search by Phone Number:**
    * Endpoint: `GET /members/search?phone={phone}`
    * Description: Retrieves members with the exact specified phone number.
    * Example: `GET /members/search?phone=123-456-7890`
* **Search by Membership Start Date:**
    * Endpoint: `GET /members/search?startDate={startDate}`
    * Description: Retrieves members whose membership started on the specified date (YYYY-MM-DD).
    * Example: `GET /members/search?startDate=2024-01-01`

### Tournaments

* **Search by Start Date:**
    * Endpoint: `GET /tournaments/search?startDate={startDate}`
    * Description: Retrieves tournaments that start on the specified date (YYYY-MM-DD).
    * Example: `GET /tournaments/search?startDate=2024-07-01`
* **Search by Location:**
    * Endpoint: `GET /tournaments/search?location={location}`
    * Description: Retrieves tournaments whose location contains the specified string (case-insensitive).
    * Example: `GET /tournaments/search?location=Pebble`

### Get Members in Tournament

* **Get Members in Tournament:**
    * Endpoint: `GET /tournaments/{tournamentId}/members`
    * Description: Retrieves all members that are signed up for the tournament.
    * Example: `GET /tournaments/1/members`

## Running the Project with Docker

This project includes Docker support, allowing for easy setup and deployment.

### Prerequisites

* Docker and Docker Compose installed on your machine.

### Steps

1.  **Clone the Repository:**

    ```bash
    git clone [YOUR_REPOSITORY_URL]
    cd [YOUR_REPOSITORY_DIRECTORY]
    ```

2.  **Build the Application:**

    ```bash
    mvn clean install  # For Maven
    # OR
    gradle build      # For Gradle
    ```

3.  **Run Docker Compose:**

    ```bash
    docker-compose up --build
    ```

    This command will:

    * Build the Docker image for the Spring Boot application.
    * Start the MySQL database container.
    * Start the Spring Boot application container, linking it to the database.

4.  **Access the API:**

    * The API will be accessible at `http://localhost:8080`.
    * Use Postman or any other HTTP client to interact with the API endpoints.

5.  **Stop the Containers:**

    ```bash
    docker-compose down
    ```

### Environment Variables

The following environment variables are used in the `docker-compose.yml` file:

* `SPRING_DATASOURCE_URL`: The JDBC URL for the MySQL database.
* `SPRING_DATASOURCE_USERNAME`: The username for the MySQL database.
* `SPRING_DATASOURCE_PASSWORD`: The password for the MySQL database.

You can customize these variables in the `docker-compose.yml` file as needed.
