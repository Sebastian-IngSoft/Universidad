package com.example.proyectorisar2.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.proyectorisar2.Model.Entidad.Altura;
import com.example.proyectorisar2.Model.Entidad.Carnet;
import com.example.proyectorisar2.Model.Entidad.Permiso;
import com.example.proyectorisar2.Model.Service.IAlturaService;
import com.example.proyectorisar2.Model.Service.ICarnetService;
import com.example.proyectorisar2.Model.Service.IPermisoService;
import com.example.proyectorisar2.Model.Service.IUsuariosService;

@Controller
@RequestMapping("/Formularios")
public class FormulariosController {
    @Autowired
    private ICarnetService carnetService;

    @Autowired
    private IUsuariosService usuariosService;

    @Autowired
    private IAlturaService alturaService;

    @Autowired
    private IPermisoService permisoService;

    @RequestMapping("/")
    public String Inicio(){
        return"Formularios/Index";
    } 


    //vista carnet
    @RequestMapping("/carnet")
    public String carnet(Model model){
        Carnet carnet = new Carnet();
        model.addAttribute("carnet", carnet);
        model.addAttribute("listaUsuarios", usuariosService.cargarUsuarios());
        

        return "Formularios/FormularioCarnet";
    }

    @RequestMapping(value = "/form",method = RequestMethod.POST)
    public String guardar(@Valid Carnet carnet,BindingResult result,RedirectAttributes flash, Model model){
        if(result.hasErrors()){
            model.addAttribute("listaUsuarios", usuariosService.cargarUsuarios());

            return "Formularios/FormularioCarnet";

        }
        carnetService.guardarCarnet(carnet);
        return "redirect:/Formularios/";
    }


    //vista de trabajo en altura

    @RequestMapping("/altura")
    public String altura(Model model){
        Altura altura= new Altura();
        model.addAttribute("altura", altura);
        model.addAttribute("listaUsuarios", usuariosService.cargarUsuarios());
        return "Formularios/FormularioAltura";
    }

    @RequestMapping(value = "/formA",method = RequestMethod.POST)
    public String guardarA(@Valid Altura altura,BindingResult result,Model model,RedirectAttributes flash){
        if(result.hasErrors()){
            model.addAttribute("listaUsuarios", usuariosService.cargarUsuarios());
            
            return "Formularios/FormularioAltura";
        }

        alturaService.guardar(altura);
        return "redirect:/Formularios/";

        
    }

    //visata de permisos de ingreso
    @RequestMapping("/ingreso")
    public String ingreso(Model model){
        Permiso permiso = new Permiso();
        model.addAttribute("permiso", permiso);
        model.addAttribute("listaUsuarios",usuariosService.cargarUsuarios());

        return "Formularios/FormularioPermiso";
    }

    @RequestMapping(value = "/formP" ,method = RequestMethod.POST)
    public String guardar(@Valid Permiso permiso,BindingResult result, RedirectAttributes flash,Model model){

        if(result.hasErrors()){
        model.addAttribute("listaUsuarios",usuariosService.cargarUsuarios());
        return "Formularios/FormularioPermiso";



        }
        permisoService.guardarPermiso(permiso);
        return "redirect:/Formularios/";
    }




}
