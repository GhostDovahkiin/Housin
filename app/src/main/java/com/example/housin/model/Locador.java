package com.example.housin.model;

import java.util.List;

public class Locador extends Usuario {
    private List<Casa> minhasCasasAnunciadas;
    private List<Usuario> matchs;

    public Locador(String nome, String email, String sexo, String numeroTelefone, boolean fumante, boolean consumidorDeAlcool, CaracteristicasDesejadas caracteristicasQueProcura, GostoPessoal meusGostos, List<Casa> minhasCasasAnunciadas, List<Usuario> matchs) {
        super(nome, email, sexo, numeroTelefone, fumante, consumidorDeAlcool, caracteristicasQueProcura, meusGostos);
        this.minhasCasasAnunciadas = minhasCasasAnunciadas;
        this.matchs = matchs;
    }

    public List<Casa> getMinhasCasasAnunciadas() {
        return minhasCasasAnunciadas;
    }

    public void setMinhasCasasAnunciadas(List<Casa> minhasCasasAnunciadas) {
        this.minhasCasasAnunciadas = minhasCasasAnunciadas;
    }

    public List<Usuario> getMatchs() {
        return matchs;
    }

    public void setMatchs(List<Usuario> matchs) {
        this.matchs = matchs;
    }
}
