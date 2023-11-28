package com.olganails.Inventarioapp.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.olganails.Inventarioapp.Models.ProductoModel;

public interface ProductoRepository extends MongoRepository<ProductoModel, String>{
    
}
