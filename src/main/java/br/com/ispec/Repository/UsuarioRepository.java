package br.com.ispec.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ispec.Entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    
} 
