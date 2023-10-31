package com.biblioteca.biblioteca.service;
import com.biblioteca.biblioteca.model.Autor;
import java.util.List;

public interface AutorI {
    List<Autor> findAllAutores();
    String saveAutor(Autor AutorDto);
    Autor findAutor(String nombre);
    String updateAutor(Long id,Autor Autor);
    String deleteAutor(Long id);
}
