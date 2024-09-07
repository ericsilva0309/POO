package com.sistemascola.menu;

public class Aluno extends Pessoa {

    private Turma turma;

    public Aluno(){

    }

    public void exibirDadosAluno() {
        System.out.println("\nID do aluno: " + this.getEndereco().getId());
        System.out.println("Turma : " + this.getTurma().getNumero());
        System.out.println("\nAluno: " + this.getNome());
        System.out.println("CPF : " + this.getCpf());
        System.out.println("Matrícula: " + this.getMatricula());
        System.out.println("Telefone : " + this.getTelefone());
        System.out.println("EMAIL: " + this.getEmail() + "\n");
        System.out.println("Rua: " + this.getEndereco().getLogradouro());
        System.out.println("Número: " + this.getEndereco().getNumero());
        System.out.println("Complemento: " + this.getEndereco().getComplemento());
        System.out.println("Bairro: " + this.getEndereco().getBairro());
        System.out.println("Cidade: " + this.getEndereco().getCidade());
        System.out.println("Estado: " + this.getEndereco().getEstado() + "\n");
    }

    public Aluno(int id, String cpf, String nome, String telefone, String email, Endereco endereco, String matricula, Turma turma) {
        super(id, cpf, nome, telefone, email, endereco, matricula);
        this.turma = turma;
    }
    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
