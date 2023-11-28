package com.olganails.Inventarioapp.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.olganails.Inventarioapp.Models.AlmacenModel;

public interface AlmacenRepository extends MongoRepository<AlmacenModel, String>{
    
}
