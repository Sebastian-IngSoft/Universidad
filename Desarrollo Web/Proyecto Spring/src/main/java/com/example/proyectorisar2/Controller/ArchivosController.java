package com.example.proyectorisar2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.proyectorisar2.Model.Entidad.Altura;
import com.example.proyectorisar2.Model.Entidad.Carnet;
import com.example.proyectorisar2.Model.Entidad.Permiso;
import com.example.proyectorisar2.Model.Service.IAlturaService;
import com.example.proyectorisar2.Model.Service.ICarnetService;
import com.example.proyectorisar2.Model.Service.IPermisoService;

@Controller
@RequestMapping("/Archivos")
public class ArchivosController {
    @Autowired
    private IPermisoService permisoService;
    @Autowired
    private ICarnetService carnetService;
    @Autowired
    private IAlturaService alturaService;

    @RequestMapping("/")
    public String inicio(Model model){
        model.addAttribute("lista", carnetService.cargarCarnet());
        return "Archivos/Index";
    }

    @RequestMapping("/P")
    public String inicioP(Model model){
        model.addAttribute("lista", permisoService.cargarPermiso());
        return"Archivos/IndexP";

    }
    @RequestMapping("/A")
    public String inicioA(Model model){
        model.addAttribute("lista", alturaService.cargarAltura());
        return"Archivos/IndexA";

    }

    //Ver Carnet

    @RequestMapping("/VerCarnet/{id}")
    public String VerC(@PathVariable(value="id") Long id, Model model){
        Carnet objCarnet = carnetService.buscarCarnet(id);
        model.addAttribute("carnet", objCarnet);
        return "Archivos/Carnet";

    }

    //Ver PERMISO DE INGRESO
    @RequestMapping("/VerPermisoI/{id}")
    public String VerI(@PathVariable(value="id") Long id, Model model){
        //el buscar solo esta mal en el bombre
        Permiso objPermiso = permisoService.buscarCarnet(id);
        model.addAttribute("permiso", objPermiso);
        return "Archivos/PIngreso";
    }

    //Ver Permiso de trabjo en altura
    @RequestMapping("/VerPermisoA/{id}")

    public String VerA(@PathVariable(value="id") Long id, Model model){
        //el buscar solo esta mal en el bombre
        Altura objAltura = alturaService.buscarAltura(id);
        model.addAttribute("altura",objAltura);
        return "Archivos/PAltura";
    }



}
