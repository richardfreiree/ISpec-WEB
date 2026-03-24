package br.com.ispec.Service;

import java.util.List;

import br.com.ispec.Entities.Usuario;
import br.com.ispec.Repository.UsuarioRepository;

public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository){
        this.repository = repository;
    }

    public List<Usuario> listarTodos(){
        return repository.findAll();
    }

    public Usuario buscarPorId(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public Usuario salvar(Usuario usuario){
        return repository.save(usuario);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
