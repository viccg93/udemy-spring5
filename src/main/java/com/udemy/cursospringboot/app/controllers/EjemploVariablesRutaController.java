package com.udemy.cursospringboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {

    @GetMapping("/")
    public String index(Model modelo){
        modelo.addAttribute("titulo","multiples variables desde el path");
        return "variables/index";
    }

    @GetMapping("/string/{texto}")
    public String variables(@PathVariable String texto, Model modelo){
        modelo.addAttribute("titulo", "Recibir parametros de la ruta de la URL");
        modelo.addAttribute("resultado", "Parametro enviado a traves de la ruta:" + texto);
        return "variables/ver";
    }

    @GetMapping("/string/{texto1}/{texto2}")
    public String variablesMultiples(@PathVariable String texto1, @PathVariable String texto2, Model modelo){
        modelo.addAttribute("titulo", "Recibir parametros de la ruta de la URL");
        modelo.addAttribute("resultado", "Parametro enviado a traves de la ruta:" + texto1 + " y " + texto2);
        return "variables/ver";
    }
}
