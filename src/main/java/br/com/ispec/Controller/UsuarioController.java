package br.com.ispec.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import br.com.ispec.Entities.Usuario;
import br.com.ispec.Service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service){
        this.service = service;
    }

    @GetMapping
    public List<Usuario> listar(){
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PostMapping
    public Usuario salvar(@RequestBody Usuario usuario){
        return service.salvar(usuario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}
