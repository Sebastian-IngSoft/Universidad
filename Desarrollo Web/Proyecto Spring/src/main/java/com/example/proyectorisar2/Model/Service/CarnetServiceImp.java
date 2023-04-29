package com.example.proyectorisar2.Model.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyectorisar2.Model.DAO.ICarnetDAO;
import com.example.proyectorisar2.Model.Entidad.Carnet;

@Service
public class CarnetServiceImp implements ICarnetService{
    @Autowired
    private ICarnetDAO carnetDAO;

    @Override
    public String guardarCarnet(Carnet carnet) {
        carnetDAO.save(carnet);
        return "";
    }

    @Override
    public List<Carnet> cargarCarnet() {
        return (List<Carnet>)carnetDAO.findAll();
    }

    @Override
    public Carnet buscarCarnet(Long id) {
        return carnetDAO.findById(id).orElse(null);
    }
    
    
}
