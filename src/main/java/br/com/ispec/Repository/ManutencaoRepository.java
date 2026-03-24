package br.com.ispec.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ispec.Entities.Manutencao;
import java.util.*;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {
    List<Manutencao> findByEquipamento_Id(Long equipamentoId);

    List<Manutencao> findByUsuario_Id(Long usuarioId);

}
