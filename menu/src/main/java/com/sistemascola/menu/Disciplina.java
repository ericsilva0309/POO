package com.sistemascola.menu;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Disciplina {
    private int id;
    private String nome;
    private String codigo;

    // Construtor com parâmetros
    public Disciplina(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
        // Inicialize o id se necessário ou use outro método para atribuí-lo
        this.id = generateId(); // Exemplo: método fictício para gerar um id
    }

    // Método fictício para gerar id, você pode ajustar conforme a necessidade
    private int generateId() {
        // Lógica para gerar um id único
        return (int) (Math.random() * 1000); // Exemplo simples
    }

    // Adicione outros métodos e atributos conforme necessário
}
