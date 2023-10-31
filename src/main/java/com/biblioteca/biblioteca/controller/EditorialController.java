package com.biblioteca.biblioteca.controller;
import com.biblioteca.biblioteca.model.Editorial;
import com.biblioteca.biblioteca.model.Libro;
import com.biblioteca.biblioteca.service.EditorialI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/editoriales")
public class EditorialController {

    private final EditorialI editorialService;

    @GetMapping("/findAllEditoriales")
    public ResponseEntity<List<Editorial>> findAllEditoriales(){
        List<Editorial> lista = editorialService.findAllEditoriales();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/findEditorialByNombre/{nombre}")
    public ResponseEntity<Editorial> findEditorialByNombre(@PathVariable String nombre){
        Editorial editorial = editorialService.findEditorial(nombre);
        if (editorial != null){
            return new ResponseEntity<>(editorial, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/saveEditorial")
    public ResponseEntity<String> saveEditorial(@RequestBody Editorial editorial){
        String mensaje = editorialService.saveEditorial(editorial);
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @PutMapping("/updateEditorial/{id}")
    public ResponseEntity<String> updateEditorial(@PathVariable Long id, @RequestBody Editorial editorial) {
        String mensaje = editorialService.updateEditorial(id, editorial);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @DeleteMapping("/deleteEditorial/{id}")
    public ResponseEntity<String> deleteEditorial(@PathVariable Long id) {
        String mensaje = editorialService.deleteEditorial(id);
        return new ResponseEntity<>(mensaje, HttpStatus.NO_CONTENT);
    }

}
