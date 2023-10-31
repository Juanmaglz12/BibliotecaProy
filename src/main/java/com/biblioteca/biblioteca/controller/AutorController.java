package com.biblioteca.biblioteca.controller;
import com.biblioteca.biblioteca.model.Autor;
import com.biblioteca.biblioteca.model.Libro;
import com.biblioteca.biblioteca.service.AutorI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/autores")
public class AutorController {

    private final AutorI autorService;

    @GetMapping("/findAllAutores")
    public ResponseEntity<List<Autor>> findAllAutores(){
        List<Autor> lista = autorService.findAllAutores();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/findAutorByNombre/{nombre}")
    public ResponseEntity<Autor> findAutorByNombre(@PathVariable String nombre){
        Autor autor = autorService.findAutor(nombre);
        if (autor != null){
            return new ResponseEntity<>(autor, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/saveAutor")
    public ResponseEntity<String> saveAutor(@RequestBody Autor autor){
        String mensaje = autorService.saveAutor(autor);
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @PutMapping("/updateAutor/{id}")
    public ResponseEntity<String> updateAutor(@PathVariable Long id, @RequestBody Autor autor) {
        String mensaje = autorService.updateAutor(id, autor);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAutor/{id}")
    public ResponseEntity<String> deleteEditorial(@PathVariable Long id) {
        String mensaje = autorService.deleteAutor(id);
        return new ResponseEntity<>(mensaje, HttpStatus.NO_CONTENT);
    }

}
