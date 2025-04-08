package com.example.atividadePontuada.model;

public enum Sexo {
    MASCULINO("Masculino"),
    FEMINNO("Feminino");

    private String texto;

    Sexo(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
