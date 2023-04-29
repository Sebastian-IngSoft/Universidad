package com.example.proyectorisar2.Model.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyectorisar2.Model.DAO.ISolicitudesDAO;
import com.example.proyectorisar2.Model.Entidad.Solicitudes;

@Service
public class SolicitudesServiceImp implements ISolicitudesService{

    @Autowired
    private ISolicitudesDAO solicitudesDAO;

    @Override
    public void GuardarSolicitud(Solicitudes solicitudes) {
        // guarda la solicitud
        solicitudesDAO.save(solicitudes);
        
    }

    @Override
    public List<Solicitudes> cargarSolicitudes() {
        // lista las solicitudes
        return (List<Solicitudes>)solicitudesDAO.findAll();
    }

    @Override
    public Solicitudes buscarSolicitud(Long id) {
        // para la vista de ver
        return solicitudesDAO.findById(id).orElse(null);
    }

    @Override
    public List<Solicitudes> buscarSolicitudes(String nombre) {
        // TODO Auto-generated method stub

        return solicitudesDAO.buscarSolicitudes(nombre);
    }
    
}
