package com.olganails.Inventarioapp.Models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@Document(collection = "productos")
@Data
public class ProductoModel {
    @Id
    private String id;

    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private int cantidadEnInventario;
    private LocalDateTime fechaIngreso;
}
