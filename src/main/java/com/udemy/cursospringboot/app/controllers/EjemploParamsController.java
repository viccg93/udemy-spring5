package com.udemy.cursospringboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

    @GetMapping("/")
    public String index(){
        return "params/index";
    }
    @GetMapping("/string")
    public String param(@RequestParam(name = "text", required = false, defaultValue = "algun valor...") String text, Model model){
        //la anotacion permite asignar el nombre que utilizara en la peticion y si es requerido
        String resultado = "El texto enviado es: " + text;
        model.addAttribute("resultado", resultado);
        return "params/ver";
    }
}
