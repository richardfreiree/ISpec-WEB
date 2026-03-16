package Entities;

import java.time.LocalDate;

import Enums.StatusManutencao;
import jakarta.persistence.*;

@Entity
public class Manutencao {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean aprovado;
    private String observacoes;

    @ManyToOne
    private Equipamento equipamento;

    private LocalDate dataManutencao;

    @ManyToOne
    private Usuario tecnicoResponsavel;

    

    @Enumerated(EnumType.STRING)
    private StatusManutencao status;

    public Manutencao(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public LocalDate getDataManutencao() {
        return dataManutencao;
    }

    public void setDataManutencao(LocalDate dataManutencao) {
        this.dataManutencao = dataManutencao;
    }

    public Usuario getTecnicoResponsavel() {
        return tecnicoResponsavel;
    }

    public void setTecnicoResponsavel(Usuario tecnicoResponsavel) {
        this.tecnicoResponsavel = tecnicoResponsavel;
    }

    public StatusManutencao getStatus() {
        return status;
    }

    public void setStatus(StatusManutencao status) {
        this.status = status;
    }

    

}
