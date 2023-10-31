package com.biblioteca.biblioteca.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditorialTest {

    private Editorial editorial = new Editorial(
            1L,
            "Editorial1",
            true
    );

    @Test
    void getId_editorialTest() {
        assertEquals(1L,editorial.getId_editorial());
    }

    @Test
    void getNombreTest() {
        assertEquals("Editorial1",editorial.getNombre());
    }

    @Test
    void getAltaTest() {
        assertEquals(true,editorial.getAlta());
    }

    @Test
    void setId_editorialTest() {
        editorial.setId_editorial(2L);
        assertEquals(2L,editorial.getId_editorial());
    }

    @Test
    void setNombreTest() {
        editorial.setNombre("EditorialTest");
        assertEquals("EditorialTest",editorial.getNombre());
    }

    @Test
    void setAltaTest() {
        editorial.setAlta(false);
        assertEquals(false,editorial.getAlta());
    }
}