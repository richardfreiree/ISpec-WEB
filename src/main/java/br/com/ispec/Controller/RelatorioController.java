package br.com.ispec.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ispec.Entities.Inspecao;
import br.com.ispec.Entities.Manutencao;
import br.com.ispec.Service.RelatorioService;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/relatorios")

public class RelatorioController {
    private final RelatorioService service;

    public RelatorioController(RelatorioService service){
        this.service = service;
    }

    @GetMapping("/cliente/{id}")
    public List<Inspecao> relatorioCliente(@PathVariable Long id){
        return service.relatorioPorCliente(id);
    }

    @GetMapping("/usuario/{id}")
    public List<Inspecao> relatorioUsuario(@PathVariable Long id){
        return service.relatorioPorUsuario(id);
    }

    @GetMapping("/localizacao/{id}")
    public List<Inspecao> relatorioLocalizacao(@PathVariable Long id){
        return service.relatorioPorLocalizacao(id);
    }

    @GetMapping("/manutencoes/tecnico/{id}")
    public List<Manutencao> manutencoesTecnico(@PathVariable Long id){
        return service.manutencoesPorTecnico(id);
    }
}
