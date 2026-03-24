package br.com.ispec.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import br.com.ispec.Entities.Inspecao;
import br.com.ispec.Service.InspecaoService;

@RestController
@RequestMapping("/inspecoes") 

public class InspecaoController {
    private final InspecaoService service; 

    public InspecaoController(InspecaoService service){
        this.service = service;
    }

    @GetMapping
    public List<Inspecao> listar(){
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Inspecao buscar(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PostMapping
    public Inspecao salvar(@RequestBody Inspecao inspecao){
        return service.salvar(inspecao);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}
