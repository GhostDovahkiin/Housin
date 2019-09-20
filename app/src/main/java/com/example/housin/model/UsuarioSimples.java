package com.example.housin.model;

public class UsuarioSimples extends Usuario{

    public UsuarioSimples(String nome, String email, String sexo, String numeroTelefone, boolean fumante, boolean consumidorDeAlcool, CaracteristicasDesejadas caracteristicasQueProcura, GostoPessoal meusGostos) {
        super(nome, email, sexo, numeroTelefone, fumante, consumidorDeAlcool, caracteristicasQueProcura, meusGostos);
    }
}
