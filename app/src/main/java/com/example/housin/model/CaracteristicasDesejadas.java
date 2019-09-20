package com.example.housin.model;

class CaracteristicasDesejadas {
    private boolean limpo;
    private boolean organizado;
    private boolean introvertido;
    private boolean extrovertido;
    private boolean responsavelComContas;
    private boolean deBoasComAnimais;
    private String preferenciaPorGenero;
    private boolean fumante;
    private boolean consumidorDeAlcool;
    private boolean lavaALouca;
    private boolean arrumaACasa;

    public CaracteristicasDesejadas(boolean limpo, boolean organizado, boolean introvertido, boolean extrovertido, boolean responsavelComContas, boolean deBoasComAnimais, String preferenciaPorGenero, boolean fumante, boolean consumidorDeAlcool, boolean lavaALouca, boolean arrumaACasa) {
        this.limpo = limpo;
        this.organizado = organizado;
        this.introvertido = introvertido;
        this.extrovertido = extrovertido;
        this.responsavelComContas = responsavelComContas;
        this.deBoasComAnimais = deBoasComAnimais;
        this.preferenciaPorGenero = preferenciaPorGenero;
        this.fumante = fumante;
        this.consumidorDeAlcool = consumidorDeAlcool;
        this.lavaALouca = lavaALouca;
        this.arrumaACasa = arrumaACasa;
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

    public boolean isIntrovertido() {
        return introvertido;
    }

    public void setIntrovertido(boolean introvertido) {
        this.introvertido = introvertido;
    }

    public boolean isExtrovertido() {
        return extrovertido;
    }

    public void setExtrovertido(boolean extrovertido) {
        this.extrovertido = extrovertido;
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

    public String getPreferenciaPorGenero() {
        return preferenciaPorGenero;
    }

    public void setPreferenciaPorGenero(String preferenciaPorGenero) {
        this.preferenciaPorGenero = preferenciaPorGenero;
    }

    public boolean isFumante() {
        return fumante;
    }

    public void setFumante(boolean fumante) {
        this.fumante = fumante;
    }

    public boolean isConsumidorDeAlcool() {
        return consumidorDeAlcool;
    }

    public void setConsumidorDeAlcool(boolean consumidorDeAlcool) {
        this.consumidorDeAlcool = consumidorDeAlcool;
    }

    public boolean isLavaALouca() {
        return lavaALouca;
    }

    public void setLavaALouca(boolean lavaALouca) {
        this.lavaALouca = lavaALouca;
    }

    public boolean isArrumaACasa() {
        return arrumaACasa;
    }

    public void setArrumaACasa(boolean arrumaACasa) {
        this.arrumaACasa = arrumaACasa;
    }
}
