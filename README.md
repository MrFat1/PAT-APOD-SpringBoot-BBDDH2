# PAT-Practica5

En esta práctica se reutiliza el servidor creado en la práctica anterior y se le añade funcionalidad de persistencia en una base de datos BBDD H2.

El servidor esta levantado en el puerto 8888 (http://localhost:8888) y utiliza el Actuator "Health" para comprobar el estado de dicho servidor. Accediendo a http://localhost:8888/health se podrá visualizar el estado de este por un mensaje de texto.

Adicionalmente, se podrá llevar un seguimiento de las tablas registradas en la base de datos accediendo a la consola H2 a través del enlace http://localhost:8888/h2-console/ e introduciendo el **usuario sa** y la **contraseña 1234**.

##Casos de prueba
Haciendo uso de la libería JUnit, se han realizado diversos casos de prueba para las llamadas a la API. Se pueden encontrar en la carpeta de Tests.
Las pruebas realizadas son las siguiente:

- Casos de prueba correctos (HTTP 200) en la llamada a la API APOD de la nasa y MarsRober Images, comprobando el status code devuelto
- Casos de prueba por error en los parámetros (HTTP 400) al introducir una fecha errónea en el formulario de búsqueda de imágenes
- Casos de prueba de error en el servidor (HTTP 500) cuando la API key es incorrecta

##Operaciones con la base de datos

En vez de generar un fichero con la tabla de la base de datos ya generada, se hará uso de la **API de la NASA** *RoberImages* para rellenar una tabla con la información devuelta por la API. La estructura de la tabla la podrá encontrar en el fichero *schema.sql*. 

Si se accede a la página *roberImages.html*, encontrará el mismo formulario de la práctica anterior pero con 5 nuevos botones cuyo funcionamiento se indica a continuación:

| Boton | Acción |
| ------ | ------ |
| Buscar | Realiza la llamada a la API y muestra las imágenes obtenidas |
| Vaciar galería actual | Elimina todas las imágenes mostradas en la interfaz (no de la DB) |
| Cargar galería guardada | Carga la galería guardada actualmente en la base de datos |
| Guardar Galería | Guarda la galería mostrada en la interfaz en la base de datos |
| Eliminar galería guardada | Elimina la galería guardada actualmente en la base de datos |

Para las operaciones de INSERT, UPDATE y DELETE se ha hecho uso de la anotación @Query
Para la operación de SELECT se ha hecho uso de la interfaz CrudRepository

### Loggers
Se han dispuesto loggers por toda la aplicación para realizar un seguimiento detallado de esta.
