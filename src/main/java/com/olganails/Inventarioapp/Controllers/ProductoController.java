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

import com.olganails.Inventarioapp.Models.ProductoModel;
import com.olganails.Inventarioapp.Services.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    
    private final ProductoService productoService;

    //@Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<ProductoModel> obtenerTodosProductos() {
        return productoService.obtenerTodosProductos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoModel> obtenerProductoPorId(@PathVariable String id) {
        Optional<ProductoModel> producto = productoService.obtenerProductoPorId(id);
        return producto.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<String> crearProducto(@RequestBody ProductoModel nuevoProducto) {
        try {
            productoService.crearProducto(nuevoProducto);
            return new ResponseEntity<>("Producto creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el producto: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarProducto(@PathVariable String id, @RequestBody ProductoModel productoActualizado) {
        Optional<ProductoModel> productoExistente = productoService.obtenerProductoPorId(id);
        if (productoExistente.isPresent()) {
            productoActualizado.setId(id);
            productoService.actualizarProducto(productoActualizado);
            return new ResponseEntity<>("Producto actualizado exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se encontró el producto con ID: " + id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarProducto(@PathVariable String id) {
        try {
            productoService.borrarProducto(id);
            return new ResponseEntity<>("Producto borrado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al borrar el producto: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
