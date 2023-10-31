package com.biblioteca.biblioteca.controller;
import com.biblioteca.biblioteca.model.Editorial;
import com.biblioteca.biblioteca.service.EditorialI;
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

class EditorialControllerTest {

    @InjectMocks
    private EditorialController editorialController;

    @Mock
    private EditorialI editorialService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAllEditorialesTest() {
        List<Editorial> listaEditoriales = new ArrayList<>();
        when(editorialService.findAllEditoriales()).thenReturn(listaEditoriales);

        ResponseEntity<List<Editorial>> responseEntity = editorialController.findAllEditoriales();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(listaEditoriales, responseEntity.getBody());
    }

    @Test
    void findEditorialByNombreTest() {
        String nombre = "Editorial1";
        Editorial editorial = new Editorial();
        when(editorialService.findEditorial(nombre)).thenReturn(editorial);

        ResponseEntity<Editorial> responseEntity = editorialController.findEditorialByNombre(nombre);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(editorial, responseEntity.getBody());
    }

    @Test
    void saveEditorialTest() {
        Editorial editorial = new Editorial();
        when(editorialService.saveEditorial(editorial)).thenReturn("Editorial guardada");

        ResponseEntity<String> responseEntity = editorialController.saveEditorial(editorial);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("Editorial guardada", responseEntity.getBody());
    }

    @Test
    void updateEditorialTest() {
        Long id = 1L;
        Editorial editorial = new Editorial();
        when(editorialService.updateEditorial(id, editorial)).thenReturn("Editorial actualizada");

        ResponseEntity<String> responseEntity = editorialController.updateEditorial(id, editorial);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Editorial actualizada", responseEntity.getBody());
    }

    @Test
    void deleteEditorialTest() {
        Long id = 1L;
        when(editorialService.deleteEditorial(id)).thenReturn("Editorial eliminada");

        ResponseEntity<String> responseEntity = editorialController.deleteEditorial(id);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        assertEquals("Editorial eliminada", responseEntity.getBody());
    }
}
