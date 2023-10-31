package com.biblioteca.biblioteca.controller;
import com.biblioteca.biblioteca.model.Autor;
import com.biblioteca.biblioteca.service.AutorI;
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

class AutorControllerTest {

    @InjectMocks
    private AutorController autorController;

    @Mock
    private AutorI autorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAllAutoresTest() {
        List<Autor> listaAutores = new ArrayList<>();
        when(autorService.findAllAutores()).thenReturn(listaAutores);

        ResponseEntity<List<Autor>> responseEntity = autorController.findAllAutores();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(listaAutores, responseEntity.getBody());
    }

    @Test
    void findAutorByNombreTest() {
        String nombre = "Autor1";
        Autor autor = new Autor();
        when(autorService.findAutor(nombre)).thenReturn(autor);

        ResponseEntity<Autor> responseEntity = autorController.findAutorByNombre(nombre);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(autor, responseEntity.getBody());
    }

    @Test
    void saveAutorTest() {
        Autor autor = new Autor();
        when(autorService.saveAutor(autor)).thenReturn("Autor guardado");

        ResponseEntity<String> responseEntity = autorController.saveAutor(autor);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("Autor guardado", responseEntity.getBody());
    }

    @Test
    void updateAutorTest() {
        Long id = 1L;
        Autor autor = new Autor();
        when(autorService.updateAutor(id, autor)).thenReturn("Autor actualizado");

        ResponseEntity<String> responseEntity = autorController.updateAutor(id, autor);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Autor actualizado", responseEntity.getBody());
    }

    @Test
    void deleteAutorTest() {
        Long id = 1L;
        when(autorService.deleteAutor(id)).thenReturn("Autor eliminado");

        ResponseEntity<String> responseEntity = autorController.deleteEditorial(id);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        assertEquals("Autor eliminado", responseEntity.getBody());
    }
}
