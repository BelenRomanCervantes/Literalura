package com.aluracursos.literalura;

import com.aluracursos.literalura.model.Datos;
import com.aluracursos.literalura.model.DatosLibro;
import com.aluracursos.literalura.model.Libro;
import com.aluracursos.literalura.repository.LibroRepository;
import com.aluracursos.literalura.service.ConsumoAPI;
import com.aluracursos.literalura.service.ConvierteDatos;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/";
    private ConvierteDatos conversor = new ConvierteDatos();
    private LibroRepository repositorio;
    private List<DatosLibro> datosLibros = new ArrayList<>();
    private List<Libro> libros;

    public Principal(LibroRepository repository){
        this.repositorio = repository;
    }

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    ------------------
                    Escriba el número de la opción que desea ejecutar:
                    1 - Buscar libro por título
                    2 - Listar todos los libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en un determinado año
                    5 - Listar libros por idioma

                    0 - Salir
                    ------------------
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
                    System.out.println("Opción inválida");
            }
        }
    }


    private Datos obtenerDatosLibro() {
        System.out.println("Escribe el nombre del libro que deseas buscar");
        var tituloBuscado = teclado.nextLine().toLowerCase();
        var json = consumoApi.obtenerDatos(URL_BASE + "?search=" + tituloBuscado.replace(" ", "+"));
        var datos = conversor.obtenerDatos(json, Datos.class);
        return datos;
    }

    private Libro buscarLibroPorTitulo() {
        System.out.println("Escribe el nombre del libro que deseas buscar");
        var tituloBuscado = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + "?search=" + tituloBuscado.replace(" ", "+"));
        var datosBusqueda = conversor.obtenerDatos(json, Datos.class);
        Optional<DatosLibro> libroBuscado = datosBusqueda.resultados().stream()
                .filter(l -> l.titulo().toLowerCase().contains(tituloBuscado.toLowerCase()))
                .findFirst();
        if(libroBuscado.isPresent()){
            System.out.println("Libro encontrado");
            var libroEncontrado = libroBuscado.get();
            Libro libroNuevo = new Libro(libroEncontrado);
            System.out.println(libroNuevo);
            return libroNuevo;
        } else {
            System.out.println("Libro no encontrado");
            return null;
        }
    }

    private void guardarLibro() {
        Libro libro = buscarLibroPorTitulo();

        repositorio.save(libro);
    }

    private void listarLibrosRegistrados(){
        libros =repositorio.findAll();
        if (libros.isEmpty()){
            System.out.println("Aún no hay libros en la base de datos");
        } else {
            libros.stream()
                    .sorted(Comparator.comparing(Libro::getTitulo))
                    .forEach(System.out::println);
        }

    }



}

