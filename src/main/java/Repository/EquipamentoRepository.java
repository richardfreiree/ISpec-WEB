package Repository;

import org.springframework.data.jpa.repository.*;

import Entities.Equipamento;
import java.util.*;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {
    List<Equipamento> findByClienteId(Long clienteId);

    List<Equipamento> findByLocalizacaoId(Long localizacaoId);
    
}
