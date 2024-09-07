package com.sistemascola.menu;

import java.util.Scanner;

public class Disciplina {
    Scanner sc1 = new Scanner(System.in);

    private int id;
    private String nome;
    //private double nota;
    //double somaNota = 0;
    //int quantNotas = 4;

    public Disciplina(String nome, String codigo) {
        this.nome = nome;
        this.id = id;
    }



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    // public double getNota() {
    //     return nota;
    // }
    // public void setNota(double nota) {
    //     this.nota = nota;
        //for (int i = 1; i <= quantNotas; i++) {
            // System.out.print("Digite a %dª nota: "+i);
            // nota = sc1.nextDouble();
            // somaNota = somaNota + nota;
        }


