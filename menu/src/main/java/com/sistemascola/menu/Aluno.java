package com.sistemascola.menu;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Aluno extends Pessoa {
    private static final Scanner sc = new Scanner(System.in); // Scanner global

    private Turma turma;
    private LocalDateTime matriculadoEm;
    private ModalidadeEnsino modalidade;
    public static List<Aluno> listaDeAlunos = new ArrayList<>();
    private List<Alunodisciplina> listaDisciplinas = new ArrayList<>();

    // Construtor padrão
    public Aluno() {
        // Inicialize qualquer coisa se necessário
    }

    // Construtor com parâmetros
    public Aluno(int id, String cpf, String nome, String telefone, String email,
                 Endereco endereco, String matricula, Turma turma, ModalidadeEnsino modalidade) {
        super(id, cpf, nome, telefone, email, endereco, matricula);
        this.turma = turma;
        this.modalidade = modalidade;
        this.matriculadoEm = LocalDateTime.now();
    }

    public void adicionarDisciplina(Alunodisciplina disciplina) {
        listaDisciplinas.add(disciplina);
    }

    public List<Alunodisciplina> getListaDisciplinas() {
        return listaDisciplinas;
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
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                sc.next(); // Limpa o buffer do Scanner
            }

        } while (opcao != 0);
    }

    public static void cadastrarNovoAluno() {
        System.out.println("-CADASTRAR ALUNO-");

        System.out.print("Nome: ");
        String nome = sc.nextLine();
        Aluno aluno = new Aluno();
        aluno.setNome(nome);

        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        aluno.setCpf(cpf);

        listaDeAlunos.add(aluno);

        System.out.println("Aluno cadastrado com sucesso!\n");
    }

    public static void deletarAluno() {
        System.out.println("-DELETAR ALUNO-");

        if (listaDeAlunos.isEmpty()) {
            System.out.println("Nenhum aluno registrado.");
        } else {
            System.out.println("\nAlunos:");
            for (int i = 0; i < listaDeAlunos.size(); i++) {
                System.out.println((i + 1) + " - " + listaDeAlunos.get(i).getNome());
            }
            System.out.print("Digite o número do aluno que deseja deletar: ");
            int numeroDeletar = sc.nextInt();
            sc.nextLine(); // Limpar o buffer do scanner

            if (numeroDeletar > 0 && numeroDeletar <= listaDeAlunos.size()) {
                listaDeAlunos.remove(numeroDeletar - 1);
                System.out.println("Aluno deletado com sucesso.");
            } else {
                System.out.println("Número inválido.");
            }
        }
    }

    public static void atualizarAluno() {
        System.out.print("Digite o CPF do aluno que deseja atualizar: ");
        String cpfDigitado = sc.nextLine();

        Aluno alunoParaAtualizar = null;
        for (Aluno aluno : listaDeAlunos) {
            if (aluno.getCpf().equals(cpfDigitado)) {
                alunoParaAtualizar = aluno;
                break;
            }
        }

        if (alunoParaAtualizar != null) {
            int option;
            do {
                System.out.printf("""
                        ° Nome: %s
                        ° CPF: %s
                        ° Matrícula: %s
                        """, alunoParaAtualizar.getNome(), alunoParaAtualizar.getCpf(), alunoParaAtualizar.getMatricula());

                System.out.println("""
                        O que deseja atualizar?
                        Digite 1 para ALTERAR o NOME
                        Digite 2 para ALTERAR a MATRICULA
                        Digite 3 para ALTERAR o CPF
                        Digite 0 para SAIR
                        """);

                option = sc.nextInt();
                sc.nextLine(); // Limpar o buffer do scanner

                switch (option) {
                    case 1:
                        System.out.print("Digite o novo nome: ");
                        alunoParaAtualizar.setNome(sc.nextLine());
                        break;
                    case 2:
                        System.out.print("Digite a nova matrícula: ");
                        alunoParaAtualizar.setMatricula(sc.nextLine());
                        break;
                    case 3:
                        System.out.print("Digite o novo CPF: ");
                        alunoParaAtualizar.setCpf(sc.nextLine());
                        break;
                    case 0:
                        System.out.println("...Voltando ao Menu anterior...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } while (option != 0);
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public static void imprimeListaDeAlunos() {
        if (listaDeAlunos.isEmpty()) {
            System.out.println("Nenhum aluno registrado.");
        } else {
            System.out.println("\nAlunos:");
            for (Aluno aluno : listaDeAlunos) {
                System.out.println("Nome: " + aluno.getNome());
                System.out.println("CPF: " + aluno.getCpf());
                System.out.println();
            }
        }
    }

    public String dataMatricula() {
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return today.format(customFormatter);
    }
}
