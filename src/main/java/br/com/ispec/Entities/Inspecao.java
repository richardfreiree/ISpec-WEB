package br.com.ispec.Entities;

import java.time.LocalDate;

import br.com.ispec.Enums.Status;
import jakarta.persistence.*;

@Entity
public class Inspecao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Equipamento equipamento;

    @ManyToOne
    private Cliente cliente;

    private LocalDate dataInspecao;

    @ManyToOne
    private Usuario responsavel;

    private boolean aprovado;
    private String observacoes;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Localizacao localizacao;

    public Inspecao(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataInspecao() {
        return dataInspecao;
    }

    public void setDataInspecao(LocalDate dataInspecao) {
        this.dataInspecao = dataInspecao;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    
}
