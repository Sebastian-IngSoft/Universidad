package com.example.proyectorisar2.Model.Service;

import java.util.List;

import com.example.proyectorisar2.Model.Entidad.Solicitudes;

public interface ISolicitudesService {
    public void GuardarSolicitud(Solicitudes solicitudes);
    public List<Solicitudes> cargarSolicitudes();
    public List<Solicitudes> buscarSolicitudes(String nombre);

    public Solicitudes buscarSolicitud(Long id);
}
