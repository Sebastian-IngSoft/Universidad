package com.example.proyectorisar2.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.proyectorisar2.Model.Entidad.Solicitudes;
import com.example.proyectorisar2.Model.Service.ISolicitudesService;

@Controller
@RequestMapping("/Solicitudes")
public class SolicitudesController {
    @Autowired
    private ISolicitudesService solicitudesService;

    @RequestMapping("/")
    public String Inicio(Model model){

        Solicitudes objSolicitudes = new Solicitudes();
        model.addAttribute("solicitudes",objSolicitudes);
        return"Contacto";
    }

    @RequestMapping(value = "/form",method = RequestMethod.POST)
    public String guardar(@Valid Solicitudes solicitudes,BindingResult result, Model model,RedirectAttributes flash){
        
        if(result.hasErrors()){
            return "Contacto";
        }
        
        solicitudesService.GuardarSolicitud(solicitudes);
        return"redirect:/Solicitudes/";

    }
    @RequestMapping("/VerSolicitudes")
    public String InicioSys(Model model){
        Solicitudes objSolicitudes= new Solicitudes();
        model.addAttribute("Solicitudes", objSolicitudes);
        model.addAttribute("listaSolicitudes", solicitudesService.cargarSolicitudes());

        return"Solicitudes/Index";

    }
    @RequestMapping("/Ver/{id}")
    public String Ver(@PathVariable(value="id") Long id, Model model){
        Solicitudes objSolicitudes = solicitudesService.buscarSolicitud(id);
        model.addAttribute("solicitudes",objSolicitudes);
        return"Solicitudes/Solicitud";
    }


    //Filtrar
    @RequestMapping(value = "/buscarSolicitud", method = RequestMethod.POST)

    public String buscar(String nombre,Model model){
        model.addAttribute("listaSolicitudes", solicitudesService.buscarSolicitudes("%"+nombre+"%"));
        return"Solicitudes/Index";
    }

}
