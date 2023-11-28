package com.olganails.Inventarioapp.Services;

import java.util.List;
import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.olganails.Inventarioapp.Models.UsuarioModel;
import com.olganails.Inventarioapp.Repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    UsuarioRepository usuarioRepository;
    //@Autowired
    PasswordEncoder passwordEncoder;

    //@Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UsuarioModel> obtenerTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<UsuarioModel> obtenerUsuarioPorId(String id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public void crearUsuario(UsuarioModel usuario) {
        // Hashear la contraseña antes de almacenarla en la base de datos
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioRepository.save(usuario);
    }

    @Override
    public void actualizarUsuario(UsuarioModel usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void borrarUsuario(String id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public boolean tienePermisoAccesoTotal(String username) {
        // Lógica para determinar si el usuario tiene acceso total
        UsuarioModel usuario = usuarioRepository.findByUsername(username);
        return usuario != null && usuario.getTipoUsuario().equals("ADMIN");
    }

    @Override
    public UsuarioModel findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
}
