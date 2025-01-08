package com.aluracursos.literalura;

import com.aluracursos.literalura.model.*;
import com.aluracursos.literalura.repository.AutorRepository;
import com.aluracursos.literalura.repository.LibroRepository;
import com.aluracursos.literalura.service.ConsumoAPI;
import com.aluracursos.literalura.service.ConvierteDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Principal {

    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private List<DatosLibro> datosLibros = new ArrayList<>();
    private List<Libro> libros;
    private String mensajeOpcionInvalida = "Opción incorrecta. Intente nuevamente.";

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    public Principal(LibroRepository libroRepository, AutorRepository autorRepository){
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    ---------------MENÚ----------------
                    Escriba el número de la opción que desea ejecutar:
                    1 - Buscar libro por título
                    2 - Listar todos los libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en un determinado año
                    5 - Listar libros por idioma

                    0 - Salir
                    ------------------------------------
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    guardarLibro();
                    break;
                case 2:
                    listarLibrosRegistrados();
                    break;
////                case 3:
////                    listarAutoresRegistrados();
////                    break;
////                case 4:
////                    listarAutoresVivosPorAño();
////                    break;
////                case 5:
////                    listarLibrosPorIdioma();
//                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println(mensajeOpcionInvalida);
            }
        }
    }

    public DatosLibro getDatosLibro() {
        System.out.println("Escribe el título del libro que buscas: ");
        var tituloBuscado = teclado.nextLine();
        try {
            var json = consumoApi.obtenerDatos(tituloBuscado.replace(" ", "+"));
            var datos = conversor.obtenerDatos(json, DatosLibro.class);
            return datos;
        } catch (Exception e) {
            System.out.println(mensajeOpcionInvalida);
        }
        return null;
    }

    private void guardarLibro() {
        DatosLibro datosLibro = getDatosLibro();
        if (datosLibro != null) {
        Optional<Autor> nombreAutor = autorRepository.findByNombre(datosLibro.autor().get(0).nombre());

            Libro libro = new Libro();
            libro.setTitulo(datosLibro.titulo());
            libro.setIdioma(Idioma.fromString(datosLibro.idioma().get(0)));
            libro.setNumeroDescargas(datosLibro.numeroDescargas());

            if (nombreAutor.isPresent()) {
                Autor autorExistente = nombreAutor.get();
                libro.setAutor(autorExistente);
            } else {
                Autor nuevoAutor = new Autor(datosLibro.autor().get(0));
                nuevoAutor = autorRepository.save(nuevoAutor);
                libro.setAutor(nuevoAutor);
            }
            try {
                Optional<Libro> libroExistente = libroRepository.findByTituloContainingIgnoreCase(datosLibro.titulo());
                if (libroExistente.isPresent()) {
                    System.out.println("El libro ya está registrado.");
                    return; // Salir del metodo si el libro ya existe
                }
                libroRepository.save(libro);
                System.out.println(datosLibro);
            } catch (Exception e) {
                System.out.println("Libro registrado anteriormente");
            }
        } else {
            System.out.println(mensajeOpcionInvalida);
        }
    }

    private void listarLibrosRegistrados(){
        libros =libroRepository.findAll();
        if (libros.isEmpty()){
            System.out.println("Aún no hay libros en la base de datos");
        } else {
            libros.stream()
                    .sorted(Comparator.comparing(Libro::getTitulo))
                    .forEach(System.out::println);
        }

    }



}

