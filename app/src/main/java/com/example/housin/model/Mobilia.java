package com.example.housin.model;

public class Mobilia {
    private boolean fogao;
    private boolean geladeira;
    private boolean mesa;
    private boolean camaExtra;
    private boolean televisao;
    private boolean microOndas;
    private boolean maquinaDeLavar;
    private boolean liquidificador;
    private boolean sanduicheira;
    private boolean sofa;

    public Mobilia(boolean fogao, boolean geladeira, boolean mesa, boolean camaExtra, boolean televisao, boolean microOndas, boolean maquinaDeLavar,
                   boolean liquidificador, boolean sanduicheira, boolean sofa) {

        this.fogao = fogao;
        this.geladeira = geladeira;
        this.mesa = mesa;
        this.camaExtra = camaExtra;
        this.televisao = televisao;
        this.microOndas = microOndas;
        this.maquinaDeLavar = maquinaDeLavar;
        this.liquidificador = liquidificador;
        this.sanduicheira = sanduicheira;
        this.sofa = sofa;
    }

    public boolean temFogao() {
        return fogao;
    }

    public void setFogao(boolean fogao) {
        this.fogao = fogao;
    }

    public boolean temGeladeira() {
        return geladeira;
    }

    public void temGeladeira(boolean geladeira) {
        this.geladeira = geladeira;
    }

    public boolean temMesa() {
        return mesa;
    }

    public void temMesa(boolean mesa) {
        this.mesa = mesa;
    }

    public boolean temCamaExtra() {
        return camaExtra;
    }

    public void setCamaExtra(boolean camaExtra) {
        this.camaExtra = camaExtra;
    }

    public boolean temTelevisao() {
        return televisao;
    }

    public void setTelevisao(boolean televisao) {
        this.televisao = televisao;
    }

    public boolean temMicroOndas() {return microOndas;}

    public void setMicroOndas(boolean microOndas) {this.microOndas = microOndas;}

    public boolean temMaquinaDeLavar() {return maquinaDeLavar;}

    public void setMaquinaDeLavar(boolean maquinaDeLavar) {this.maquinaDeLavar = maquinaDeLavar;}

    public boolean temLiquificador() {return liquidificador;}

    public void setLiquidificador(boolean liquidificador) {this.liquidificador = liquidificador;}

    public boolean temSanduicheira() {return sanduicheira;}

    public void setSanduicheira(boolean sanduicheira) {this.sanduicheira = sanduicheira;}

    public boolean temSofa() {return this.sofa;}

    public void setSofa(boolean sofa) {this.sofa = sofa;}





}
