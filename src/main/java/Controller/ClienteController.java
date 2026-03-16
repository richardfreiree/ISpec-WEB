package Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import Entities.Cliente;
import Entities.Equipamento;
import Service.ClienteService;
import Service.EquipamentoService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService service;
    private final EquipamentoService equipamentoService;

    public ClienteController(ClienteService service, EquipamentoService equipamentoService){
        this.service = service;
        this.equipamentoService = equipamentoService;
    }

    @GetMapping
    public List<Cliente> listar(){
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Cliente buscar(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PostMapping
    public Cliente criar(@RequestBody Cliente cliente){
        return service.salvar(cliente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }

    @GetMapping("/{id}/equipamentos")
    public List<Equipamento> equipamentosCliente(@PathVariable Long id) {
        return equipamentoService.listarPorCliente(id);
    }
}
