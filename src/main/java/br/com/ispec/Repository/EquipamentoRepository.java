package br.com.ispec.Repository;

import org.springframework.data.jpa.repository.*;

import br.com.ispec.Entities.Equipamento;
import java.util.*;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {
    List<Equipamento> findByCliente_Id(Long clienteId);

    List<Equipamento> findByLocalizacao_Id(Long localizacaoId);
    
}
