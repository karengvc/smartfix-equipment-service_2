# SmartFix Equipment Service

Microservicio de gestión de equipos desarrollado para el proyecto SmartFix.

## Tecnologías

- Java 25
- Spring Boot 4.1.1
- Maven
- Spring Data JPA
- MySQL
- Jakarta Validation
- Docker

## Funcionalidad

Permite registrar, consultar, actualizar y eliminar equipos mediante una API REST.

## Requisitos

- Java 25
- MySQL instalado y en ejecución
- Maven, o utilizar el Maven Wrapper incluido en el proyecto

## Configuración de la base de datos

Crear la base de datos en MySQL:

```sql
CREATE DATABASE smartfix_equipment;
```

Configurar las variables de entorno antes de ejecutar la aplicación:

- `DB_USERNAME`: usuario de MySQL.
- `DB_PASSWORD`: contraseña de MySQL.

La aplicación utiliza estas variables para conectarse a la base de datos.

## Ejecutar el proyecto

Desde la carpeta raíz, ejecutar:

```bash
mvnw.cmd clean package
```

En Windows, también puedes utilizar el Maven Wrapper desde PowerShell:

```powershell
.\mvnw.cmd clean package
```

Después de generar el archivo JAR, ejecutar:

```powershell
java -jar target/smartfix-equipment-service-2-0.0.1-SNAPSHOT.jar
```

La API estará disponible en:

`http://localhost:8080`

## Endpoints REST

| Método | Endpoint | Descripción |
|---|---|---|
| GET | `/api/equipos` | Listar todos los equipos |
| GET | `/api/equipos/{id}` | Consultar un equipo por ID |
| POST | `/api/equipos` | Registrar un equipo |
| PUT | `/api/equipos/{id}` | Actualizar un equipo |
| DELETE | `/api/equipos/{id}` | Eliminar un equipo |

## Ejemplo para registrar un equipo

Enviar una solicitud POST a `/api/equipos` con el siguiente JSON:

```json
{
  "nombre": "Laptop de prueba",
  "tipo": "Laptop",
  "marca": "Lenovo",
  "modelo": "ThinkPad E14",
  "numeroSerie": "SN-SMARTFIX-001",
  "estado": "Disponible",
  "descripcion": "Equipo registrado para probar el servicio"
}
```

El servicio genera automáticamente el ID del equipo y lo devuelve en la respuesta. Ese ID permite que otros módulos identifiquen el equipo.

## Manejo de errores

- `400 Bad Request`: datos de entrada inválidos.
- `404 Not Found`: el equipo solicitado no existe.
- `201 Created`: equipo registrado correctamente.
- `204 No Content`: equipo eliminado correctamente.

## Integrante responsable

Integrante 2: Gestión de equipos.