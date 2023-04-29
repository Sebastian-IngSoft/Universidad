package com.example.proyectorisar2.Model.Service;

import java.util.List;

import com.example.proyectorisar2.Model.Entidad.Carnet;

public interface ICarnetService {

    public String guardarCarnet(Carnet carnet);

    public List<Carnet> cargarCarnet();

    public Carnet buscarCarnet(Long id);
    
}
