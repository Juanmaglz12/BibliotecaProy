package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.Editorial;
import com.biblioteca.biblioteca.repository.EditorialRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class EditorialImplTest {

    @InjectMocks
    private EditorialImpl editorialService;

    @Mock
    private EditorialRepository editorialRepository;

    @Test
    void findAllEditorialesTest() {
        when(editorialRepository.findAll()).thenReturn(Collections.singletonList(new Editorial()));
        List<Editorial> result = editorialService.findAllEditoriales();
        assertEquals(1, result.size());
    }

    @Test
    void saveEditorialTest() {
        Editorial editorial = new Editorial();
        when(editorialRepository.save(editorial)).thenReturn(editorial);
        String result = editorialService.saveEditorial(editorial);
        assertEquals("Editorial guardada", result);
    }

    @Test
    void findEditorialTest() {
        String nombre = "Editorial1";
        Editorial editorial = new Editorial();
        when(editorialRepository.findByNombre(nombre)).thenReturn(editorial);
        Editorial result = editorialService.findEditorial(nombre);
        assertEquals(editorial, result);
    }

    @Test
    void updateEditorialTest() {
        Long id = 1L;
        Editorial editorial = new Editorial();
        Optional<Editorial> optionalEditorial = Optional.of(new Editorial());
        when(editorialRepository.findById(id)).thenReturn(optionalEditorial);
        when(editorialRepository.save(any(Editorial.class))).thenReturn(editorial);

        String result = editorialService.updateEditorial(id, editorial);

        assertEquals("Editorial actualizada", result);
    }

    @Test
    void deleteEditorialTest() {
        Long id = 1L;
        doNothing().when(editorialRepository).deleteById(id);

        String result = editorialService.deleteEditorial(id);

        assertEquals("Editorial eliminada", result);
    }
}
