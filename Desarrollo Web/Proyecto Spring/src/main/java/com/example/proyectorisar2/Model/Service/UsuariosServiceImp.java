package com.example.proyectorisar2.Model.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyectorisar2.Model.DAO.IUsuariosDAO;
import com.example.proyectorisar2.Model.Entidad.Usuarios;

@Service
public class UsuariosServiceImp implements IUsuariosService {

    @Autowired
    private IUsuariosDAO usuariosDAO;
    @Override
    public void guardarUsuario(Usuarios usuarios) {
        usuariosDAO.save(usuarios);
        
    }

    @Override
    public List<Usuarios> cargarUsuarios() {


        return (List<Usuarios>)usuariosDAO.findAll();
    }

    @Override
    public Usuarios bucarUsuario(Long id) {
        return usuariosDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuariosDAO.deleteById(id);
        
    }

    @Override
    public List<Usuarios> buscar(String nombre) {
        
    
        return null;
    }
    
}
