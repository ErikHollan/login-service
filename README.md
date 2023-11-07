# Spring Security Login Server

This is a Spring Security login server developed using Java Spring and Spring Security.

## Getting Started

To get started with this project, follow these steps:

1. Clone this repository.
2. Open the project in your preferred IDE.
3. Set up local database (Eg. Postgres)
4. Run the project.
   
(Optional) Set up a local mail server (Eg. maildev)

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
"firstName" : "String",
"lastName" : "String",
"password" : "String",
"email" : "String"
}
```
 **Success Response:**

- **Code:** 200 OK<br />
  **Content:**
  <br />`{TOKEN}`
  
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
  **Content:** `{ "message": "User confirmed successfully." }`


