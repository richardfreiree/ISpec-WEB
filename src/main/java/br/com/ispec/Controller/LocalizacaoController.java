package br.com.ispec.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import br.com.ispec.Entities.Equipamento;
import br.com.ispec.Entities.Localizacao;
import br.com.ispec.Service.LocalizacaoService;
import br.com.ispec.Service.EquipamentoService;

public class LocalizacaoController {
    private final LocalizacaoService service;
    private final EquipamentoService equipamentoService;

    public LocalizacaoController(LocalizacaoService service, EquipamentoService equipamentoService){
        this.service = service;
        this.equipamentoService = equipamentoService;
    }

    // LISTAR TODAS AS LOCALIZAÇÕES
    @GetMapping
    public List<Localizacao> listar(){
        return service.listarTodas();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public Localizacao buscar(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    // CRIAR LOCALIZAÇÃO
    @PostMapping
    public Localizacao salvar(@RequestBody Localizacao localizacao){
        return service.salvar(localizacao);
    }

    // ATUALIZAR LOCALIZAÇÃO
    @PutMapping("/{id}")
    public Localizacao atualizar(@PathVariable Long id,
                                 @RequestBody Localizacao localizacao){
        return service.atualizar(id, localizacao);
    }

    // DELETAR LOCALIZAÇÃO
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
    //FILTRAR EQUIPAMENTOS POR LOCALIZAÇÃO
    @GetMapping("/{id}/equipamentos")
        public List<Equipamento> equipamentosPorLocalizacao(@PathVariable Long id){
        return equipamentoService.listarPorLocalizacao(id);
    }
}
