package com.example.EjercicioCrud.repositorio;

import com.example.EjercicioCrud.entidad.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Declara la clase como Repositorio, donde extendera de JPARepository permitiendo acceder a los metodos del crud(Visualizar, Insertar, Editar, Eliminar)
//Deberemos pasarle la entidad "Persona" y  el tipo de dato que maneja su Primary Key (Id)
@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, Integer> {


}


