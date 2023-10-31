package com.biblioteca.biblioteca.service;
import com.biblioteca.biblioteca.model.Libro;
import com.biblioteca.biblioteca.repository.LibroRepository;
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
class LibroImplTest {

    @InjectMocks
    private LibroImpl libroService;

    @Mock
    private LibroRepository libroRepository;

    @Test
    void findAllLibrosTest() {
        when(libroRepository.findAll()).thenReturn(Collections.singletonList(new Libro()));
        List<Libro> result = libroService.findAllLibros();
        assertEquals(1, result.size());
    }

    @Test
    void saveLibroTest() {
        Libro libro = new Libro();
        when(libroRepository.save(libro)).thenReturn(libro);
        String result = libroService.saveLibro(libro);
        assertEquals("Libro guardado", result);
    }

    @Test
    void findLibroTest() {
        String titulo = "Libro1";
        Libro libro = new Libro();
        when(libroRepository.findByTitulo(titulo)).thenReturn(libro);
        Libro result = libroService.findLibro(titulo);
        assertEquals(libro, result);
    }

    @Test
    void updateLibroTest() {
        Long id = 1L;
        Libro libro = new Libro();
        Optional<Libro> optionalLibro = Optional.of(new Libro());
        when(libroRepository.findById(id)).thenReturn(optionalLibro);
        when(libroRepository.save(any(Libro.class))).thenReturn(libro);

        String result = libroService.updateLibro(id, libro);

        assertEquals("Libro actualizado", result);
    }

    @Test
    void deleteLibroTest() {
        Long id = 1L;
        doNothing().when(libroRepository).deleteById(id);

        String result = libroService.deleteLibro(id);

        assertEquals("Libro eliminado", result);
    }
}
