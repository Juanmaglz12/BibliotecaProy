package com.biblioteca.biblioteca.repository;

import com.biblioteca.biblioteca.model.Autor;
import com.biblioteca.biblioteca.model.Editorial;
import com.biblioteca.biblioteca.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Long> {

    Editorial findByNombre(String nombre);
}
