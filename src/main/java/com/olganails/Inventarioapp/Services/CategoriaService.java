package com.olganails.Inventarioapp.Services;

import java.util.List;
import java.util.Optional;

import com.olganails.Inventarioapp.Models.CategoriaModel;

public interface CategoriaService {
    List<CategoriaModel> obtenerTodasCategorias();
    Optional<CategoriaModel> obtenerCategoriaPorId(String id);
    void crearCategoria(CategoriaModel categoria);
    void actualizarCategoria(CategoriaModel categoria);
    void borrarCategoria(String id);
}
