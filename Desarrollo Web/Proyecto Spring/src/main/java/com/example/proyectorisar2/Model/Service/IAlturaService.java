package com.example.proyectorisar2.Model.Service;

import java.util.List;

import com.example.proyectorisar2.Model.Entidad.Altura;

public interface IAlturaService {
    
    public void guardar(Altura altura);

    public List<Altura> cargarAltura();

    public Altura buscarAltura (Long id);
}
