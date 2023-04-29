package com.example.proyectorisar2.Model.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyectorisar2.Model.DAO.IPermisosDAO;
import com.example.proyectorisar2.Model.Entidad.Permiso;

@Service
public class PermisoServiceImp implements IPermisoService{

    @Autowired
    private IPermisosDAO permisosDAO;

    @Override
    public void guardarPermiso(Permiso permiso) {

        permisosDAO.save(permiso);
        
    }

    @Override
    public List<Permiso> cargarPermiso() {
        

        return (List<Permiso>)permisosDAO.findAll();
        
    }

    @Override
    public Permiso buscarCarnet(Long id) {
        return permisosDAO.findById(id).orElse(null);
    }
    
}
