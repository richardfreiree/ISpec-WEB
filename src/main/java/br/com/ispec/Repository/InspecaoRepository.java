package br.com.ispec.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.com.ispec.Entities.Inspecao;

public interface InspecaoRepository extends JpaRepository<Inspecao, Long> {
    List<Inspecao> findByEquipamento_Id(Long equipamentoId);

    List<Inspecao> findByResponsavel_Id(Long responsavelId);

    @Query("SELECT i FROM Inspecao i WHERE i.equipamento.localizacao.cliente.id = :clienteId")
    List<Inspecao> findByEquipamentoCliente_Id(@Param("clienteId") Long clienteId);

    List<Inspecao> findByEquipamentoLocalizacao_Id(Long localizacaoId);
}