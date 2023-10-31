package com.biblioteca.biblioteca.service;
import com.biblioteca.biblioteca.model.Libro;
import java.util.List;

public interface LibroI {
    List<Libro> findAllLibros();
    String saveLibro(Libro libroDto);
    Libro findLibro(String titulo);
    String updateLibro(Long id,Libro libroDto);
    String deleteLibro(Long id);
}
