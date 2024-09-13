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

    public static List<Turma> listaDeTurmas = new ArrayList<>();

    public Turma() {
    }

    public Turma(int id, String numero) {
        this.id = id;
        this.numero = numero;
        this.alunos = new ArrayList<>();
        this.professores = new ArrayList<>();
    }

    
    

    public void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public void adicionarProfessor(Professor professor) {
        this.professores.add(professor);
    }

    public void exibirDadosTurma() {
        System.out.println("\nID da turma: " + this.getId());
        System.out.println("Número da turma: " + this.getNumero());

        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno registrado.");
        } else {
            System.out.println("\nAlunos:");
            for (Aluno aluno : alunos) {
                System.out.println("- " + aluno.getNome());
            }
        }
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor registrado na turma.");
        } else {
            System.out.println("\nProfessores:");
            for (Professor professor : professores) {
                System.out.println("- " + professor.getNome());
            }
        }
    }
}