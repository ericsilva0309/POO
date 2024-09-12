package com.sistemascola.menu;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Alunodisciplina  {

        private Aluno aluno;
        private Disciplina disciplina;
        private double nota1;
        private double nota2;
        private double nota3;
        private double nota4;
        private double media;


        public Alunodisciplina(Aluno aluno, Disciplina disciplina, double nota1, double nota2, double nota3,
                double nota4) {
            this.aluno = aluno;
            this.disciplina = disciplina;
            this.nota1 = nota1;
            this.nota2 = nota2;
            this.nota3 = nota3;
            this.nota4 = nota4;
            calcularMedia();
        }


        private void calcularMedia() {
            this.media = (nota1 + nota2 + nota3 + nota4) / 4;
        }

        

        public void exibirNotas() {
            System.out.println("Disciplina: " + disciplina.getNome());
            System.out.printf("1º BI: %.1f%n",nota1);
            System.out.printf("2º BI: %.1f%n",nota2);
            System.out.printf("3º BI: %.1f%n",nota3);
            System.out.printf("4º BI: %.1f%n%n",nota4);
            System.out.printf("A média em %s é: %.1f%n%n",disciplina.getNome(),media);
        }
    }

