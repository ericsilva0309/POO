package com.sistemascola.menu;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Professor extends Pessoa implements Login {

    // Adicione o método toString para a classe Professor

    private String usuario;
    private String senha;
    private List<Disciplina> disciplinas; // Professor pode ter mais de uma disciplina

    public static List <Professor> professores = new ArrayList<Professor>();

    // Construtor com parâmetros
    public Professor(int id, String cpf, String nome, String telefone, String email, Endereco endereco, String matricula) {
        super(id, cpf, nome, telefone, email, endereco, matricula);
        this.disciplinas = new ArrayList<>(); // Inicializando a lista de disciplinas
    }

    // Construtor padrão
    public Professor() {
        this.disciplinas = new ArrayList<>(); // Inicializando a lista
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina); // Adiciona uma disciplina à lista
    }

    public void exibirDisciplinas() {
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina atribuída.");
        } else {
            System.out.printf("Disciplinas do Professor %s: \n", this.getNome());
            for (Disciplina disciplina : disciplinas) {
                System.out.println("- " + disciplina.getNome());
            }
        }
    }

    public void exibirListaDeProfessores(){
            if (professores.isEmpty()) {
                System.out.println("Nenhum professor registrado.");
            } else {
                System.out.println("\nProfessores:");
                for (Professor professor : professores) {
                    System.out.println("- " + professor.getNome()); // Isso vai chamar o método toString() de professor
                }
            }
        }
    @Override
    public boolean acessoPermitido(String login, String senha) {
        if (login.equals(getUsuario()) && senha.equals(getSenha())) {
            return true;
        }
        return false;
    }

    public void exibirDadosProfessor() {
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Email: " + getEmail());
        exibirDisciplinas();
    }
}
