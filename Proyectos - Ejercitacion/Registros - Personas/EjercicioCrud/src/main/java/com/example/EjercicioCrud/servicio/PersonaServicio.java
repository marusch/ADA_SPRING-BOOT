package com.example.EjercicioCrud.servicio;

import com.example.EjercicioCrud.entidad.Persona;
import java.util.List;

public interface PersonaServicio {

    public List<Persona> listarTodosLasPersonas();

    public Persona guardarPersona(Persona persona);

    public Persona obtenerPersonaPorId(Integer Id);

    public Persona actualizarPersona(Persona persona);

    public void eliminarPersona(Integer Id);


}
