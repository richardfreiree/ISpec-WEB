package Entities;

import java.time.LocalDate;

import Enums.Status;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    protected String nome;

    @ManyToOne
    @JoinColumn(name = "localizacao_id")
    protected Localizacao localizacao;

    protected LocalDate dataInstalacao;

    @Enumerated(EnumType.STRING)
    protected Status status;

    protected boolean ativo;

    public Equipamento(){}

    public boolean estaOperacional(){
        return ativo && status == Status.CONCLUIDA;
    }

    public boolean precisaRevisao(){
        return dataInstalacao.plusYears(1).isBefore(LocalDate.now());
    }

    public int anosDeUso(){
        return LocalDate.now().getYear() - dataInstalacao.getYear();
    }

    public abstract boolean precisaManutencao();
    public abstract String tipoEquipamento();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public LocalDate getDataInstalacao() {
        return dataInstalacao;
    }

    public void setDataInstalacao(LocalDate dataInstalacao) {
        this.dataInstalacao = dataInstalacao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    
}
