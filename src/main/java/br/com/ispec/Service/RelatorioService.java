package br.com.ispec.Service;

import java.time.LocalDate;
import java.util.stream.Collectors;

import br.com.ispec.Entities.Equipamento;
import br.com.ispec.Entities.Inspecao;
import br.com.ispec.Entities.Manutencao;
import br.com.ispec.Repository.EquipamentoRepository;
import br.com.ispec.Repository.InspecaoRepository;
import br.com.ispec.Repository.ManutencaoRepository;

import java.util.*;

public class RelatorioService {
    private final EquipamentoRepository equipamentoRepository;
    private final InspecaoRepository inspecaoRepository;
    private final ManutencaoRepository manutencaoRepository;

    public RelatorioService(EquipamentoRepository equipamentoRepository,
                            InspecaoRepository inspecaoRepository, ManutencaoRepository manutencaoRepository) {

        this.equipamentoRepository = equipamentoRepository;
        this.inspecaoRepository = inspecaoRepository;
        this.manutencaoRepository = manutencaoRepository;
    }

    // RELATÓRIO: equipamentos que precisam de manutenção
    public List<Equipamento> equipamentosQuePrecisamManutencao(){

        return equipamentoRepository.findAll()
                .stream()
                .filter(Equipamento::precisaManutencao)
                .collect(Collectors.toList());
    }

    // RELATÓRIO: inspeções em um período
    public List<Inspecao> inspecoesPorPeriodo(LocalDate inicio, LocalDate fim){

        return inspecaoRepository.findAll()
                .stream()
                .filter(i -> !i.getDataInspecao().isBefore(inicio) &&
                             !i.getDataInspecao().isAfter(fim))
                .collect(Collectors.toList());
    }

    // RELATÓRIO POR CLIENTE
    public List<Inspecao> relatorioPorCliente(Long clienteId){

        return inspecaoRepository.findAll()
                .stream()
                .filter(i -> i.getCliente() != null &&
                        i.getCliente().getId().equals(clienteId))
                .collect(Collectors.toList());
    }

    // RELATÓRIO POR USUÁRIO RESPONSÁVEL
    public List<Inspecao> relatorioPorUsuario(Long usuarioId){

        return inspecaoRepository.findAll()
                .stream()
                .filter(i -> i.getResponsavel() != null &&
                        i.getResponsavel().getId().equals(usuarioId))
                .collect(Collectors.toList());
    }

    // RELATÓRIO POR LOCALIZAÇÃO
    public List<Inspecao> relatorioPorLocalizacao(Long localizacaoId){

        return inspecaoRepository.findAll()
                .stream()
                .filter(i -> i.getLocalizacao() != null &&
                        i.getLocalizacao().getId().equals(localizacaoId))
                .collect(Collectors.toList());
    }

    // RELATÓRIO DE MANUTENÇÃO POR USUÁRIO
    public List<Manutencao> manutencoesPorTecnico(Long usuarioId){

        return manutencaoRepository.findAll()
                .stream()
                .filter(m -> m.getTecnicoResponsavel() != null &&
                        m.getTecnicoResponsavel().getId().equals(usuarioId))
                .collect(Collectors.toList());
    }


}
