package com.example.housin.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UsuarioResponse {

    @SerializedName("usuario")
    @Expose
    private UsuarioAPI usuario;

    public UsuarioAPI getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioAPI usuario) {
        this.usuario = usuario;
    }

}
