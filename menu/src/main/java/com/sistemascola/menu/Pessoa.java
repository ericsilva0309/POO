package com.sistemascola.menu;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Pessoa {

    private int id;
    private String cpf;
    private String nome;
    private String telefone;
    private String email;
    private Endereco endereco;
    private String matricula;


    public Pessoa(){
    }

    public Pessoa(int id, String cpf, String nome, String telefone, String email,
    Endereco endereco, String matricula) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.matricula = matricula;
    }
}