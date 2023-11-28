package com.olganails.Inventarioapp.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document(collection = "almacenes")
@Data
public class AlmacenModel {
    @Id
    private String id;

    private String nombre;
    private String descripcion;
}
