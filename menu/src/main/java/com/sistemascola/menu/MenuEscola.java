package com.sistemascola.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.sistemascola.menu.Exceptions.DigitoInvalidoException;

public class MenuEscola {
    private static final Scanner sc = new Scanner(System.in); // Scanner global para a classe

    public static void diretor() {
        int opcao = -1;

        do {
            try {
                System.out.println("\n--- MENU PRINCIPAL ---");
                System.out.println("1- Menu Diretor");
                System.out.println("2- Menu Aluno");
                System.out.println("3- Menu Professor");
                System.out.println("0- Sair");
                System.out.print("Escolha uma opção: ");
                opcao = sc.nextInt();
                sc.nextLine(); // Limpar o buffer do scanner

                switch (opcao) {
                    case 1:
                        menuDiretor(); // Chama o menuDiretor da classe MenuEscola
                        break;
                    case 2:
                        Aluno.menuAluno();
                        break;
                    case 3:
                        Professor.menuProfessor(); // Chama o menuProfessor da classe Professor
                        break;
                    case 0:
                        System.out.println("Saindo... Até logo!");
                        break;
                    default:
                        throw new DigitoInvalidoException("Número inválido! Digite um número inteiro entre 0 e 3.");
                }

            } catch (DigitoInvalidoException e) {
                System.out.println(e.getMessage()); // Mostra a mensagem de erro personalizada
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
                sc.next(); // Limpa o buffer do scanner para a próxima tentativa
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage()); // Mensagem de erro genérica para depuração
            }

            if (opcao != 0) {
                System.out.println("\nPressione Enter para continuar...");
                sc.nextLine();
            }
        } while (opcao != 0);

        sc.close();
    }

    public static void menuDiretor() {
        int opcao = -1;

        do {
            System.out.println("\n- MENU DIRETOR -");
            System.out.println("O que deseja fazer?");
            System.out.println("1- Cadastrar novo aluno");
            System.out.println("2- Atualizar aluno");
            System.out.println("3- Deletar aluno");
            System.out.println("4- Listar alunos");
            System.out.println("0- Sair\n");
            System.out.print("Digite uma opção: ");

            try {
                opcao = sc.nextInt();
                sc.nextLine(); // Limpar o buffer do scanner
                switch (opcao) {
                    case 1:
                        Aluno.cadastrarNovoAluno();
                        break;
                    case 2:
                        Aluno.atualizarAluno();
                        break;
                    case 3:
                        Aluno.deletarAluno();
                        break;
                    case 4:
                        Aluno.imprimeListaDeAlunos();
                        break;
                    case 0:
                        System.out.println("Saindo... Até logo!");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                sc.next(); // Limpa o buffer do Scanner
            }
        } while (opcao != 0);
    }
}
