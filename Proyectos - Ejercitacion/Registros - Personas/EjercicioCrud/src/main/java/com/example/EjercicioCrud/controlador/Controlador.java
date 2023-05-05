package com.example.EjercicioCrud.controlador;

import com.example.EjercicioCrud.entidad.Persona;
import com.example.EjercicioCrud.servicio.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class Controlador {

    @Autowired
    private PersonaServicio servicio;

    @GetMapping("/listar")
    public String listar(Model model){
        List<Persona> personas = servicio.listarTodosLasPersonas();

        model.addAttribute("personas", personas);
        return "index";
    }


    @GetMapping("/new")
    public String Agregar(Model model){
        Persona persona = new Persona();
        model.addAttribute("persona",persona);
        return "crear_persona";
    }

    @PostMapping("/save")
    public String Guardar(@ModelAttribute("estudiante") Persona persona){
        servicio.guardarPersona(persona);
        return "redirect:/listar";
    }

}
