package com.olganails.Inventarioapp.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.olganails.Inventarioapp.Models.CategoriaModel;

public interface CategoriaRepository extends MongoRepository<CategoriaModel, String>{
    
}
