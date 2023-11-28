package com.olganails.Inventarioapp.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olganails.Inventarioapp.Models.AlmacenModel;
import com.olganails.Inventarioapp.Services.AlmacenService;
//import com.olganails.Inventarioapp.Services.AlmacenServiceImpl;

@RestController
@RequestMapping(path = "/almacenes")
public class AlmacenController {

    //@Autowired
    AlmacenService almacenService;

    //@Autowired
    public AlmacenController(AlmacenService almacenService) {
        this.almacenService = almacenService;
    }

    @GetMapping()
    public List<AlmacenModel> getAllAlmacenes(){
        return almacenService.obtenerTodosAlmacenes();
    }

    /*@GetMapping("/prueba")
    public String primeraPrueba(){
        return "Hola Crios";
    }*/


    @GetMapping("/{id}")
    public ResponseEntity<AlmacenModel> obtenerAlmacenPorId(@PathVariable String id) {
        Optional<AlmacenModel> almacen = almacenService.obtenerAlmacenPorId(id);
        return almacen.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<String> saveAlmacen(@RequestBody AlmacenModel nuevoAlmacen) {
        try {
            almacenService.crearAlmacen(nuevoAlmacen);
            return new ResponseEntity<>("Almacen creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el almacen: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarAlmacen(@PathVariable String id, @RequestBody AlmacenModel almacenActualizado) {
        Optional<AlmacenModel> almacenExistente = almacenService.obtenerAlmacenPorId(id);
        if (almacenExistente.isPresent()) {
            almacenActualizado.setId(id);
            almacenService.actualizarAlmacen(almacenActualizado);
            return new ResponseEntity<>("Almacen actualizado exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se encontró el almacen con ID: " + id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarAlmacen(@PathVariable String id) {
        try {
            almacenService.borrarAlmacen(id);
            return new ResponseEntity<>("Almacen borrado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al borrar el almacen: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
