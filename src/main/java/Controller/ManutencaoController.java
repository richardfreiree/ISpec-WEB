package Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import Entities.Manutencao;
import Service.ManutencaoService;

@Controller
@RequestMapping("/manutencoes")
public class ManutencaoController {
    private final ManutencaoService service;

    public ManutencaoController(ManutencaoService service){
        this.service = service;
    }

    @GetMapping
    public List<Manutencao> listar(){
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Manutencao buscar(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PostMapping
    public Manutencao salvar(@RequestBody Manutencao manutencao){
        return service.salvar(manutencao);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}
