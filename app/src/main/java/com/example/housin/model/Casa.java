package com.example.housin.model;

public class Casa {
    private int qtdDeMoradores;
    private Endereco endereco;
    private int qtdDeQuartos;
    private int qtdDeBanheiros;
    private Mobilia mobilia;

    public Casa() {
    }

    public Casa(int qtdDeMoradores, Endereco endereco, int qtdDeQuartos, int qtdDeBanheiros, Mobilia mobilia) {
        this.qtdDeMoradores = qtdDeMoradores;
        this.endereco = endereco;
        this.qtdDeQuartos = qtdDeQuartos;
        this.qtdDeBanheiros = qtdDeBanheiros;
        this.mobilia = mobilia;
    }

    public int getQtdDeMoradores() {
        return qtdDeMoradores;
    }

    public void setQtdDeMoradores(int qtdDeMoradores) {
        this.qtdDeMoradores = qtdDeMoradores;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int getQtdDeQuartos() {
        return qtdDeQuartos;
    }

    public void setQtdDeQuartos(int qtdDeQuartos) {
        this.qtdDeQuartos = qtdDeQuartos;
    }

    public int getQtdDeBanheiros() {
        return qtdDeBanheiros;
    }

    public void setQtdDeBanheiros(int qtdDeBanheiros) {
        this.qtdDeBanheiros = qtdDeBanheiros;
    }

    public Mobilia getMobilia() {
        return mobilia;
    }

    public void setMobilia(Mobilia mobilia) {
        this.mobilia = mobilia;
    }
}
