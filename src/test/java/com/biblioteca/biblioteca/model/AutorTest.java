package com.biblioteca.biblioteca.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutorTest {

    private Autor autor = new Autor(
            1L,
            "Autor1",
            true
    );

    @Test
    void getId_autorTest() {
        assertEquals(1L,autor.getId_autor());
    }

    @Test
    void getNombreTest() {
        assertEquals("Autor1",autor.getNombre());
    }

    @Test
    void getAltaTest() {
        assertEquals(true,autor.getAlta());
    }

    @Test
    void setId_autorTest() {
        autor.setId_autor(2L);
        assertEquals(2L, autor.getId_autor());
    }

    @Test
    void setNombreTest() {
        autor.setNombre("Autortest");
        assertEquals("Autortest", autor.getNombre());
    }

    @Test
    void setAltaTest() {
        autor.setAlta(false);
        assertEquals(false, autor.getAlta());
    }
}