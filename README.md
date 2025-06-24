# Crud_PC

Crud_PC es un sistema básico desarrollado en Java para la gestión de computadoras. Permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre una base de datos MySQL, facilitando el manejo de información relacionada con computadoras.

## Características

- **Agregar computadoras:** Permite registrar nuevas computadoras en el sistema.
- **Listar computadoras:** Muestra todas las computadoras registradas.
- **Editar computadoras:** Permite modificar la información de una computadora existente.
- **Eliminar computadoras:** Permite eliminar computadoras del sistema.

## Tecnologías utilizadas

- **Lenguaje:** Java
- **Base de datos:** MySQL
- **Conexión:** JDBC (Java Database Connectivity)

## Requisitos previos

- Java JDK 8 o superior
- MySQL Server en funcionamiento
- Driver JDBC de MySQL (por ejemplo, `mysql-connector-java`)
- Un IDE para Java (Eclipse, IntelliJ IDEA, NetBeans, etc.)

## Instalación y configuración

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/Tkex555/Crud_PC.git

2. Importar el proyecto
   
   * Abre tu IDE favorito y selecciona la opción para importar un proyecto Java.
   * Selecciona la carpeta donde clonaste este repositorio.
## Ruta de compilación (Build Path)

Asegúrate de que tu proyecto incluya en el Build Path:

- El archivo JAR del driver JDBC de MySQL (`mysql-connector-java-x.x.x.jar`)
- Las carpetas `src/` (código fuente) y, si corresponde, `bin/` o `out/` (archivos compilados)

### Cómo agregar el driver JDBC al build path

1. Descarga el archivo `mysql-connector-java` desde el [sitio oficial de MySQL](https://dev.mysql.com/downloads/connector/j/).
2. En tu IDE, haz clic derecho sobre el proyecto > **Properties** (Propiedades).
3. Ve a **Java Build Path** > **Libraries** > **Add External JARs...** y selecciona el archivo JAR que descargaste.
4. Aplica y guarda los cambios.

Esto permitirá que tu aplicación Java se conecte correctamente a la base de datos MySQL.

 ## Ejemplo de uso
  - Agregar una computadora: Rellena el formulario con los datos solicitados y haz clic en "Agregar".
  - Listar computadoras: Haz clic en el botón "Listar" para ver todas las computadoras registradas en la base de datos.
  - Editar: Selecciona una computadora de la lista, modifica los campos necesarios y guarda los cambios.
  -  Eliminar: Selecciona una computadora y haz clic en "Eliminar" para borrarla del registro.
## Autores
- [Tkex555](https://github.com/Tkex555)
- [alfadestruc17](https://github.com/alfadestruc17)
