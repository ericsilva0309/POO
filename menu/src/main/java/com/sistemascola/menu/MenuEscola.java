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
                        Aluno.exibirDadosAluno();
                        break;
                    case 2:
                        Aluno.menuAluno();
                        break;
                    case 3:
                        // professor.menuProfessor();
                        System.out.println("Menu do Professor - Em construção.");
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
}
