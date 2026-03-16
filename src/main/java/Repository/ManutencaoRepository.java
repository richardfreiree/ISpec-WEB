package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Entities.Manutencao;
import java.util.*;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {
    List<Manutencao> findByEquipamentoId(Long equipamentoId);

    List<Manutencao> findByUsuarioId(Long usuarioId);

}
