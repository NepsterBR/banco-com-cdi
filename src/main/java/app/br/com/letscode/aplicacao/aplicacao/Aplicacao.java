package app.br.com.letscode.aplicacao.aplicacao;

import app.br.com.letscode.aplicacao.dominio.Usuario;
import app.br.com.letscode.aplicacao.exceptions.UserInvalidoException;
import app.br.com.letscode.aplicacao.service.ContaService;
import app.br.com.letscode.aplicacao.view.ContaView;
import app.br.com.letscode.aplicacao.view.UsuarioView;
import app.br.com.letscode.aplicacao.view.UsuarioViewImpl;
import lombok.Getter;
import lombok.Setter;


import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class Aplicacao {

    private List<Usuario> usuarios;

    @Inject
    private UsuarioView usuarioView;

    @Inject
    private ContaView contaView;

    @PostConstruct
    public void iniciar() {
        System.out.println("Iniciando a aplicação");
        usuarios = new ArrayList<>();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void createUsuario(Scanner sc) {
        getUsuarios().add(usuarioView.create(sc));
    }

    public void creatConta(Scanner sc){
        contaView.createConta(sc);
    }

    public void autenticarUsuario() {
        try {
            usuarioView.autenticar();
        } catch (UserInvalidoException ex) {
            ex.getMessage();
        }
    }

    public void indice() throws ParseException, FileNotFoundException {
        usuarioView.indice();
    }

//    public Conta createConta (ContaEnum contaEnum, Conta conta){
//        final ContaService contaFactoryConta = contaView.creatConta(contaEnum);
//        return contaFactoryConta.criarconta(conta);
//    }

}
