package com.biblioteca.biblioteca.repository;

import com.biblioteca.biblioteca.model.Autor;
import com.biblioteca.biblioteca.model.Libro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AutorRepositoryTest {

    @Autowired
    private AutorRepository autorRepository;

    private Autor autor = new Autor(
            1L,
            "Autor1",
            true
    );

    @Test
    void findAutorByNombreTest() {
        autorRepository.save(autor);
        Autor autorEncontrado = autorRepository.findAutorByNombre("Autor1");
        assertEquals(autor.getNombre(), autorEncontrado.getNombre());
    }
}
