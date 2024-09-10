package com.sistemascola.menu;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MenuApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenuApplication.class, args);


		//Aluno rafael = new Aluno();
		//rafaEnd1.setCidade("Petropolis");
		Turma turma1 = new Turma(12, "1");

        Endereco rafaEnd1 = new Endereco(12, "Rua silva jardim", "234", "Quadra 2", "Centro", "Petrópolis",UnidadeFederal.RJ, "12412344" );
        Aluno rafael = new Aluno(1, "1241255", "Rafael", "1241245", "rafa@gmail.com", rafaEnd1, "1455", turma1, ModalidadeEnsino.HIBRIDO);

        Endereco ericEnd1 = new Endereco(12, "Rua silva jardim", "234", "Quadra 2", "Centro", "Petrópolis", UnidadeFederal.RJ, "12412344" );
        Aluno eric = new Aluno(2, "12412355", "Eric", "1241245", "eric@gmail.com", ericEnd1, "1455", turma1, ModalidadeEnsino.PRESENCIAL);
        //Aluno eric = new Aluno("Eric", 12346);

        turma1.adicionarAluno(rafael);
        turma1.adicionarAluno(eric);

        Endereco marcosend1 = new Endereco(12, "Rua silva jardim", "234", "Quadra 2", "Centro", "Petrópolis", UnidadeFederal.AL, "12412344" );
        Professor marcos = new Professor(1, "1241255", "Marcos", "1241245", "Marcos@gmail.com", marcosend1, "1455");
        Endereco Dennyend1 = new Endereco(13, "Rua silva jardim", "234", "Quadra 2", "Centro", "Petrópolis", UnidadeFederal.GO, "12412344" );
        Professor Denny = new Professor(13, "1241255", "Denny", "1241245", "denn@gmail.com", Dennyend1, "1455");

        turma1.adicionarProfessor(marcos);
        turma1.adicionarProfessor(Denny);

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


        // Adicionando disciplinas ao professor
        marcos.adicionarDisciplina(matematica);
        marcos.adicionarDisciplina(ingles);

        // Exibindo as disciplinas do professor
        marcos.exibirDadosProfessor();
        //Marcos.exibirDisciplinas();
        turma1.exibirDadosTurma();
    }
}


