package com.example.proyectorisar2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class inicioController {
    @RequestMapping("/")
    public String Inicio(){
        return "Inicio";
    }
    @GetMapping("/Contactos")
    public String Contactos(){
        return"Contacto";
    }
    
    @GetMapping("/Login")
    public String log(){
        return"login";
    }
    @GetMapping("/SystemRisar")
    public String System(){
        return"WebSystem";
    }
}
