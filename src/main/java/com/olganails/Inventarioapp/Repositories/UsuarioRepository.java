package com.olganails.Inventarioapp.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.olganails.Inventarioapp.Models.UsuarioModel;

public interface UsuarioRepository extends MongoRepository<UsuarioModel, String>{
    UsuarioModel findByUsername(String username);
}
