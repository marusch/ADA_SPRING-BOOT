package com.example.RegistrosEstudiantes.servicio;

import com.example.RegistrosEstudiantes.entidad.Estudiante;

import java.util.List;

public interface EstudianteServicio {

    public List<Estudiante> listarTodosLosEstudiantes();

    public Estudiante guardarEstudiante(Estudiante estudiante);

    public Estudiante obtenerEstudiantePorId(Long id);

    public Estudiante actualizarEstudiante(Estudiante estudiante);

    public void eliminarEstudiante(Long id);
}
