package com.sistemascola.menu;

public enum ModalidadeEnsino {

    PRESENCIAL("Curso presencial."),
    ONLINE("Curso online."),
    HIBRIDO("Curso híbrido.");

    private final String modelo;

    ModalidadeEnsino (String modelo){
        this.modelo = modelo;
    }

    public String getModelo(){
        return modelo;

    }

}
