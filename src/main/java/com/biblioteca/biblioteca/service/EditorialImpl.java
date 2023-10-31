package com.biblioteca.biblioteca.service;
import com.biblioteca.biblioteca.model.Editorial;
import com.biblioteca.biblioteca.repository.EditorialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EditorialImpl implements EditorialI {

    private final EditorialRepository editorialRepository;


    @Override
    public List<Editorial> findAllEditoriales() {
        List<Editorial> listaEditoriales = editorialRepository.findAll();
        return listaEditoriales;
    }

    @Override
    public String saveEditorial(Editorial editorial) {
        Editorial editorialEntity = editorial;
        editorialRepository.save(editorialEntity);
        return "Editorial guardada";
    }

    @Override
    public Editorial findEditorial(String nombre) {
        Editorial editorialEntity = editorialRepository.findByNombre(nombre);
        return editorialEntity;
    }

    @Override
    public String updateEditorial(Long id, Editorial editorial) {
        Editorial editorialEntity = editorialRepository.findById(id).orElseThrow();

        editorial.setNombre(editorial.getNombre());
        editorial.setAlta(editorial.getAlta());

        editorialRepository.save(editorialEntity);
        return "Editorial actualizada";
    }

    @Override
    public String deleteEditorial(Long id) {
        editorialRepository.deleteById(id);
        return "Editorial eliminada";
    }
}
