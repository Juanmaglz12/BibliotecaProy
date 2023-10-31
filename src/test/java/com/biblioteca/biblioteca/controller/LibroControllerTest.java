package com.biblioteca.biblioteca.controller;
import com.biblioteca.biblioteca.model.Libro;
import com.biblioteca.biblioteca.service.LibroI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LibroControllerTest {

    @InjectMocks
    private LibroController libroController;

    @Mock
    private LibroI libroService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAllLibrosTest() {
        List<Libro> listaLibros = new ArrayList<>();
        when(libroService.findAllLibros()).thenReturn(listaLibros);

        ResponseEntity<List<Libro>> responseEntity = libroController.findAllLibros();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(listaLibros, responseEntity.getBody());
    }

    @Test
    void findLibroByTituloTest() {
        String titulo = "Libro1";
        Libro libro = new Libro();
        when(libroService.findLibro(titulo)).thenReturn(libro);

        ResponseEntity<Libro> responseEntity = libroController.findLibroByTitulo(titulo);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(libro, responseEntity.getBody());
    }

    @Test
    void saveLibroTest() {
        Libro libro = new Libro();
        when(libroService.saveLibro(libro)).thenReturn("Libro guardado");

        ResponseEntity<String> responseEntity = libroController.saveLibro(libro);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("Libro guardado", responseEntity.getBody());
    }

    @Test
    void updateLibroTest() {
        Long id = 1L;
        Libro libro = new Libro();
        when(libroService.updateLibro(id, libro)).thenReturn("Libro actualizado");

        ResponseEntity<String> responseEntity = libroController.updateLibro(id, libro);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Libro actualizado", responseEntity.getBody());
    }

    @Test
    void deleteLibroTest() {
        Long id = 1L;
        when(libroService.deleteLibro(id)).thenReturn("Libro eliminado");

        ResponseEntity<String> responseEntity = libroController.deleteLibro(id);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        assertEquals("Libro eliminado", responseEntity.getBody());
    }
}
