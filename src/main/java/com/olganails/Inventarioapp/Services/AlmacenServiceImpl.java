package com.olganails.Inventarioapp.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

//import org.springframework.beans.factory.annotation.Autowired;

import com.olganails.Inventarioapp.Models.AlmacenModel;
import com.olganails.Inventarioapp.Repositories.AlmacenRepository;

@Service
public class AlmacenServiceImpl implements AlmacenService{

    AlmacenRepository almacenRepository;

    //@Autowired
    public AlmacenServiceImpl(AlmacenRepository almacenRepository) {
        this.almacenRepository = almacenRepository;
    }
    
    @Override
    public List<AlmacenModel> obtenerTodosAlmacenes() {
        return almacenRepository.findAll();
    }

    @Override
    public Optional<AlmacenModel> obtenerAlmacenPorId(String id) {
        return almacenRepository.findById(id);
    }

    @Override
    public void crearAlmacen(AlmacenModel almacenModel) {
        almacenRepository.save(almacenModel);
    }

    @Override
    public void actualizarAlmacen(AlmacenModel almacenModel) {
        almacenRepository.save(almacenModel);
    }

    @Override
    public void borrarAlmacen(String id) {
        almacenRepository.deleteById(id);
    }
}
