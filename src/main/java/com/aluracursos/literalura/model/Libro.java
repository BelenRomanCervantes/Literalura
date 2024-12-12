package com.aluracursos.literalura.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column (unique = true)
    private String titulo;
    private String idioma;
    private Double numeroDescargas;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Libro() {
    }

    public Libro(DatosLibro libro) {
        this.titulo = libro.titulo();
        if (libro.autor() != null && !libro.autor().isEmpty()){
            this.autor = new Autor(libro.autor().get(0));
        } else {
            this.autor = null;
        }
        this.idioma = validacionIdioma(libro.idioma());
        this.numeroDescargas = OptionalDouble.of(Double.valueOf(libro.numeroDescargas())).orElse(0);
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdiomas() {
        return idioma;
    }

    public void setIdiomas(String idiomas) {
        this.idioma = idiomas;
    }

    public Double getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(Double numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", idioma='" + idioma + '\'' +
                ", numeroDescargas=" + numeroDescargas;
    }


    private String validacionIdioma(List<String> idioma){
        if (idioma.isEmpty() || idioma == null){
            return  "Desconocido";
        } else {
            return idioma.get(0);
        }
    }
}
