package br.com.ispec.Entities;

import jakarta.persistence.*;

@Entity
public class Hidrante extends Equipamento {
    private double pressaoAgua;
    private double compMangueira;
    private boolean disponivel;

    public Hidrante(){}

    private boolean pressaoSuficiente(){
        return pressaoAgua >= 5;
    }

    private boolean operacional(){
        return disponivel && pressaoSuficiente();
    }

    @Override
    public boolean precisaManutencao(){
        return !operacional() || compMangueira < 20;
    }

    @Override
    public String tipoEquipamento(){
        return "Hidrante";
    }

    public double getPressaoAgua() {
        return pressaoAgua;
    }

    public void setPressaoAgua(double pressaoAgua) {
        this.pressaoAgua = pressaoAgua;
    }

    public double getCompMangueira() {
        return compMangueira;
    }

    public void setCompMangueira(double compMangueira) {
        this.compMangueira = compMangueira;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    
}
