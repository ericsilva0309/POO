package com.sistemascola.menu;

import lombok.Getter;

@Getter
public enum ModalidadeEnsino {

    PRESENCIAL("Curso presencial."),
    ONLINE("Curso online."),
    HIBRIDO("Curso híbrido.");

    private final String modelo;

    ModalidadeEnsino (String modelo){
        this.modelo = modelo;
    }

}
