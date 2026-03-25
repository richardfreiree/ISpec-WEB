package br.com.ispec.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.com.ispec.Entities.Equipamento;
import java.util.*;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {

    @Query("SELECT e FROM Equipamento e WHERE e.localizacao.cliente.id = :clienteId")
    List<Equipamento> findByCliente_Id(@Param("clienteId") Long clienteId);

    List<Equipamento> findByLocalizacao_Id(Long localizacaoId);
}