package Entities;

import Enums.TipoUsuario;
import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String email;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;

    public Usuario(){}

    public boolean podeRealizarInspecao(){
        return tipo == TipoUsuario.FISCAL || tipo == TipoUsuario.ADMIN;
    }

    public boolean podeRealizarManutencao(){
        return tipo == TipoUsuario.TECNICO;
    }

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    
}
