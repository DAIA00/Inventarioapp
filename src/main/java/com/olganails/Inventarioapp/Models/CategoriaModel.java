package com.olganails.Inventarioapp.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document(collection = "categorias")
@Data
public class CategoriaModel {
    @Id
    private String id;

    private String nombre;
    private String descripcion;
}
