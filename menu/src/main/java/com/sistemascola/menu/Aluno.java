package com.sistemascola.menu;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n- MENU -");
            System.out.println("O que deseja fazer?");
            System.out.println("1- Cadastrar novo aluno");
            System.out.println("2- Atualizar aluno");
            System.out.println("3- Deletar aluno");
            System.out.println("4- Listar alunos");
            System.out.println("0- Sair\n");
            System.out.print("Digite uma opção: ");
            
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
            System.out.println("Atualizar aluno");
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

        if (opcao != 0) {
            System.out.println("\nPressione Enter para retornar ao menu...");
            sc.nextLine();
            sc.nextLine();
        }

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

    public static void imprimeListaDeAlunos(){
        if (listaDeAlunos.isEmpty()) {
            System.out.println("Nenhum aluno registrado.");
        } else {
            System.out.println("\nAlunos:");
            for (Aluno aluno : listaDeAlunos) {
                System.out.println("- " + aluno.getNome()); // Isso vai chamar o método toString() de Aluno
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
        System.out.println("\nID do aluno: " + this.getEndereco().getId());
        System.out.printf("Modalidade: %s%n", this.getModalidade());
        System.out.println("Turma : " + this.getTurma().getNumero());
        System.out.println("\nAluno: " + this.getNome());
        System.out.println("CPF : " + this.getCpf());
        System.out.println("Matrícula: " + this.getMatricula());
        System.out.println("Data da matrícula: " + this.dataMatricula());
        System.out.println("Telefone : " + this.getTelefone());
        System.out.println("EMAIL: " + this.getEmail() + "\n");
        System.out.println("Rua: " + this.getEndereco().getLogradouro());
        System.out.println("Número: " + this.getEndereco().getNumero());
        System.out.println("Complemento: " + this.getEndereco().getComplemento());
        System.out.println("Bairro: " + this.getEndereco().getBairro());
        System.out.println("Cidade: " + this.getEndereco().getCidade());
        System.out.println("Estado: " + this.getEndereco().getUnidade() + " - "+ this.getEndereco().getUnidade().getNomePorExtenso()+"\n");
    }
}
