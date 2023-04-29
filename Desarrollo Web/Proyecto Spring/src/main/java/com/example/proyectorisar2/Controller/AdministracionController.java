package com.example.proyectorisar2.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.proyectorisar2.Model.Entidad.Usuarios;
import com.example.proyectorisar2.Model.Service.IUsuariosService;

@Controller
@RequestMapping("/Administracion")
public class AdministracionController {

    @Autowired
    private IUsuariosService usuariosService;

    @RequestMapping("/")
    public String inicio(Model model){
        Usuarios objUsuarios = new Usuarios();
        model.addAttribute("Usuarios", objUsuarios);
        model.addAttribute("listausuarios", usuariosService.cargarUsuarios());
        return "Administracion/Index";
    }

    /* 
    @RequestMapping(value = "/form",method = RequestMethod.POST)
    public String guardarASD(@Valid Usuarios usuarios,BindingResult result,Model model){
        if(result.hasErrors()){

            model.addAttribute("listausuarios", usuariosService.cargarUsuarios());
            return "Administracion/Index";


        }


        usuariosService.guardarUsuario(usuarios);
        return"redirect:/Administracion/";

    }
    */
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid Usuarios usuarios,BindingResult result, Model model){

        if(result.hasErrors()){
            
            Usuarios objUsuarios = new Usuarios();
            model.addAttribute("Usuarios", objUsuarios);
            model.addAttribute("listausuarios", usuariosService.cargarUsuarios());
            model.addAttribute("Obligatorio","CAMPOS OBLIGATORIOS");
            return "Administracion/Index";

        }
        usuariosService.guardarUsuario(usuarios);

        return "redirect:/Administracion/";


    }

    @RequestMapping("/editar/{id}")
    public String editar(@PathVariable(value = "id") Long id,Model model){
        Usuarios obUsuarios= usuariosService.bucarUsuario(id);
        model.addAttribute("Usuarios", obUsuarios);
        model.addAttribute("listausuarios", usuariosService.cargarUsuarios());
        return"Administracion/Index";
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id")Long id){
        usuariosService.eliminarUsuario(id);
        return "redirect:/Administracion/";
    }


    
}
