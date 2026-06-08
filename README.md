# DnD-Group-Project

## Overview

This repository is designed around allowing users to create and design their own DND characters. The backend allows the user to create a character by selecting all their traits but also allows the creation of users with a login system.

---

## Character Design

To design the character, there are lots of different elements that need to be chosen to fully design the sheet.
For each character, the name, class, height and weight, element and others need to be chosen to fully design it. There are also options for adding a character design. The character is also connected to a user and when a class is picked, it is also connected to a stats sheet that is pregenerated for each class in the game.

---

## Database Layout
The character, classes, stats sheets, element and users are all separated into their own sections, each with their own models, DTOs, controllers, repos and services.
This means that the SQL database can permanently hold the preset classes, stats sheets and elements without having a user need to create their own. This also allows for us to update it in the future to add more classes and elements in the future simply by updating the database.

--
## Class Management API
Each controller has at least 3 different functions

- `GET /api/"character"` → returns all elements within character
- `GET /api/"character"/{id}` → returns a single character with the specified ID
- `POST /api/"character"` → creates a new character

This allows for easy methods to create and grab specific attributes from the database and display them where necessary.

Example request body:
   
{

"name": "Conan"  

"class": "Barbarian",
  
"stats": 9,5,3,6,1,5
  
}

For Local testing:  
application.properties  
spring.datasource.url=jdbc:h2:mem:testdb  
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect