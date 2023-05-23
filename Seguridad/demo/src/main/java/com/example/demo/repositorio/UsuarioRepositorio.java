package com.example.demo.repositorio;

import com.example.demo.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
    
    public Usuario findByEmail(String email);
    
}
