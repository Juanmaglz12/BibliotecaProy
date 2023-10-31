package com.biblioteca.biblioteca.service;
import com.biblioteca.biblioteca.model.Editorial;
import java.util.List;

public interface EditorialI {
    List<Editorial> findAllEditoriales();
    String saveEditorial(Editorial editorial);
    Editorial findEditorial(String nombre);
    String updateEditorial(Long id,Editorial editorial);
    String deleteEditorial(Long id);
}
