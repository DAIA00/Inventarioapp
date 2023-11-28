package com.olganails.Inventarioapp.Controllers;

import java.util.List;
import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olganails.Inventarioapp.Models.CategoriaModel;
import com.olganails.Inventarioapp.Services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    CategoriaService categoriaService;

    //@Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<CategoriaModel> obtenerTodasCategorias() {
        return categoriaService.obtenerTodasCategorias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaModel> obtenerCategoriaPorId(@PathVariable String id) {
        Optional<CategoriaModel> categoria = categoriaService.obtenerCategoriaPorId(id);
        return categoria.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<String> crearCategoria(@RequestBody CategoriaModel nuevaCategoria) {
        try {
            categoriaService.crearCategoria(nuevaCategoria);
            return new ResponseEntity<>("Categoría creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la categoría: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarCategoria(@PathVariable String id, @RequestBody CategoriaModel categoriaActualizada) {
        Optional<CategoriaModel> categoriaExistente = categoriaService.obtenerCategoriaPorId(id);
        if (categoriaExistente.isPresent()) {
            categoriaActualizada.setId(id);
            categoriaService.actualizarCategoria(categoriaActualizada);
            return new ResponseEntity<>("Categoría actualizada exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se encontró la categoría con ID: " + id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarCategoria(@PathVariable String id) {
        try {
            categoriaService.borrarCategoria(id);
            return new ResponseEntity<>("Categoría borrada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al borrar la categoría: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
