<h1> Literalura </h1>
Aplicación de consola para la búsqueda de libros con conexión a la API Gutendex (https://gutendex.com/) y almacenamiento de los datos obtenidos en una base de datos PostgreSQL.

## 🛠️ Funcionalidades. 
1 - Buscar libro por título. 
Muestra y almacena los datos de un libro determinado: 
  * Solicita el título de un libro y lo busca en la API de Gutendex.
  * Devuelve los datos encontrados y los almacena en la base de datos.
  * Si el libro no existe devuelve un mensaje de error. 

2 - Listar todos los libros registrados. 
Muestra los datos de todos los llibros que han sido almacenados. 

3 - Listar autores registrados. 
Muestra los datos de los autores que han sido registrados en la base de datos. 

4 - Listar autores vivos en un determinado año. 
Muestra los nombres de los autores que hayan estado vivos en determinado periodo:
    a. Solicita el primer y último año del periodo que se desea buscar.
    b. Realiza la búsqueda en la base de datos de los autores que hayan vivido durante ese periodo.  

5 - Listar libros por idioma. 
Muestra la cantidad de libros almacenados en la base de datos según su idioma. 

## 📋 Tecnologías utilizadas. 
- [ ] Java 17
- [ ] Spring Boot
- [ ] PostgreSQL
- [ ] Jackson
- [ ] PGAdmin

## 🚀 ¿Cómo usarlo? 
1. Clonar este repositorio `https://github.com/BelenRomanCervantes/Literalura.git`. 
2. Crear la base de datos en PostgreSQL: 
    * Usando PGAdmin, crear una base de datos de nombre `libros` o similar.
    * Configurar el archivo application.properties del proyecto según tus credenciales de PostgreSQL:
    ```
    spring.datasource.url=jdbc:postgresql://localhost/<NOMBRE_DE_TU_BASE_DE_DATOS>
    spring.datasource.username=<TU_USUARIO>
    spring.datasource.password=<TU_PASSWORD>
    ```
3. Ejecutar la aplicación. 

   
