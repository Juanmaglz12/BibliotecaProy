package com.biblioteca.biblioteca.repository;

import com.biblioteca.biblioteca.model.Editorial;
import com.biblioteca.biblioteca.model.Libro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EditorialRepositoryTest {

    @Autowired
    private EditorialRepository editorialRepository;

    private Editorial editorial = new Editorial(
            1L,
            "Editorial1",
            true
    );
    @Test
    void findByNombreTest() {
        editorialRepository.save(editorial);
        Editorial editorialEncontrado = editorialRepository.findByNombre("Editorial1");
        assertEquals(editorial.getNombre(), editorialEncontrado.getNombre());
    }

}