package com.example.housin.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public abstract class UserAPI {

    @Expose
    @SerializedName("usuario")
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public static class Usuario {
        @Expose
        @SerializedName("username")
        private String username;
        @Expose
        @SerializedName("sexo")
        private String sexo;
        @Expose
        @SerializedName("responsavel")
        private boolean responsavel;
        @Expose
        @SerializedName("organizado")
        private boolean organizado;
        @Expose
        @SerializedName("limpo")
        private boolean limpo;
        @Expose
        @SerializedName("gostaDeAnimais")
        private boolean gostadeanimais;
        @Expose
        @SerializedName("fuma")
        private boolean fuma;
        @Expose
        @SerializedName("comportamento")
        private String comportamento;
        @Expose
        @SerializedName("bebe")
        private boolean bebe;

        public String getUsername() {
            return username;
        }

        public String getSexo() {
            return sexo;
        }

        public boolean getResponsavel() {
            return responsavel;
        }

        public boolean getOrganizado() {
            return organizado;
        }

        public boolean getLimpo() {
            return limpo;
        }

        public boolean getGostadeanimais() {
            return gostadeanimais;
        }

        public boolean getFuma() {
            return fuma;
        }

        public String getComportamento() {
            return comportamento;
        }

        public boolean getBebe() {
            return bebe;
        }
    }

}
