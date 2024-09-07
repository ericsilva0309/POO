package com.sistemascola.menu;

public class Professor extends Pessoa implements Login {

    private String usuario;
    private String senha;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean acessoPermitido(String login, String senha) {
        if (login.equals(getUsuario()) && senha.equals(getSenha())) {
            //System.out.println("Bem vindo ao sistema.");
            return true;
        }
        //System.out.println("Erro. Tente novamente");
        return false;
    }

}
