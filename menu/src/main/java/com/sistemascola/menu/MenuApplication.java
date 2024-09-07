package com.sistemascola.menu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MenuApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenuApplication.class, args);


		//Aluno rafael = new Aluno();
		//rafaEnd1.setCidade("Petropolis");
		Turma turma1 = new Turma(12, "3");
		Endereco rafaEnd1 = new Endereco(12, "Rua silva jardim", "234", "Quadra 2", "Centro", "Petrópolis", "Rio de Janeiro", "12412344" );
        Aluno rafael = new Aluno(1, "1241255", "Rafael", "1241245", "rafa@gmail.com", rafaEnd1, "1455", turma1);
        //Aluno eric = new Aluno("Eric", 12346);


        Disciplina matematica = new Disciplina("Matemática", "MAT101");
        Disciplina ingles = new Disciplina("Inglês", "ING101");
        Disciplina portugues = new Disciplina("Português", "POT101");
        Disciplina ciencias = new Disciplina("Ciências", "CIE101");



        Alunodisciplina rafaelmat = new Alunodisciplina(rafael, matematica, 8.5, 4, 5, 6);
        Alunodisciplina rafaeling = new Alunodisciplina(rafael, ingles, 5.0, 5, 7, 8);
        Alunodisciplina rafaelpot = new Alunodisciplina(rafael, portugues, 3.5, 6, 7, 8);
        Alunodisciplina rafaelcie = new Alunodisciplina(rafael, ciencias, 9.5, 7, 7, 8);

        // Alunodisciplina ericmat = new Alunodisciplina(rafael, matematica, 5.5, 4, 5, 6);
        // Alunodisciplina ericing = new Alunodisciplina(rafael, ingles, 8.0, 5, 3, 8);
        // Alunodisciplina ericpot = new Alunodisciplina(rafael, portugues, 9.5, 9, 10, 8);
        // Alunodisciplina ericcie = new Alunodisciplina(rafael, ciencias, 5.5, 7, 7, 8);

		//rafael.setNome("Rafael");

        rafael.exibirDadosAluno();
        rafaelmat.exibirNotas();
        rafaeling.exibirNotas();
        rafaelpot.exibirNotas();
        rafaelcie.exibirNotas();
		//rafael.getNome();

        // eric.exibirDados();
        // ericmat.exibirNotas();
        // ericing.exibirNotas();
        // ericpot.exibirNotas();
        // ericcie.exibirNotas();

        Endereco Marcosend1 = new Endereco(12, "Rua silva jardim", "234", "Quadra 2", "Centro", "Petrópolis", "Rio de Janeiro", "12412344" );
        Professor Marcos = new Professor(1, "1241255", "Marcos", "1241245", "rafa@gmail.com", Marcosend1, "1455");

        // Adicionando disciplinas ao professor
        Marcos.adicionarDisciplina(matematica);
        Marcos.adicionarDisciplina(ingles);

        // Exibindo as disciplinas do professor
        Marcos.exibirDadosProfessor();
        //Marcos.exibirDisciplinas();
    }
}


