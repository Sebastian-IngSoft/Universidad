package com.example.proyectorisar2.Model.Service;

import java.util.List;

import com.example.proyectorisar2.Model.Entidad.Usuarios;

public interface IUsuariosService {

    public void guardarUsuario( Usuarios usuarios);
    public List<Usuarios> cargarUsuarios();
    public Usuarios bucarUsuario(Long id);
    public void eliminarUsuario(Long id);
    public List<Usuarios> buscar(String nombre);
    
    
}
