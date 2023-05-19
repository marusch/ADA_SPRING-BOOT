
package com.example.demo.servicio;

import com.example.demo.dto.UsuarioRegistroDTO;
import com.example.demo.modelo.Usuario;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioServicio {
    
    public Usuario guardar(UsuarioRegistroDTO registroDTO);
    
  //  public List<Usuario> listarUsuarios();

}
