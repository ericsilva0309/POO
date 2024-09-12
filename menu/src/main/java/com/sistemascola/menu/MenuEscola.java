package com.sistemascola.menu;

import java.util.Scanner;

import com.sistemascola.menu.Exceptions.DigitoInvalidoException;

public class MenuEscola {
    public static void diretor() {

        int opcao=-1;

do {
    
    Scanner sc = new Scanner(System.in);
            try {
                System.out.println("\n--- MENU PRINCIPAL ---");
                System.out.println("1- Menu Aluno");
                System.out.println("2- Menu Diretor");
                System.out.println("3- Menu Professor");
                System.out.println("0- Sair");
                System.out.print("Escolha uma opção: ");
                opcao = sc.nextInt();

                switch (opcao) {
                    case 1:
                        menuAluno();
                        break;
                    case 2:
                        Aluno.menuDiretor();
                        break;
                    case 3:
                        // professor.menuProfessor();
                        Professor.menuProfessor();
                        break;
                    case 0:
                        System.out.println("Saindo... Até logo!");
                        break;
                    default:
                        throw new DigitoInvalidoException("Número inválido! Digite um número inteiro entre 0 e 3.");
                }

            } catch (DigitoInvalidoException e) {
                System.out.println(e.getMessage()); // Mostra a mensagem de erro personalizada
            } catch (Exception e) {
                System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
                sc.nextLine(); //evita loop infinito
            }
            if (opcao != 0) {
                System.out.println("\nPressione Enter para continuar...");
                sc.nextLine(); // Espera o usuário pressionar Enter
            }
        } while (opcao != 0);
    }

    // Exemplo para MenuEscola
public static void menuAluno() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- MENU ALUNO ---");
        System.out.println("Selecione o aluno para consultar notas:");
    
        // Exibe a lista de alunos
        for (int i = 0; i < Aluno.listaDeAlunos.size(); i++) {
            System.out.println((i + 1) + " - " + Aluno.listaDeAlunos.get(i).getNome());
        }
    
        System.out.print("Escolha um número: ");
        int opcao = sc.nextInt();
        Aluno alunoSelecionado = Aluno.listaDeAlunos.get(opcao - 1);
    
        // Verifica se o aluno possui disciplinas
        if (alunoSelecionado.getListaDisciplinas().isEmpty()) {
            System.out.println("Este aluno não está inscrito em nenhuma disciplina.");
        } else {
            // Exibe as disciplinas e as notas do aluno
            System.out.println("Notas de " + alunoSelecionado.getNome() + ":");
            for (Alunodisciplina ad : alunoSelecionado.getListaDisciplinas()) {
                System.out.println("Disciplina: " + ad.getDisciplina().getNome());
                System.out.println("Nota 1: " + ad.getNota1());
                System.out.println("Nota 2: " + ad.getNota2());
                System.out.println("Nota 3: " + ad.getNota3());
                System.out.println("Nota 4: " + ad.getNota4());
                System.out.println("Média: " + (ad.getNota1()+ad.getNota2()+ad.getNota3()+ad.getNota4())/4);
                System.out.println("------------------------");
            }
        }
    }
}
