package com.aluracursos.literalura.repository;

import com.aluracursos.literalura.model.Idioma;
import com.aluracursos.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    Optional<Libro> findByTituloContainingIgnoreCase(String titulo);

    @Query("SELECT l FROM Libro l WHERE l.autor.id = :autorId")
    List<Libro> findLibrosByAutorId(@Param("autorId") Long autorId);

    List<Libro> findByIdioma(Idioma idioma);

    @Query("SELECT l FROM Libro l ORDER BY numeroDescargas DESC LIMIT 10")
    List<Libro> findTop10();
}
