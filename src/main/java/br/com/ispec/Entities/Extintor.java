package br.com.ispec.Entities;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Extintor extends Equipamento {
    private String classeFogo;
    private double capacidade;
    private LocalDate dataValidade;
    private int pressao;

    public Extintor(){}

    public boolean estaVencido(){
        return dataValidade != null && dataValidade.isBefore(LocalDate.now());
    }

    public boolean pressaoAdequada(){
        return pressao >= 10;
    }

    @Override
    public boolean precisaManutencao(){
        return estaVencido();
    }

    @Override
    public String tipoEquipamento(){
        return "Extintor";
    }

    public String getClasseFogo() {
        return classeFogo;
    }

    public void setClasseFogo(String classeFogo) {
        this.classeFogo = classeFogo;
    }

    public double getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(double capacidade) {
        this.capacidade = capacidade;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public int getPressao() {
        return pressao;
    }

    public void setPressao(int pressao) {
        this.pressao = pressao;
    }

    
}
