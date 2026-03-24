package br.com.ispec.Service;

import br.com.ispec.Entities.Manutencao;
import br.com.ispec.Repository.ManutencaoRepository;
import java.util.*;

public class ManutencaoService {
    private final ManutencaoRepository repository;

    public ManutencaoService(ManutencaoRepository repository) {
        this.repository = repository;
    }

    public List<Manutencao> listarTodas() {
        return repository.findAll();
    }

    public Manutencao buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manutenção não encontrada"));
    }

    public Manutencao salvar(Manutencao manutencao) {
        return repository.save(manutencao);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public List<Manutencao> listarPorEquipamento(Long equipamentoId) {
        return repository.findByEquipamento_Id(equipamentoId);
    }
}
