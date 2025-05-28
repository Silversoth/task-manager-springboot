# Aplicación Gestor de Tareas 📝

Una aplicación web sencilla para gestionar tareas, desarrollada con **Spring Boot**, **Thymeleaf** y **MySQL**. Los usuarios pueden crear, visualizar y eliminar tareas a través de una interfaz HTML intuitiva.

---

## ✨ Funcionalidades

- ✅ Crear nuevas tareas  
- 📋 Ver todas las tareas existentes  
- ❌ Eliminar tareas  
- 🌐 Interfaz HTML interactiva con Thymeleaf  
- 🧱 Construida con Spring Boot (arquitectura MVC)  
- 🗃️ Almacena los datos en una base de datos **MySQL**

---

## 📸 Capturas de Pantalla

![Screenshot](./assets/Pic1.png)

---

## 🛠 Tecnologías Utilizadas

- Java 17  
- Spring Boot  
- Spring MVC  
- Thymeleaf  
- MySQL  
- Maven  

---

## ▶ Cómo Ejecutar la Aplicación

### ✅ Requisitos

- Java 17 o superior  
- MySQL funcionando localmente  
- Apache Maven 3.6+  

---

### 🚀 Pasos

1. Clona el repositorio:
```bash
git clone https://github.com/Silversoth/task-manager-springboot.git
cd task-manager-springboot
```
2. Configura conexión a la base de datos
Edita el archivo src/main/resources/application.properties y actualiza los siguientes valores:
```
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```
3. Ejecuta el proyecto
```
mvn spring-boot:run
```
4. Accede a la aplicación en tu navegador
```   
http://localhost:8080/tasks
```
---
## 📂 Estructura del proyecto
```
src/
├── main/
│   ├── java/
│   │   └── com.github.silversoth.task_manager/
│   │       ├── controller/       # TaskController.java
│   │       ├── dao/              # TaskRepository.java (Spring Data JPA)
│   │       ├── entity/           # Task.java (JPA Entity)
│   │       └── TaskManagerApplication.java
│   └── resources/
│       ├── templates/            # Thymeleaf views (index.html)
│       └── application.properties
└── test/

```
---
## 🧪 Testing
Existe una clase básica de testeo:
```
src/test/java/com/github/silversoth/task_manager/TaskManagerApplicationTests.java

```
Puedes ejecutar tests con:
```
mvn test
```

---
## 📄 Licencia

Este proyecto está licenciado bajo el MIT License.
---
## 👤 Autor
Jonathan Hendrix

[GitHub](https://github.com/Silversoth)

[LinkedIn](https://www.linkedin.com/in/jonathan-hendrix-dev/?profileId=ACoAABaHN2MBCx8MlxM46klT3fXvOH9NIHW7b3I)















