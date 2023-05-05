package com.example.EjercicioCrud.servicio;

import com.example.EjercicioCrud.entidad.Persona;
import java.util.List;

//Lista de metodos que vamos a utilizar para el crud, gracias a JPARepository la logica estara por detras y sera mas facil su aplicacion
public interface PersonaServicio {

    public List<Persona> listarTodosLasPersonas();

    public Persona guardarPersona(Persona persona);

    public Persona obtenerPersonaPorId(Integer Id);

    public Persona actualizarPersona(Persona persona);

    public void eliminarPersona(Integer Id);


}
