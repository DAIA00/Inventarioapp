package com.olganails.Inventarioapp.Services;

import java.util.List;
import java.util.Optional;

import com.olganails.Inventarioapp.Models.AlmacenModel;

public interface AlmacenService {
    List <AlmacenModel> obtenerTodosAlmacenes();
    Optional<AlmacenModel> obtenerAlmacenPorId(String id);
    void crearAlmacen(AlmacenModel almacenModel);
    void actualizarAlmacen(AlmacenModel almacenModel);
    void borrarAlmacen(String id);
}
