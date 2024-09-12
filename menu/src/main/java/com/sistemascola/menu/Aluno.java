package com.sistemascola.menu;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Aluno extends Pessoa {
    private static final Scanner sc = new Scanner(System.in); // Scanner global para entrada de dados

    private Turma turma; // Representa a turma à qual o aluno pertence
    private LocalDateTime matriculadoEm; // Armazena a data e hora da matrícula do aluno
    private ModalidadeEnsino modalidade; // Define o tipo de modalidade de ensino do aluno
    public static List<Aluno> listaDeAlunos = new ArrayList<>(); // Lista estática para armazenar todos os alunos
    private List<Alunodisciplina> listaDisciplinas = new ArrayList<>(); // Lista de disciplinas do aluno

    // Construtor padrão, não inicializa atributos
    public Aluno() {
    }

    // Construtor com parâmetros para criar um aluno com todas as informações necessárias
    public Aluno(int id, String cpf, String nome, String telefone, String email,
                 Endereco endereco, String matricula, Turma turma, ModalidadeEnsino modalidade) {
        super(id, cpf, nome, telefone, email, endereco, matricula); // Inicializa atributos da classe pai (Pessoa)
        this.turma = turma; // Define a turma do aluno
        this.modalidade = modalidade; // Define a modalidade de ensino do aluno
        this.matriculadoEm = LocalDateTime.now(); // Define a data e hora atual como data de matrícula
    }

    // Adiciona uma disciplina à lista de disciplinas do aluno
    public void adicionarDisciplina(Alunodisciplina disciplina) {
        listaDisciplinas.add(disciplina);
    }

    // Retorna a lista de disciplinas do aluno
    public List<Alunodisciplina> getListaDisciplinas() {
        return listaDisciplinas;
    }

    // Exibe o menu para o aluno, permitindo consultar notas
    public static void menuAluno() {
        int opcao = -1;

        do {
            try {
                System.out.println("\n--- MENU ALUNO ---");
                System.out.println("Selecione o aluno para consultar notas:");

                // Exibe todos os alunos registrados, com índices para seleção
                for (int i = 0; i < listaDeAlunos.size(); i++) {
                    System.out.println((i + 1) + " - " + listaDeAlunos.get(i).getNome());
                }

                System.out.print("Escolha um número: ");
                opcao = sc.nextInt();
                sc.nextLine(); // Limpa o buffer do scanner

                // Verifica se o índice selecionado é válido e acessa o aluno correspondente
                Aluno alunoSelecionado = listaDeAlunos.get(opcao - 1);

                // Verifica se o aluno selecionado possui disciplinas cadastradas
                if (alunoSelecionado.getListaDisciplinas().isEmpty()) {
                    System.out.println("Este aluno não está inscrito em nenhuma disciplina.");
                } else {
                    // Exibe as notas de cada disciplina do aluno
                    System.out.println("Notas de " + alunoSelecionado.getNome() + ":");
                    for (Alunodisciplina ad : alunoSelecionado.getListaDisciplinas()) {
                        System.out.println("Disciplina: " + ad.getDisciplina().getNome());
                        System.out.println("Nota 1: " + ad.getNota1());
                        System.out.println("Nota 2: " + ad.getNota2());
                        System.out.println("Nota 3: " + ad.getNota3());
                        System.out.println("Nota 4: " + ad.getNota4());
                        System.out.println("Média: " + (ad.getNota1() + ad.getNota2() + ad.getNota3() + ad.getNota4()) / 4);
                        System.out.println("------------------------");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                sc.next(); // Limpa o buffer do Scanner
            }

            // Solicita que o usuário pressione Enter para continuar, se não tiver escolhido sair
            if (opcao != 0) {
                System.out.println("\nPressione Enter para continuar...");
                sc.nextLine(); // Limpa a nova linha pendente
                sc.nextLine(); // Aguarda o usuário pressionar Enter
            }
        } while (opcao != 0); // Repete até que o usuário escolha sair
    }

    // Cadastra um novo aluno na lista
    public static void cadastrarNovoAluno() {
        System.out.println("-CADASTRAR ALUNO-");

        // Solicita informações do novo aluno
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        Aluno aluno = new Aluno();
        aluno.setNome(nome);

        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        aluno.setCpf(cpf);

        // Adiciona o aluno à lista de alunos
        listaDeAlunos.add(aluno);

        System.out.println("Aluno cadastrado com sucesso!\n");
    }

    // Remove um aluno da lista com base na seleção do usuário
    public static void deletarAluno() {
        System.out.println("-DELETAR ALUNO-");

        if (listaDeAlunos.isEmpty()) {
            System.out.println("Nenhum aluno registrado.");
        } else {
            // Exibe a lista de alunos para o usuário selecionar
            System.out.println("\nAlunos:");
            for (int i = 0; i < listaDeAlunos.size(); i++) {
                System.out.println((i + 1) + " - " + listaDeAlunos.get(i).getNome());
            }
            System.out.print("Digite o número do aluno que deseja deletar: ");
            int numeroDeletar = sc.nextInt();
            sc.nextLine(); // Limpar o buffer do scanner

            // Remove o aluno da lista com base no número selecionado
            if (numeroDeletar > 0 && numeroDeletar <= listaDeAlunos.size()) {
                listaDeAlunos.remove(numeroDeletar - 1);
                System.out.println("Aluno deletado com sucesso.");
            } else {
                System.out.println("Número inválido.");
            }
        }
    }

    // Atualiza as informações de um aluno específico
    public static void atualizarAluno() {
        System.out.print("Digite o CPF do aluno que deseja atualizar: ");
        String cpfDigitado = sc.nextLine();

        Aluno alunoParaAtualizar = null;
        // Encontra o aluno com o CPF informado
        for (Aluno aluno : listaDeAlunos) {
            if (aluno.getCpf().equals(cpfDigitado)) {
                alunoParaAtualizar = aluno;
                break;
            }
        }

        // Se o aluno for encontrado, exibe um menu para atualizar suas informações
        if (alunoParaAtualizar != null) {
            int option;
            do {
                // Mostra as informações atuais do aluno
                System.out.printf("""
                        ° Nome: %s
                        ° CPF: %s
                        ° Matrícula: %s
                        """, alunoParaAtualizar.getNome(), alunoParaAtualizar.getCpf(), alunoParaAtualizar.getMatricula());

                // Exibe opções para atualizar as informações do aluno
                System.out.println("""
                        O que deseja atualizar?
                        Digite 1 para ALTERAR o NOME
                        Digite 2 para ALTERAR a MATRICULA
                        Digite 3 para ALTERAR o CPF
                        Digite 0 para SAIR
                        """);

                option = sc.nextInt();
                sc.nextLine(); // Limpar o buffer do scanner

                // Atualiza a informação escolhida pelo usuário
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
            } while (option != 0); // Continua até o usuário escolher sair
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    // Imprime a lista de todos os alunos cadastrados
    public static void imprimeListaDeAlunos() {
        if (listaDeAlunos.isEmpty()) {
            System.out.println("Nenhum aluno registrado.");
        } else {
            // Exibe nome e CPF de cada aluno
            System.out.println("\nAlunos:");
            for (Aluno aluno : listaDeAlunos) {
                System.out.println("Nome: " + aluno.getNome());
                System.out.println("CPF: " + aluno.getCpf());
                System.out.println();
            }
        }
    }

    // Retorna a data e hora atual formatada
    public String dataMatricula() {
        LocalDateTime today = LocalDateTime.now(); // Obtém a data e hora atual
        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); // Define o formato desejado
        return today.format(customFormatter); // Formata e retorna a data e hora
    }
}
