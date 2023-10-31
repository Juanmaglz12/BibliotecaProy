package com.biblioteca.biblioteca.service;
import com.biblioteca.biblioteca.model.Autor;
import com.biblioteca.biblioteca.repository.AutorRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class AutorImplTest {

    @InjectMocks
    private AutorImpl autorService;

    @Mock
    private AutorRepository autorRepository;

    @Test
    void findAllAutoresTest() {
        when(autorRepository.findAll()).thenReturn(Collections.singletonList(new Autor()));
        List<Autor> result = autorService.findAllAutores();
        assertEquals(1, result.size());
    }

    @Test
    void saveAutorTest() {
        Autor autor = new Autor();
        when(autorRepository.save(autor)).thenReturn(autor);
        String result = autorService.saveAutor(autor);
        assertEquals("Autor guardado", result);
    }

    @Test
    void findAutorTest() {
        String nombre = "Autor1";
        Autor autor = new Autor();
        when(autorRepository.findAutorByNombre(nombre)).thenReturn(autor);
        Autor result = autorService.findAutor(nombre);
        assertEquals(autor, result);
    }

    @Test
    void updateAutorTest() {
        Long id = 1L;
        Autor autor = new Autor();
        Optional<Autor> optionalAutor = Optional.of(new Autor());
        when(autorRepository.findById(id)).thenReturn(optionalAutor);
        when(autorRepository.save(any(Autor.class))).thenReturn(autor);

        String result = autorService.updateAutor(id, autor);

        assertEquals("Autor actualizado", result);
    }

    @Test
    void deleteAutorTest() {
        Long id = 1L;
        doNothing().when(autorRepository).deleteById(id);

        String result = autorService.deleteAutor(id);

        assertEquals("Autor eliminado", result);
    }
}
