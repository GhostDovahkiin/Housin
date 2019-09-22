package com.example.housin.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Usuario {

    @SerializedName("bebe")
    @Expose
    private Boolean bebe;
    @SerializedName("comportamento")
    @Expose
    private String comportamento;
    @SerializedName("fuma")
    @Expose
    private Boolean fuma;
    @SerializedName("gostaDeAnimais")
    @Expose
    private Boolean gostaDeAnimais;
    @SerializedName("limpo")
    @Expose
    private Boolean limpo;
    @SerializedName("organizado")
    @Expose
    private Boolean organizado;
    @SerializedName("responsavel")
    @Expose
    private Boolean responsavel;
    @SerializedName("sexo")
    @Expose
    private String sexo;
    @SerializedName("username")
    @Expose
    private String username;

    public Boolean getBebe() {
        return bebe;
    }

    public void setBebe(Boolean bebe) {
        this.bebe = bebe;
    }

    public String getComportamento() {
        return comportamento;
    }

    public void setComportamento(String comportamento) {
        this.comportamento = comportamento;
    }

    public Boolean getFuma() {
        return fuma;
    }

    public void setFuma(Boolean fuma) {
        this.fuma = fuma;
    }

    public Boolean getGostaDeAnimais() {
        return gostaDeAnimais;
    }

    public void setGostaDeAnimais(Boolean gostaDeAnimais) {
        this.gostaDeAnimais = gostaDeAnimais;
    }

    public Boolean getLimpo() {
        return limpo;
    }

    public void setLimpo(Boolean limpo) {
        this.limpo = limpo;
    }

    public Boolean getOrganizado() {
        return organizado;
    }

    public void setOrganizado(Boolean organizado) {
        this.organizado = organizado;
    }

    public Boolean getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Boolean responsavel) {
        this.responsavel = responsavel;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
