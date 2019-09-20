package com.example.housin.model;

import java.util.List;

class GostoPessoal {
    private List<String> musical;
    private List<String> cinefilo;
    private List<String> gamer;
    private List<String> literario;
    private boolean limpo;
    private boolean organizado;
    private boolean extrovertido;
    private boolean introvertido;
    private boolean responsavelComContas;
    private boolean deBoasComAnimais;

    public GostoPessoal(List<String> musical, List<String> cinefilo, List<String> gamer, List<String> literario, boolean limpo, boolean organizado, boolean extrovertido, boolean introvertido, boolean responsavelComContas, boolean deBoasComAnimais) {
        this.musical = musical;
        this.cinefilo = cinefilo;
        this.gamer = gamer;
        this.literario = literario;
        this.limpo = limpo;
        this.organizado = organizado;
        this.extrovertido = extrovertido;
        this.introvertido = introvertido;
        this.responsavelComContas = responsavelComContas;
        this.deBoasComAnimais = deBoasComAnimais;
    }

    public List<String> getMusical() {
        return musical;
    }

    public void setMusical(List<String> musical) {
        this.musical = musical;
    }

    public List<String> getCinefilo() {
        return cinefilo;
    }

    public void setCinefilo(List<String> cinefilo) {
        this.cinefilo = cinefilo;
    }

    public List<String> getGamer() {
        return gamer;
    }

    public void setGamer(List<String> gamer) {
        this.gamer = gamer;
    }

    public List<String> getLiterario() {
        return literario;
    }

    public void setLiterario(List<String> literario) {
        this.literario = literario;
    }

    public boolean isLimpo() {
        return limpo;
    }

    public void setLimpo(boolean limpo) {
        this.limpo = limpo;
    }

    public boolean isOrganizado() {
        return organizado;
    }

    public void setOrganizado(boolean organizado) {
        this.organizado = organizado;
    }

    public boolean isExtrovertido() {
        return extrovertido;
    }

    public void setExtrovertido(boolean extrovertido) {
        this.extrovertido = extrovertido;
    }

    public boolean isIntrovertido() {
        return introvertido;
    }

    public void setIntrovertido(boolean introvertido) {
        this.introvertido = introvertido;
    }

    public boolean isResponsavelComContas() {
        return responsavelComContas;
    }

    public void setResponsavelComContas(boolean responsavelComContas) {
        this.responsavelComContas = responsavelComContas;
    }

    public boolean isDeBoasComAnimais() {
        return deBoasComAnimais;
    }

    public void setDeBoasComAnimais(boolean deBoasComAnimais) {
        this.deBoasComAnimais = deBoasComAnimais;
    }
}
