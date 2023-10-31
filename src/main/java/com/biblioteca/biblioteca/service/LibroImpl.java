package com.biblioteca.biblioteca.service;
import com.biblioteca.biblioteca.model.Libro;
import com.biblioteca.biblioteca.repository.LibroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LibroImpl implements LibroI {

    private final LibroRepository libroRepository;
    @Override
    public List<Libro> findAllLibros() {
        List<Libro> listaLibros = libroRepository.findAll();
        return listaLibros;
    }

    @Override
    public String saveLibro(Libro libro) {
        Libro libroEntity = libro;
        libroRepository.save(libroEntity);
        return "Libro guardado";
    }

    @Override
    public Libro findLibro(String titulo) {
        Libro libroEntity = libroRepository.findByTitulo(titulo);
        Libro libro = libroEntity;

        return libro;
    }

    @Override
    public String updateLibro(Long id, Libro libro) {
        Libro libroEntity = libroRepository.findById(id).orElseThrow();

        libro.setIsbn(libro.getIsbn());
        libro.setTitulo(libro.getTitulo());
        libro.setAnio(libro.getAnio());
        libro.setEjemplares(libro.getEjemplares());
        libro.setEjemplaresPrestados(libro.getEjemplaresPrestados());
        libro.setEjemplaresRestantes(libro.getEjemplaresRestantes());
        libro.setAlta(libro.getAlta());
        libro.setEditorial(libro.getEditorial());
        libro.setAutor(libro.getAutor());

        libroRepository.save(libroEntity);
        return "Libro actualizado";
    }

    @Override
    public String deleteLibro(Long id) {
        libroRepository.deleteById(id);
        return "Libro eliminado";
    }
}
