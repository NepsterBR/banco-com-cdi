package app.br.com.letscode.aplicacao.aplicacao;

import app.br.com.letscode.aplicacao.dao.UsuarioObDaoimpl;
import app.br.com.letscode.aplicacao.dominio.Usuario;
import app.br.com.letscode.aplicacao.view.UsuarioView;


import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicacao {
    private List<Usuario> usuarios;
    @Inject
    private UsuarioView usuarioView;

    @PostConstruct
    public void iniciar(){
        System.out.println("Iniciando a aplicação");
        usuarios = new ArrayList<>();
    }

    public void createUsuario(Scanner sc){

    }

    public UsuarioView getUsuarioView() {
        return this.usuarioView;
    }
}
