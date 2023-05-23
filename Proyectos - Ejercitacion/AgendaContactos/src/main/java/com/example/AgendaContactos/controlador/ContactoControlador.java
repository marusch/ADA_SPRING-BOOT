package com.example.AgendaContactos.controlador;

import com.example.AgendaContactos.entidad.Contacto;
import com.example.AgendaContactos.servicio.ContactoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ContactoControlador {

    @Autowired
    private ContactoServicio contactoServicio;

    @GetMapping("/")
    public String verPaginaDeInicio(Model modelo) {
        List<Contacto> contactos = contactoServicio.listarTodosLosContactos();

        modelo.addAttribute("contactos", contactos);
        return "index";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeRegistrarContacto(Model modelo) {
        modelo.addAttribute("contacto", new Contacto());
        return "nuevo";
    }

    @PostMapping("/save")
    public String guardarContacto(@Validated Contacto contacto,BindingResult bindingResult,
    RedirectAttributes redirect,Model modelo) {

        if(bindingResult.hasErrors()) {
            modelo.addAttribute("contacto", contacto);
            return "nuevo";
        }

        contactoServicio.guardarContacto(contacto);
        redirect.addFlashAttribute("msgExito", "El contacto ha" +
          " sido agregado con exito");

        return "redirect:/";
    }


    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditarContacto(@PathVariable Integer id,Model modelo) {
        Contacto contacto = contactoServicio.obtenerContactoPorId(id);
        modelo.addAttribute("contacto", contacto);
        return "editar";
    }

    @PostMapping("/editar/{id}")
    public String actualizarContacto(@PathVariable Integer id,@Validated Contacto contacto,
     BindingResult bindingResult,RedirectAttributes redirect,Model modelo) {

        Contacto contactoDB = contactoServicio.obtenerContactoPorId(id);

        if(bindingResult.hasErrors()) {
            modelo.addAttribute("contacto", contacto);
            return "editar";
        }

        contactoDB.setNombre(contacto.getNombre());
        contactoDB.setCelular(contacto.getCelular());
        contactoDB.setEmail(contacto.getEmail());
        contactoDB.setFechaNacimiento(contacto.getFechaNacimiento());

        contactoServicio.guardarContacto(contactoDB);

        redirect.addFlashAttribute("msgExito", "El contacto " +
       "ha sido actualizado correctamente");

        return "redirect:/";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarContacto(@PathVariable Integer id,RedirectAttributes redirect) {
        Contacto contacto = contactoServicio.obtenerContactoPorId(id);

        contactoServicio.Eliminar(contacto);

        redirect.addFlashAttribute("msgExito", "El contacto ha " +
          "sido eliminado correctamente");

        return "redirect:/";
    }

}

