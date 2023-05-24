
package com.example.EjercicioCrud.servicio;


import java.util.List;

import com.example.EjercicioCrud.dto.UsuarioRegistroDTO;
import com.example.EjercicioCrud.entidad.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioServicio extends UserDetailsService{
    
    public Usuario guardar(UsuarioRegistroDTO registroDTO);
    
    public List<Usuario> listarUsuarios();

}
