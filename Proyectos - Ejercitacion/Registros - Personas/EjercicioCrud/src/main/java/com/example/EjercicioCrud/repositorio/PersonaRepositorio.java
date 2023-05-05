package com.example.EjercicioCrud.repositorio;

import com.example.EjercicioCrud.entidad.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, Integer> {


}


