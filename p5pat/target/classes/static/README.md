# PAT-Pr-ctica-3

La página principal (index.html) contiene la imágen de Astronomía del día, ofrecida por la NASA como fondo de pantalla de la página. Además se muestra tanto el título de la imagen como la descripción asociada a esta. Justo debajo de la descripción hay un enlace para poder visualizar la imagen en una nueva pestaña en formato HD. (Al ponerla de fondo de pantalla las dimensiones pueden no ajustarse correctamente, por lo que se ofrece esta alternativa para visualizar la imagen completa).

En la barra de navegación superior, se puede acceder a una segunda página web denominada roberImages.html en la cual se pueden introducir varios parámetros en un formulario para hacer una llamada específica a la API y obtener imágenes del Mars Rober para una fecha o una cámara introducidas. Se introducen los parámetros y al presionar el botón de *Buscar* se ejecutará un script que realiza la llamada. Este script mostrará el array de imágenes obtenido en una galería de **BootStrap** con una pequeña descripcion. 
Notése que las imágenes se acumulan, pues esta pensado para ir generando una galería de imágenes del Mars Rober de distintas cámaras y fechas y poder visualizarlas todas a la vez.

El botón de *Eliminar todo*, elimina todas las fotos actuales en la galería.

*Nota: Es altamente probable que no se encuentren imágenes para una fecha o una cámara introducidas, por lo que a veces será necesario realizar varias búsquedas.*
A continuación se detallas algunas fechas y cámaras para las que encontrará imágenes:

Fecha: 3/06/2015 - Cámaras: FHAZ, RHAZ <br>
Fecha: 12/08/2015 - Cámaras: FHAZ, RHAZ, CHEMCAM, MAST, MAHLI, MARDI, NAVCAM <br>
Fecha: 14/10/2022 - Cámaras: FHAZ, RHAZ, CHEMCAM, MAST, NAVCAM <br>

Animo a realizar algunas pruebas de búsquedas.
