package br.com.ispec.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ispec.Entities.Cliente;
import br.com.ispec.Repository.ClienteRepository;

@Service
public class ClienteService {
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository){
        this.repository = repository;
    }

    public List<Cliente> listarTodos(){
        return repository.findAll();
    }

    public Cliente buscarPorId(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Cliente salvar(Cliente cliente){
        return repository.save(cliente);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
