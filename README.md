# Spring Security Login Server

This is a Spring Security login server developed using Java Spring and Spring Security

## Getting Started

To get started with this project, follow these steps:

1. Clone this repository.
2. Open the project in your preferred IDE.
3. Set up a local database (e.g. Postgres).
    - Create a new database.
    - Update the `application.yml` file with your database credentials.
4. Run the project.
5. (Optional) Set up a local mail server (e.g. maildev) to test email functionality.

## Usage

The following endpoints are available:

### Register

Registers a new user.

- **URL**

  `/api/v1/registration`

- **Method:**

  `POST`

- **Request Body**
```
{
 “firstName”: “string”,
 “lastName”: “string”,
 “password”: “string”,
 “email”: “string”
}
```

**Success Response:**

- **Code:** 200 OK<br />
  **Content:** `<TOKEN>`

### Confirm

Confirms a user's registration.

- **URL**

`/api/v1/registration/confirm?token=<token>`

- **Method:**

`GET`

- **URL Params**

**Required:**

`token=[string]`

**Success Response:**

- **Code:** 200 OK<br />
  **Content:** `{ "message": "confirmed" }`
