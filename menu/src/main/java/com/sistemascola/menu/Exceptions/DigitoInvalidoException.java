package com.sistemascola.menu.Exceptions;

import java.util.InputMismatchException;

public class DigitoInvalidoException extends InputMismatchException{
    public DigitoInvalidoException(String mensagem){
        super(mensagem);
    }
    public void imprimeErro(Exception e){
        System.out.println("\nOpção invalida! Digite um número inteiro\n");
        System.out.println("Erro: " + e.getMessage());
    }

}
