package com.sistemascola.menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Professor extends Pessoa implements Login {

    private String usuario;
    private String senha;
    private List<Disciplina> disciplinas; // Professor pode ter mais de uma disciplina

    public static List<Professor> professores = new ArrayList<>();

    public Professor(int id, String cpf, String nome, String telefone, String email, Endereco endereco, String matricula) {
        super(id, cpf, nome, telefone, email, endereco, matricula);
        this.disciplinas = new ArrayList<>(); // Inicializando a lista de disciplinas
    }

    // Métodos para adicionar disciplinas, exibir listas e menu professor
    // ...

    @Override
    public boolean acessoPermitido(String login, String senha) {
        return login.equals(getUsuario()) && senha.equals(getSenha());
    }

    public static void menuProfessor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- MENU PROFESSOR ---");
        System.out.println("Selecione o aluno para atribuir notas:");

        // Exibe a lista de alunos
        for (int i = 0; i < Aluno.listaDeAlunos.size(); i++) {
            System.out.println((i + 1) + " - " + Aluno.listaDeAlunos.get(i).getNome());
        }

        int opcao = -1;
        boolean entradaValida = false;

        // Solicita a escolha do aluno até que a entrada seja válida
        while (!entradaValida) {
            System.out.print("Escolha um número: ");
            try {
                opcao = sc.nextInt();
                if (opcao < 1 || opcao > Aluno.listaDeAlunos.size()) {
                    System.out.println("Opção inválida. Por favor, escolha um número válido.");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                sc.next(); // Limpa o buffer do Scanner
            }
        }

        // Limpa o buffer do Scanner após leitura de número
        sc.nextLine();

        Aluno alunoSelecionado = Aluno.listaDeAlunos.get(opcao - 1);

        // Adicionar uma nova disciplina
        System.out.println("Adicione uma nova disciplina:");
        System.out.println("Escolha uma disciplina:");
        for (int i = 0; i < Disciplina.values().length; i++) {
            System.out.println((i + 1) + " - " + Disciplina.values()[i].getNome());
        }

        int disciplinaEscolhida = -1;
        while (disciplinaEscolhida < 1 || disciplinaEscolhida > Disciplina.values().length) {
            System.out.print("Escolha o número da disciplina: ");
            try {
                disciplinaEscolhida = sc.nextInt();
                if (disciplinaEscolhida < 1 || disciplinaEscolhida > Disciplina.values().length) {
                    System.out.println("Opção inválida. Por favor, escolha uma disciplina válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                sc.next(); // Limpa o buffer do Scanner
            }
        }

        Disciplina disciplinaSelecionada = Disciplina.values()[disciplinaEscolhida - 1];

        // Criação de Alunodisciplina
        Alunodisciplina novaAlunodisciplina = new Alunodisciplina(alunoSelecionado, disciplinaSelecionada, 0, 0, 0, 0);

        // Atribuição de notas
        double nota1 = obterNota("Digite a nota 1: ");
        double nota2 = obterNota("Digite a nota 2: ");
        double nota3 = obterNota("Digite a nota 3: ");
        double nota4 = obterNota("Digite a nota 4: ");
        
        // Atualiza as notas na nova Alunodisciplina
        novaAlunodisciplina.setNota1(nota1);
        novaAlunodisciplina.setNota2(nota2);
        novaAlunodisciplina.setNota3(nota3);
        novaAlunodisciplina.setNota4(nota4);

        // Adiciona a nova Alunodisciplina à lista de disciplinas do aluno
        alunoSelecionado.adicionarDisciplina(novaAlunodisciplina);

        System.out.println("Notas e disciplina atribuídas com sucesso!");
    }

    private static double obterNota(String mensagem) {
        Scanner sc = new Scanner(System.in);
        double nota = -1;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print(mensagem);
            try {
                nota = sc.nextDouble();
                // Verifica se a nota está dentro do intervalo permitido
                if (nota < 0 || nota > 10) {
                    System.out.println("Nota inválida. Deve estar entre 0 e 10.");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número válido.");
                sc.next(); // Limpa o buffer do Scanner para a próxima entrada
            }
        }

        // Limpa o buffer do Scanner após leitura de número
        sc.nextLine();

        return nota;
    }
}
