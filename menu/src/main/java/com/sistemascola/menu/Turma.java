package com.sistemascola.menu;

import java.util.ArrayList;
import java.util.List;

public class Turma {

    private int id;
    private String numero;
    private List<Aluno> alunos;
    private List<Professor> professores;

    public Turma(){

    }

    public Turma(int id, String numero) {
        this.id = id;
        this.numero = numero;
        this.alunos = new ArrayList<>(); // Inicializa a lista de alunos
        this.professores = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno); // Adiciona um aluno à lista
    }

    public void adicionarProfessor(Professor professor) {
        this.professores.add(professor); // Adiciona um aluno à lista
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }




    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }
    

    public void exibirDadosTurma() {
        System.out.println("\nID da turma: " + this.getId());
        System.out.println("Número da turma: " + this.getNumero());
    
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno registrado.");
        } else {
            System.out.println("\nAlunos:");
            for (Aluno aluno : alunos) {
                System.out.println("- " + aluno); // Isso vai chamar o método toString() de Aluno
            }
        }
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor registrado.");
        } else {
            System.out.println("\nProfessores:");
            for (Professor professor : professores) {
                System.out.println("- " + professor.getNome()); // Isso vai chamar o método toString() de professor
            }
        }

    }

}
