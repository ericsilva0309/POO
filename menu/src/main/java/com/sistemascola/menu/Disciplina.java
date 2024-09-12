package com.sistemascola.menu;

import lombok.Getter;

@Getter
public enum Disciplina {
    PORTUGUES("Português"),
    MATEMATICA("Matemática"),
    INGLES("Inglês"),
    CIENCIAS("Ciências");

    private final String nome;

    Disciplina(String nome) {
        this.nome = nome;
    }
}
