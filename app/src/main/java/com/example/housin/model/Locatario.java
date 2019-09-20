package com.example.housin.model;

import java.util.List;

public class Locatario extends Usuario {
    private List<Casa> matchs;


    public Locatario(String nome, String email, String sexo, String numeroTelefone, boolean fumante, boolean consumidorDeAlcool, CaracteristicasDesejadas caracteristicasQueProcura, GostoPessoal meusGostos, List<Casa> matchs) {
        super(nome, email, sexo, numeroTelefone, fumante, consumidorDeAlcool, caracteristicasQueProcura, meusGostos);
        this.matchs = matchs;
    }

    public List<Casa> getMatchs() {
        return matchs;
    }

    public void setMatchs(List<Casa> matchs) {
        this.matchs = matchs;
    }
}
