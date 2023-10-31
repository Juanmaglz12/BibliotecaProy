package com.biblioteca.biblioteca.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibroTest {
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
    void getId_libroTest() {
       assertEquals(1L,libro.getId_libro());
    }

    @Test
    void getIsbnTest() {
        assertEquals(123,libro.getIsbn());
    }

    @Test
    void getTituloTest() {
        assertEquals("libro1",libro.getTitulo());
    }

    @Test
    void getAnioTest() {
        assertEquals(1998,libro.getAnio());
    }

    @Test
    void getEjemplaresTest() {
        assertEquals(2,libro.getEjemplares());
    }

    @Test
    void getEjemplaresPrestadosTest() {
        assertEquals(1,libro.getEjemplaresPrestados());
    }

    @Test
    void getEjemplaresRestantesTest() {
        assertEquals(1,libro.getEjemplaresRestantes());
    }

    @Test
    void getAltaTest() {
        assertEquals(true,libro.getAlta());
    }

    @Test
    void getAutorTest() {
        assertEquals(autor,libro.getAutor());
    }

    @Test
    void getEditorialTest() {
        assertEquals(editorial,libro.getEditorial());
    }

    @Test
    void setId_libroTest() {
        libro.setId_libro(2L);
        assertEquals(2L, libro.getId_libro());
    }

    @Test
    void setIsbnTest() {
        libro.setIsbn(444L);
        assertEquals(444L, libro.getIsbn());
    }

    @Test
    void setTituloTest() {
        libro.setTitulo("Libro de test");
        assertEquals("Libro de test", libro.getTitulo());
    }

    @Test
    void setAnioTest() {
        libro.setAnio(1777);
        assertEquals(1777, libro.getAnio());
    }

    @Test
    void setEjemplaresTest() {
        libro.setEjemplares(7);
        assertEquals(7, libro.getEjemplares());
    }

    @Test
    void setEjemplaresPrestadosTest() {
        libro.setEjemplaresPrestados(7);
        assertEquals(7, libro.getEjemplaresPrestados());
    }

    @Test
    void setEjemplaresRestantesTest() {
        libro.setEjemplaresRestantes(0);
        assertEquals(0, libro.getEjemplaresRestantes());
    }

    @Test
    void setAltaTest() {
        libro.setAlta(false);
        assertEquals(false, libro.getAlta());
    }

    @Test
    void setAutorTest() {
        Autor autor2 = new Autor(
            2L,
            "Autor2",
            false
        );
        libro.setAutor(autor2);
    }

    @Test
    void setEditorialTest() {
        Editorial editorial2 = new Editorial(
                2L,
                "Editorial2",
                false
        );
        libro.setEditorial(editorial2);
    }
}