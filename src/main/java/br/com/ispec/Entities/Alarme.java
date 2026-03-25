package br.com.ispec.Entities;

import java.time.LocalDate;
import jakarta.persistence.Entity;

@Entity
public class Alarme extends Equipamento {
    private String tipoSensor;
    private boolean funcionando;
    private LocalDate ultimaVerificacao;

    public Alarme() {
    }

    
    public boolean precisaTeste() {
        if (ultimaVerificacao == null)
            return true;
        return ultimaVerificacao.plusMonths(6).isBefore(LocalDate.now());
    }

    @Override
    public String tipoEquipamento() {
        return "Alarme";
    }

    @Override
    public boolean precisaManutencao() {
        if (ultimaVerificacao == null)
            return true;
        return !funcionando || ultimaVerificacao.plusMonths(6).isBefore(LocalDate.now());
    }

    public String getTipoSensor() {
        return tipoSensor;
    }

    public void setTipoSensor(String tipoSensor) {
        this.tipoSensor = tipoSensor;
    }

    public boolean isFuncionando() {
        return funcionando;
    }

    public void setFuncionando(boolean funcionando) {
        this.funcionando = funcionando;
    }

    public LocalDate getUltimaVerificacao() {
        return ultimaVerificacao;
    }

    public void setUltimaVerificacao(LocalDate ultimaVerificacao) {
        this.ultimaVerificacao = ultimaVerificacao;
    }
}