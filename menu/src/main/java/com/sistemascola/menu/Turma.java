package com.sistemascola.menu;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    public void exibirDadosTurma() {
        System.out.println("\nID da turma: " + this.getId());
        System.out.println("Número da turma: " + this.getNumero());

        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno registrado.");
        } else {
            System.out.println("\nAlunos:");
            for (Aluno aluno : alunos) {
                System.out.println("- " + aluno.getNome()); // Isso vai chamar o método toString() de Aluno
            }
        }
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor registrado na turma.");
        } else {
            System.out.println("\nProfessores:");
            for (Professor professor : professores) {
                System.out.println("- " + professor.getNome()); // Isso vai chamar o método toString() de professor
            }
        }
    }
}
