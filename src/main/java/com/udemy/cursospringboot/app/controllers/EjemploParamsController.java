package com.udemy.cursospringboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

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

    @GetMapping("/mix-params")
    public String mixParam(@RequestParam String saludo , @RequestParam Integer numeroVeces, Model model){
        //si se omite el nombre queda igual en la peticion
        String resultado = "El saludo enviado es: '" + saludo + "' y el numero enviado es: '" + numeroVeces + "'";
        model.addAttribute("resultado", resultado);
        return "params/ver";
    }

    //obtencion de los paramtros del request mediante la clase httpServletRequest en lugar de anotaciones
    @GetMapping("/mix-params-request")
    public String mixParam(HttpServletRequest request, Model model){
        //los parametros se pueden obtener a traves del objeto request
        int numeroVeces;
        String saludo = request.getParameter("saludo");
        try {
            numeroVeces = Integer.parseInt(request.getParameter("numeroVeces"));
        } catch (NumberFormatException ex){
            numeroVeces = 0;
        }
        String resultado = "El saludo enviado es: '" + saludo + "' y el numero enviado es: '" + numeroVeces + "'";
        model.addAttribute("resultado", resultado);
        return "params/ver";
    }
}
