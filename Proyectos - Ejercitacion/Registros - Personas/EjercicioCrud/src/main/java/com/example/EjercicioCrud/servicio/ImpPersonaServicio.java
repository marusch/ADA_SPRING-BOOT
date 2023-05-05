package com.example.EjercicioCrud.servicio;

import com.example.EjercicioCrud.entidad.Persona;
import com.example.EjercicioCrud.repositorio.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpPersonaServicio implements PersonaServicio {

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
        return null;
    }

    @Override
    public Persona actualizarPersona(Persona persona) {
        return null;
    }

    @Override
    public void eliminarPersona(Integer id) {

    }
}
