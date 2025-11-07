Solution Empresa - Grupo 09
Proyecto de Desarrollo de Componentes del Negocio
4° Ciclo - IDAT

Descripción
Esta aplicación implementa una API RESTful para la gestión de información empresarial.
Se desarrolló con Spring Boot, siguiendo buenas prácticas de arquitectura por capas (Controller → Service → Repository → DTO → Model) **.

Tecnologías
Tecnología	Versión / Uso
Java	21
Spring Boot	3.5.7
Maven	3.x
Swagger / Springdoc	2.1.0
JUnit 5 / Mockito	Pruebas unitarias
📂 Estructura del Proyecto
app-SolutionEmpresa/ ├─ src/ │ └─ main/ │ ├─ java/pe/idat/backend/solutionEmpresa/app_SolutionEmpresa/ │ │ ├─ controller/ → Endpoints REST │ │ ├─ dto/ → Objetos de transferencia de datos │ │ ├─ model/ → Entidades del negocio │ │ ├─ repository/ → Repositorios de datos │ │ ├─ service/ → Lógica de negocio │ │ └─ AppSolutionEmpresaApplication.java → Clase principal │ └─ resources/ │ └─ application.properties ├─ HELP.md ├─ pom.xml └─ README.md
