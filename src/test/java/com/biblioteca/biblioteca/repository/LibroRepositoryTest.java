package com.biblioteca.biblioteca.repository;

import com.biblioteca.biblioteca.model.Autor;
import com.biblioteca.biblioteca.model.Editorial;
import com.biblioteca.biblioteca.model.Libro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LibroRepositoryTest {

    @Autowired
    private LibroRepository libroRepository;

    private Autor autor = new Autor(
            1L,
            "Autor1",
            true
    );

    private Editorial editorial = new Editorial(
            1L,
            "Editorial1",
            true
    );

    private Libro libro = new Libro(
            1L,
            123L,
            "libro1",
            1998,
            2,
            1,
            1,
            true,
            autor,
            editorial
    );

    @Test
    void findByTituloTest() {
        libroRepository.save(libro);
        Libro libroEncontrado = libroRepository.findByTitulo("libro1");
        assertEquals(libro.getTitulo(), libroEncontrado.getTitulo());
    }
}