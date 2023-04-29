package com.example.proyectorisar2.Model.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.proyectorisar2.Model.Entidad.Solicitudes;

public interface ISolicitudesDAO extends CrudRepository<Solicitudes,Long>{


    @Query(value = "SELECT * FROM solicitudes WHERE Nombre like ?1",nativeQuery = true)
    public List<Solicitudes> buscarSolicitudes(String nombre);
    
}
