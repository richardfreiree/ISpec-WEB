package Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Entities.Inspecao;

public interface InspecaoRepository extends JpaRepository<Inspecao, Long> {
    List<Inspecao> findByEquipamentoId(Long equipamentoId);

    List<Inspecao> findByUsuarioId(Long usuarioId);

    List<Inspecao> findByEquipamentoClienteId(Long clienteId);

    List<Inspecao> findByEquipamentoLocalizacaoId(Long localizacaoId);

}
