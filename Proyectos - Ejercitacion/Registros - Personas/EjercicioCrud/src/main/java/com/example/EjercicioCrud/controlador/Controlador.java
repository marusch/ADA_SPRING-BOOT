package com.example.EjercicioCrud.controlador;

import com.example.EjercicioCrud.entidad.Persona;
import com.example.EjercicioCrud.servicio.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import java.util.Optional;

//Declara la clase como un controlador
@Controller
public class Controlador {

//Permite una inyeccion de metodos para su implementacion
    @Autowired
    private PersonaServicio servicio;

    //Pagina de inicio
    @GetMapping("/")
    public String home(){
        return "home";
    }

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
    public String Guardar(@ModelAttribute("persona") Persona persona){
        servicio.guardarPersona(persona);
        return "redirect:/listar";
    }

    //Direcciona a un nuevo formulario denominado "editar_persona"
    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Integer id, Model model){

        model.addAttribute("persona", servicio.obtenerPersonaPorId(id));

        return "editar_persona";
    }

    //Permite enviar o guardar a la BD "registros" actualizados
    @PostMapping("/editar/{id}")
    public String actualizarPersona(@PathVariable Integer id, @ModelAttribute("persona")
    Persona persona, Model model){

        Persona personaExistente = servicio.obtenerPersonaPorId(id);

        personaExistente.setId(id);
        personaExistente.setNombre(persona.getNombre());
        personaExistente.setTelefono(persona.getTelefono());

        servicio.actualizarPersona(personaExistente);

        return "redirect:/listar";
    }

    //Permite eliminar los registros con los botones
    @GetMapping("/eliminar/{id}")
    public String eliminarPersona(@PathVariable Integer id) {
        servicio.eliminarPersona(id);
        return "redirect:/listar";
    }

}
