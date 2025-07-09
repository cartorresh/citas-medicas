▶️ Sistema de Citas Médicas

Este es un sistema web desarrollado con Spring Boot que permite gestionar citas médicas entre pacientes y médicos. 

▶️ Funcionalidades

- Registrar médicos y pacientes
- Crear y listar citas médicas
- Visualización y consumo de endpoints con Swagger

▶️ Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database (modo en memoria)
- Swagger (documentación de API)
- Maven

▶️ Ejecución del proyecto

1. Clona el repositorio:
 
   git clone https://github.com/tu_usuario/citasmedicas.git
   cd citasmedicas

2. Ejecuta el proyecto con Maven:
   
   mvn spring-boot:run

3. Accede a Swagger en:
   
   http://localhost:8080/swagger-ui/index.html

▶️ Endpoints principales

- /api/medicos - Gestión de médicos
- /api/pacientes - Gestión de pacientes
- /api/citas - Gestión de citas médicas

▶️ Base de datos

Este sistema usa H2 en memoria, por lo tanto los datos se eliminan al cerrar la aplicación. 

Puedes verlos en:
http://localhost:8080/h2-console

- JDBC URL: `jdbc:h2:mem:citasdb`
- Usuario: `sa`
- Contraseña: *(vacía)*

▶️  Autores
GRUPO #2
- VICTOR LATORRE
- ADRIAN GILCES
- CARLOS TORRES
- GEAN TAPIA
