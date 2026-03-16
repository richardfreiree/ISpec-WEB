package Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import Entities.Inspecao;
import Service.InspecaoService;

@Controller
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
