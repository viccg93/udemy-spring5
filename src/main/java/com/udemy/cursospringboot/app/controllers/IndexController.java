package com.udemy.cursospringboot.app.controllers;

import com.udemy.cursospringboot.app.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller  //se encuentra anotada con component
@RequestMapping("/app") //ruta de nivel superior
public class IndexController {

    //aqui se definen los handlers

    @RequestMapping(value = {"/index", "/", "/home"}, method = RequestMethod.GET) //por defecto es de tipo get
    public String index(Model model){
        model.addAttribute("titulo","Hola Spring!");
        return "index";
    }

    @GetMapping("/perfil")
    public String perfil (Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("Vic");
        usuario.setApellido("CG");
        usuario.setEmail("yosoyironm4n@gmail.com");
        model.addAttribute("usuario",usuario);
        model.addAttribute("titulo","Perfil del usuario: ".concat(usuario.getNombre()));
        return "perfil";
    }

    @GetMapping("/listar")
    public String listar (Model model){
        /* List <Usuario> usuarios = new ArrayList<Usuario>();
        usuarios.add(new Usuario("vic","CG","vcg@email.com"));
        usuarios.add(new Usuario("alberto","briseño","abr@email.com"));
        usuarios.add(new Usuario("yuliana","vargas","yvr@email.com"));
        model.addAttribute("usuarios",usuarios); */
        model.addAttribute("titulo","Lista de usuarios");
        return "listar";
    }

    @ModelAttribute("usuarios") //Se vuelve accesible para todos los metodos del controlador
    public List<Usuario> poblarUsuarios (){
        List<Usuario> usuarios = Arrays.asList(new Usuario("yuliana","vargas","yvr@email.com"),
                new Usuario("alberto","briseño","abr@email.com"));
        return usuarios;
    }
}
