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

//Declara la clase como un controlador
@Controller
public class Controlador {

//Permite una inyeccion de metodos para su implementacion
    @Autowired
    private PersonaServicio servicio;

    //Trae la lista de personas registradas en el html denominado "index"
    @GetMapping("/listar")
    public String listar(Model model){
        List<Persona> personas = servicio.listarTodosLasPersonas();

        model.addAttribute("personas", personas);
        return "index";
    }


   //Direcciona a un nuevo formulario denominado "crear_persona"
    @GetMapping("/new")
    public String Agregar(Model model){
        Persona persona = new Persona();
        model.addAttribute("persona",persona);
        return "crear_persona";
    }


    //Permite enviar o guardar a la BD "registros" los datos que se completo en el formulario
    @PostMapping("/save")
    public String Guardar(@ModelAttribute("estudiante") Persona persona){
        servicio.guardarPersona(persona);
        return "redirect:/listar";
    }

}
