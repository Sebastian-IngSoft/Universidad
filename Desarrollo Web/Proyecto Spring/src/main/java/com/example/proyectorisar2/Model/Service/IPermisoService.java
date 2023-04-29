package com.example.proyectorisar2.Model.Service;

import java.util.List;

import com.example.proyectorisar2.Model.Entidad.Permiso;

public interface IPermisoService {

    public void guardarPermiso(Permiso permiso);

    public List<Permiso> cargarPermiso();

    public Permiso buscarCarnet( Long id);
        
    
    
}
