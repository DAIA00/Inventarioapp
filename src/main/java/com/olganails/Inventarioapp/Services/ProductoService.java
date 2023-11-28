package com.olganails.Inventarioapp.Services;

import java.util.List;
import java.util.Optional;

import com.olganails.Inventarioapp.Models.ProductoModel;

public interface ProductoService {
    List<ProductoModel> obtenerTodosProductos();
    Optional<ProductoModel> obtenerProductoPorId(String id);
    void crearProducto(ProductoModel producto);
    void actualizarProducto(ProductoModel producto);
    void borrarProducto(String id);
}
