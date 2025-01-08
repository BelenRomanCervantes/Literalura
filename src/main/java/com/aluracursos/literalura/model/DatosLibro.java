package com.aluracursos.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<DatosAutor> autor,
        @JsonAlias("languages") List<String> idioma,
        @JsonAlias("download_count") Double numeroDescargas
) {

    @Override
    public String toString() {
        return "Libro: " + '\n' +
                "titulo='" + titulo + '\n' +
                "autor=" + autor + '\n' +
                "idioma=" + idioma + '\n' +
                "numeroDescargas=" + numeroDescargas;
    }
}
