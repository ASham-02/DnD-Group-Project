# DnD-Group-Project


### Class Management API

- `GET /api/characterClass` → returns all classes
- `GET /api/characterClass/{id}` → returns a single class
- `POST /api/characterClass` → creates a new class

Example request body:
   
{
  
"name": "Warrior",
  
"statsId": 1
  
}

For Local testing:  
application.properties  
spring.datasource.url=jdbc:h2:mem:testdb  
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect