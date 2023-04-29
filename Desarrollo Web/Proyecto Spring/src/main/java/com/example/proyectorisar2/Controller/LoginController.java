package com.example.proyectorisar2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    
    @RequestMapping("/LoginS")
    public String index(@RequestParam(value = "error", required = false) String error,Model model){
        if(error!=null){
            model.addAttribute("error","usuario o cantraseña incorrecta");
        }

        return"login";

    }
}
