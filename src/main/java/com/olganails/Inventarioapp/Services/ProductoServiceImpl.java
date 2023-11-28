package com.olganails.Inventarioapp.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

//import org.springframework.beans.factory.annotation.Autowired;

import com.olganails.Inventarioapp.Models.ProductoModel;
import com.olganails.Inventarioapp.Repositories.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{
    
    ProductoRepository productoRepository;

    //@Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<ProductoModel> obtenerTodosProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<ProductoModel> obtenerProductoPorId(String id) {
        return productoRepository.findById(id);
    }

    @Override
    public void crearProducto(ProductoModel producto) {
        productoRepository.save(producto);
    }

    @Override
    public void actualizarProducto(ProductoModel producto) {
        productoRepository.save(producto);
    }

    @Override
    public void borrarProducto(String id) {
        productoRepository.deleteById(id);
    }
}
