package com.biblioteca.biblioteca.controller;
import com.biblioteca.biblioteca.model.Libro;
import com.biblioteca.biblioteca.service.LibroI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/libros")
public class LibroController {

    private final LibroI libroService;

    @GetMapping("/findAllLibros")
    public ResponseEntity<List<Libro>> findAllLibros(){
        List<Libro> lista = libroService.findAllLibros();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/findLibroByTitulo/{titulo}")
    public ResponseEntity<Libro> findLibroByTitulo(@PathVariable String titulo){
        Libro libro = libroService.findLibro(titulo);
        if (libro != null){
            return new ResponseEntity<>(libro, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/saveLibro")
    public ResponseEntity<String> saveLibro(@RequestBody Libro libro){
        String mensaje = libroService.saveLibro(libro);
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @PutMapping("/updateLibro/{id}")
    public ResponseEntity<String> updateLibro(@PathVariable Long id, @RequestBody Libro libro) {
        String mensaje = libroService.updateLibro(id, libro);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @DeleteMapping("/deleteLibro/{id}")
    public ResponseEntity<String> deleteLibro(@PathVariable Long id) {
        String mensaje = libroService.deleteLibro(id);
        return new ResponseEntity<>(mensaje, HttpStatus.NO_CONTENT);
    }


}
