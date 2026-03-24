package br.com.ispec.Service;

import br.com.ispec.Repository.EquipamentoRepository;
import br.com.ispec.Entities.Equipamento;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class EquipamentoService {
    private final EquipamentoRepository repository;

    public EquipamentoService(EquipamentoRepository repository) {
        this.repository = repository;
    }

    // LISTAR
    public List<Equipamento> listarTodos() {
        return repository.findAll();
    }

    // BUSCAR
    public Equipamento buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));
    }

    // SALVAR
    public Equipamento salvar(Equipamento equipamento) {
        return repository.save(equipamento);
    }

    // ATUALIZAR
    public Equipamento atualizar(Long id, Equipamento equipamentoAtualizado) {

        Equipamento equipamento = buscarPorId(id);

        equipamento.setNome(equipamentoAtualizado.getNome());
        equipamento.setStatus(equipamentoAtualizado.getStatus());

        return repository.save(equipamento);
    }

    // DELETAR
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public List<Equipamento> listarPorCliente(Long clienteId) {
        return repository.findByCliente_Id(clienteId);
    }

    public List<Equipamento> equipamentosQuePrecisamManutencao() {

        return repository.findAll()
                .stream()
                .filter(Equipamento::precisaManutencao)
                .toList();
    }

    public List<Equipamento> listarPorLocalizacao(Long localizacaoId){
        return repository.findByLocalizacao_Id(localizacaoId);
    }

}
