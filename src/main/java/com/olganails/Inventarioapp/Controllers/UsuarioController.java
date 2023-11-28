package com.olganails.Inventarioapp.Controllers;

import java.util.List;
import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.olganails.Inventarioapp.Models.UsuarioModel;
import com.olganails.Inventarioapp.Services.UsuarioService;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    UsuarioService usuarioService;

    //@Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<UsuarioModel> obtenerTodosUsuarios() {
        return usuarioService.obtenerTodosUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> obtenerUsuarioPorId(@PathVariable String id) {
        Optional<UsuarioModel> usuario = usuarioService.obtenerUsuarioPorId(id);
        return usuario.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<String> crearUsuario(@RequestBody UsuarioModel nuevoUsuario) {
        try {
            usuarioService.crearUsuario(nuevoUsuario);
            return new ResponseEntity<>("Usuario creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el usuario: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarUsuario(@PathVariable String id, @RequestBody UsuarioModel usuarioActualizado) {
        Optional<UsuarioModel> usuarioExistente = usuarioService.obtenerUsuarioPorId(id);
        if (usuarioExistente.isPresent()) {
            usuarioActualizado.setId(id);
            usuarioService.actualizarUsuario(usuarioActualizado);
            return new ResponseEntity<>("Usuario actualizado exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se encontró el usuario con ID: " + id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarUsuario(@PathVariable String id) {
        try {
            usuarioService.borrarUsuario(id);
            return new ResponseEntity<>("Usuario borrado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al borrar el usuario: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
