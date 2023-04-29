package com.example.proyectorisar2.Model.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyectorisar2.Model.DAO.IAlturaDAO;
import com.example.proyectorisar2.Model.Entidad.Altura;


@Service
public class AlturaServiceImp  implements IAlturaService{

    @Autowired
    private IAlturaDAO alturaDAO;
    @Override
    public void guardar(Altura altura) {
        alturaDAO.save(altura);

        
    }

    @Override
    public List<Altura> cargarAltura() {
        return (List<Altura>)alturaDAO.findAll();
    }

    @Override
    public Altura buscarAltura(Long id) {
        return alturaDAO.findById(id).orElse(null);
    }
    
}
