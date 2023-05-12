package com.example.RegistrosEstudiantes.repositorio;

import com.example.RegistrosEstudiantes.entidad.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepositorio extends JpaRepository<Estudiante, Long> {
}
