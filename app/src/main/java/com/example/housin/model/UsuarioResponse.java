package com.example.housin.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UsuarioResponse {

    @SerializedName("usuario")
    @Expose
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
