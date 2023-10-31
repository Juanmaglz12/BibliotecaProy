package com.biblioteca.biblioteca.service;
import com.biblioteca.biblioteca.model.Autor;
import com.biblioteca.biblioteca.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AutorImpl implements AutorI {

    private final AutorRepository autorRepository;
    @Override
    public List<Autor> findAllAutores() {
        List<Autor> listaAutores = autorRepository.findAll();
        return listaAutores;
    }

    @Override
    public String saveAutor(Autor autor) {
        Autor autorEntity = autor;
        autorRepository.save(autorEntity);
        return "Autor guardado";
    }

    @Override
    public Autor findAutor(String nombre) {
        Autor autorEntity = autorRepository.findAutorByNombre(nombre);
        return autorEntity;
    }

    @Override
    public String updateAutor(Long id, Autor autor) {
        Autor autorEntity = autorRepository.findById(id).orElseThrow();
        autor.setNombre(autor.getNombre());
        autor.setAlta(autor.getAlta());
        autorRepository.save(autor);
        return "Autor actualizado";
    }

    @Override
    public String deleteAutor(Long id) {
        autorRepository.deleteById(id);
        return "Autor eliminado";
    }
}
