# Biblioteca Proyecto
Este proyecto es una aplicación web para administrar una biblioteca. Permite realizar operaciones como la gestión de libros, autores y editoriales, así como prestar y devolver libros.

# Tecnologías Utilizadas
Java
Spring Boot
Spring Data JPA
MySQL

# Configuración
Base de Datos: Configura la base de datos MySQL en application.properties proporcionando la URL, el nombre de usuario y la contraseña.
Crear una base de datos con el nombre "biblioteca"

# properties
spring.datasource.url=jdbc:mysql://localhost:3306/biblioteca
spring.datasource.username=root
spring.datasource.password=1234
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
#spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
