package com.example.EjercicioCrud.repositorio;


import com.example.EjercicioCrud.entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
    
    public Usuario findByEmail(String email);
    
}
