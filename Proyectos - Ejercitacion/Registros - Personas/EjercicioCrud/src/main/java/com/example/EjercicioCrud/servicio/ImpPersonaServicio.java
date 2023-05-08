package com.example.EjercicioCrud.servicio;

import com.example.EjercicioCrud.entidad.Persona;
import com.example.EjercicioCrud.repositorio.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Implementacion de los metodos de la clase Interfaz "Persona Servicio"
//Declaramos nuestra clase como servicio
@Service
public class ImpPersonaServicio implements PersonaServicio {

//Hacemos una inyección de la clase PersonaRepositorio para ocupar los metodos que nos proporciona JPA(crud)
    @Autowired
    private PersonaRepositorio personaRepositorio;

    @Override
    public List<Persona> listarTodosLasPersonas() {
        return personaRepositorio.findAll();
    }

    @Override
    public Persona guardarPersona(Persona persona) {

        return personaRepositorio.save(persona);
    }

    @Override
    public Persona obtenerPersonaPorId(Integer id) {
         return personaRepositorio.findById(id).get();
    }

    @Override
    public Persona actualizarPersona(Persona persona) {
        return personaRepositorio.save(persona);
    }

    @Override
    public void eliminarPersona(Integer id) {
        personaRepositorio.deleteById(id);
    }

}
