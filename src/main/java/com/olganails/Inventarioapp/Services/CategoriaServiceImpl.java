package com.olganails.Inventarioapp.Services;

import java.util.List;
import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olganails.Inventarioapp.Models.CategoriaModel;
import com.olganails.Inventarioapp.Repositories.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    CategoriaRepository categoriaRepository;

    //@Autowired
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<CategoriaModel> obtenerTodasCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<CategoriaModel> obtenerCategoriaPorId(String id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public void crearCategoria(CategoriaModel categoria) {
        categoriaRepository.save(categoria);
    }

    @Override
    public void actualizarCategoria(CategoriaModel categoria) {
        categoriaRepository.save(categoria);
    }

    @Override
    public void borrarCategoria(String id) {
        categoriaRepository.deleteById(id);
    }
    
}
