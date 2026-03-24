package br.com.ispec.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ispec.Entities.Inspecao;
import br.com.ispec.Repository.InspecaoRepository;

@Service
public class InspecaoService {
    private final InspecaoRepository repository;

    public InspecaoService(InspecaoRepository repository) {
        this.repository = repository;
    }

    public List<Inspecao> listarTodas() {
        return repository.findAll();
    }

    public Inspecao buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inspeção não encontrada"));
    }

    public Inspecao salvar(Inspecao inspecao) {
        return repository.save(inspecao);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public List<Inspecao> listarPorEquipamento(Long equipamentoId) {
        return repository.findByEquipamento_Id(equipamentoId);
    }
}
