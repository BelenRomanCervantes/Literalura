package com.aluracursos.literalura.repository;

import com.aluracursos.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Query("SELECT a FROM Autor a WHERE nombre ILIKE %:texto%")
    Optional<Autor> findByNombre(String texto);

    @Query("SELECT a FROM Autor a WHERE fechaNacimiento < :anio AND fechaFallecimiento > :anio")
    List<Autor> buscarAutoresPorAnio(int anio);
}
