package com.sistemascola.menu;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Endereco {
    private int id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private UnidadeFederal unidade;
    private String cep;
    private String referencia;

    public Endereco(){

    }

    public Endereco(int id, String logradouro, String numero, String complemento, String bairro, String cidade,
    UnidadeFederal unidade, String cep) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.unidade = unidade;
        this.cep = cep;
    }

    public void imprimeEndereco(){
        System.out.println(this.logradouro);
        System.out.println(this.numero);
        System.out.println(this.complemento);
        System.out.println(this.bairro);
        System.out.println(this.cidade);
        System.out.println(this.unidade);
        System.out.println(this.cep);
    }
}



