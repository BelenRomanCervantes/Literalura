<h1> Literalura </h1>
Aplicación de consola para la búsqueda de libros con conexión a la API Gutendex (https://gutendex.com/) y almacenamiento de los datos obtenidos en una base de datos PostgreSQL.

## 🛠️ Funcionalidades.
![menu](https://github.com/user-attachments/assets/3ace9227-825a-461f-b5e0-cdf19a15cb00)

1 - Buscar libro por título.
Muestra y almacena los datos de un libro determinado:
* Solicita el título de un libro y lo busca en la API de Gutendex.
* Devuelve los datos encontrados y los almacena en la base de datos.
* Si el libro no existe devuelve un mensaje de error.

![libro](https://github.com/user-attachments/assets/ddcb9850-3fdc-4388-88d1-90eafa8360b2)
![libro2](https://github.com/user-attachments/assets/bc54422b-808e-4da3-94cc-ad4d0c1bc21f)

2 - Listar todos los libros registrados.
Muestra una lista de todos los libros que han sido registrados.

![libros](https://github.com/user-attachments/assets/0b715cf3-5f7c-4f60-ba51-1f513897f6c9)

3 - Listar autores registrados.
Muestra una lista de los autores que han sido registrados en la base de datos y los libros asociados a cada uno de ellos.

![autores](https://github.com/user-attachments/assets/8444614a-5ef6-43a0-ba25-d2fb828a4192)

4 - Listar autores vivos en un determinado año.
Muestra los nombres de los autores que hayan estado vivos en determinado año.

![anio](https://github.com/user-attachments/assets/4e5273f0-9c86-40d6-9bb5-e257a466237a)

5 - Listar libros por idioma.
Muestra una lista de los libros registrados que hayan sido publicados en determinado idioma.

![idioma](https://github.com/user-attachments/assets/bc47d21c-4465-4975-9dc0-796e8cbe123e)

![idiomas2](https://github.com/user-attachments/assets/b5bc7337-91ba-45c8-b1ff-14a62ade5b2f)

6 - Top 10 de los libros más descargados.
Muestra una lista con los 10 libros registrados con mayor número de descargas.

![top10](https://github.com/user-attachments/assets/34553fbd-69e3-4870-8385-d91223432fcc)

7 - Estadísticas de los libros registrados.
Muestra las estadísticas de los libros registrados con base en el número de descargas.
![estadisticas](https://github.com/user-attachments/assets/e72202cb-5b31-4c7d-bf47-70ebc5a1f1eb)

### Ejemplo de la base de datos:
Tabla de libros:  
![tablaLibros](https://github.com/user-attachments/assets/7d7cab99-6b1a-4a69-b4d6-0e4320e80643)

Tabla de autores:  
![tablaAutores](https://github.com/user-attachments/assets/9e97a379-92bf-4459-ad23-24118804335e)

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
   `./mvnw spring-boot:run`
4. Explora las diferentes opciones del menú.

## 👩 Autora
Belén Itzel Román Cervantes.  
<i class="fa-brands fa-linkedin"></i> [Linkedin](https://www.linkedin.com/in/belen-roman-cervantes/)  
<i class="fa-brands fa-instagram"></i> [Instagram](https://www.instagram.com/belenitzelroman/)
   
   
