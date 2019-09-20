package com.example.housin.model;

public abstract class Usuario {

    private String nome;
    private String email;
    private String sexo;
    private String numeroTelefone;
    private boolean fumante;
    private boolean consumidorDeAlcool;
    private CaracteristicasDesejadas caracteristicasQueProcura;
    private GostoPessoal meusGostos;

    public Usuario(String nome, String email, String sexo, String numeroTelefone, boolean fumante, boolean consumidorDeAlcool, CaracteristicasDesejadas caracteristicasQueProcura, GostoPessoal meusGostos) {
        this.nome = nome;
        this.email = email;
        this.sexo = sexo;
        this.numeroTelefone = numeroTelefone;
        this.fumante = fumante;
        this.consumidorDeAlcool = consumidorDeAlcool;
        this.caracteristicasQueProcura = caracteristicasQueProcura;
        this.meusGostos = meusGostos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
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

    public CaracteristicasDesejadas getCaracteristicasQueProcura() {
        return caracteristicasQueProcura;
    }

    public void setCaracteristicasQueProcura(CaracteristicasDesejadas caracteristicasQueProcura) {
        this.caracteristicasQueProcura = caracteristicasQueProcura;
    }

    public GostoPessoal getMeusGostos() {
        return meusGostos;
    }

    public void setMeusGostos(GostoPessoal meusGostos) {
        this.meusGostos = meusGostos;
    }
}
