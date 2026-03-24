package br.com.ispec.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ispec.Entities.Inspecao;

public interface InspecaoRepository extends JpaRepository<Inspecao, Long> {
    List<Inspecao> findByEquipamento_Id(Long equipamentoId);

    List<Inspecao> findByUsuario_Id(Long usuarioId);

    List<Inspecao> findByEquipamentoCliente_Id(Long clienteId);

    List<Inspecao> findByEquipamentoLocalizacao_Id(Long localizacaoId);

}
