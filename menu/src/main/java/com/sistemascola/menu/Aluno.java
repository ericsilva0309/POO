package com.sistemascola.menu;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sistemascola.menu.Exceptions.DigitoInvalidoException;

import java.util.InputMismatchException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Aluno extends Pessoa {
    Scanner sc = new Scanner(System.in);

    private Turma turma;
    private LocalDateTime matriculadoEm;
    private ModalidadeEnsino modalidade;
    public static List<Aluno> listaDeAlunos = new ArrayList<Aluno>();

    public static void menuAluno(){

        int opcao = 8;

        do {
            System.out.println("\n- MENU DIRETOR -");
            System.out.println("O que deseja fazer?");
            System.out.println("1- Cadastrar novo aluno");
            System.out.println("2- Atualizar aluno");
            System.out.println("3- Deletar aluno");
            System.out.println("4- Listar alunos");
            System.out.println("0- Sair\n");
            System.out.print("Digite uma opção: ");
            Scanner sc = new Scanner(System.in);
            //try {
                opcao = sc.nextInt();
                System.out.println("\n");
            // while (!sc.hasNextInt()) {
            //     System.out.println("Entrada inválida. Por favor, insira um número.");
            //     sc.next();
            // }
            // opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    cadastrarNovoAluno();
                    break;
                case 2:
                atualizarAluno();
                    break;
                case 3:
                deletarAluno();
                    break;
                case 4:
                imprimeListaDeAlunos();
                    break;
                case 0:
                System.out.println("Saindo... Até logo!");
                    break;
                default:
                System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            // if (opcao != 0) {
            //     System.out.println("\nPressione Enter para retornar ao menu...");
            //     sc.nextLine();
            //     sc.nextLine();
            // }
            //} catch (DigitoInvalidoException e) {
                //e.imprimeErro
        //}
    } while (opcao != 0);
}

    public Aluno(){
    }

    public static void cadastrarNovoAluno(){
        System.out.println("-CADASTRAR ALUNO-");
        System.out.println("Nome: ");
        Scanner sc = new Scanner(System.in);
        String nome = sc.nextLine();
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        System.out.println("CPF: ");
        String cpf = sc.nextLine();
        aluno.setCpf(cpf);
        Aluno.listaDeAlunos.add(aluno);
        System.out.println("\n");
    }

    public static void deletarAluno(){
    System.out.println("-DELETAR ALUNO-");
    //System.out.println("Nome: ");
    Scanner sc = new Scanner(System.in);
    //String nomeDeletar = sc.nextLine();
    if (listaDeAlunos.isEmpty()){
        System.out.println("Nenhum aluno registrado.");
    } else {
        System.out.println("\nAlunos:");
        int index = 0;
        for (Aluno aluno : listaDeAlunos) {
            System.out.println((index+1)+" - "+aluno.getNome());
            index++;
        }
        System.out.println("Digite o número respectivo do aluno que quer deletar");
        int numeroDeletar = sc.nextInt();
        for (int i = 0; i < listaDeAlunos.size(); i++) {
            if((numeroDeletar-1) == i){
            System.out.printf("Aluno "+listaDeAlunos.get(i).getNome()+" deletado");
            listaDeAlunos.remove(i);
        }
        }
    }
    //aluno.remove(nomeDeletar);
    System.out.println("\n");
}

public static void atualizarAluno() {
    int option;
    String cpfDigitado;
    Scanner sc = new Scanner(System.in);

    System.out.println("Atualizar Aluno\nDigite o CPF do Aluno:");
    cpfDigitado = sc.nextLine();
    if (listaDeAlunos.isEmpty()) {
        System.out.println("Nenhum Aluno registrado. Lista Vazia...");
    } else {
        boolean alunoEncontrado = false;
        for (Aluno aluno : listaDeAlunos) {
            if (aluno.getCpf().equals(cpfDigitado)) {
                System.out.printf("""
                        ° Nome: %s
                        ° CPF: %s
                        ° Matricula: %s
                        """, aluno.getNome(), aluno.getCpf(), aluno.getMatricula());
                
                alunoEncontrado = true;

                do {
                    System.out.println("""
                        Este é o aluno que gostaria de Atualizar?
                        
                        Digite 1 para ALTERAR o NOME
                        Digite 2 para ALTERAR a MATRICULA
                        Digite 3 para ALTERAR o CPF
                        Digite 0 para SAIR
                        """);

                    option = sc.nextInt();
                    sc.nextLine();

                    switch (option) {
                        case 1 -> {
                            System.out.println("Digite o novo nome:");
                            String nome = sc.nextLine();
                            aluno.setNome(nome);
                        }
                        case 2 -> {
                            System.out.println("Digite a nova matrícula:");
                            String matricula = sc.nextLine();
                            aluno.setMatricula(matricula);
                        }
                        case 3 -> {
                            System.out.println("Digite o novo CPF:");
                            String cpf = sc.nextLine();
                            aluno.setCpf(cpf);
                        }
                        case 0 -> System.out.println("...Voltando ao Menu anterior...");
                        default -> System.out.println("Opção inválida. Tente novamente.");
                    }
                } while (option != 0);
                break; // Saímos do loop assim que encontramos o aluno
            }
        }
        if (!alunoEncontrado) {
            System.out.println("CPF não encontrado.");
        }
    }
}


    public static void imprimeListaDeAlunos(){
        if (listaDeAlunos.isEmpty()) {
            System.out.println("Nenhum aluno registrado.");
        } else {
            System.out.println("\nAlunos:");
            for (Aluno aluno : listaDeAlunos) {
                System.out.println("Nome: " + aluno.getNome()); // Isso vai chamar o método toString() de Aluno
                System.out.println("CPF: " + aluno.getCpf());
                System.out.println();
            }
        }
    }


    public Aluno(int id, String cpf, String nome, String telefone, String email,
        Endereco endereco, String matricula, Turma turma, ModalidadeEnsino modalidade) {
        super(id, cpf, nome, telefone, email, endereco, matricula);
        this.turma = turma;
        this.modalidade = modalidade;
        this.matriculadoEm = LocalDateTime.now();
    }
    public String dataMatricula() {
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String customFormattedDate = today.format(customFormatter);
        return customFormattedDate;
    }

    public void exibirDadosAluno() {
        int opcao = -1;
        do {
            Scanner sc = new Scanner(System.in);
                    try {
                        System.out.println("\n--- MENU PRINCIPAL ---");
                        System.out.println("1- Notas ");
                        System.out.println("2- Menu Diretor");
                        System.out.println("3- Menu Professor");
                        System.out.println("0- Sair");
                        System.out.print("Escolha uma opção: ");
                        opcao = sc.nextInt();

                        switch (opcao) {
                            case 1:
                                System.out.println("Informe o nome do aluno");
                                String nomeAluno = sc.nextLine();
                                if(nomeAluno.equals(getNome()))
                                break;
                            case 2:

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
        // System.out.println("\nID do aluno: " + this.getEndereco().getId());
        // System.out.printf("Modalidade: %s%n", this.getModalidade());
        // System.out.println("Turma : " + this.getTurma().getNumero());
        // System.out.println("\nAluno: " + this.getNome());
        // System.out.println("CPF : " + this.getCpf());
        // System.out.println("Matrícula: " + this.getMatricula());
        // System.out.println("Data da matrícula: " + this.dataMatricula());
        // System.out.println("Telefone : " + this.getTelefone());
        // System.out.println("EMAIL: " + this.getEmail() + "\n");
        // System.out.println("Rua: " + this.getEndereco().getLogradouro());
        // System.out.println("Número: " + this.getEndereco().getNumero());
        // System.out.println("Complemento: " + this.getEndereco().getComplemento());
        // System.out.println("Bairro: " + this.getEndereco().getBairro());
        // System.out.println("Cidade: " + this.getEndereco().getCidade());
        // System.out.println("Estado: " + this.getEndereco().getUnidade() + " - "+ this.getEndereco().getUnidade().getNomePorExtenso()+"\n");
    }
}
