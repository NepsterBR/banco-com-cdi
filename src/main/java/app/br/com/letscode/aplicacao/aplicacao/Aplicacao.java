package app.br.com.letscode.aplicacao.aplicacao;

import app.br.com.letscode.aplicacao.dominio.Conta;
import app.br.com.letscode.aplicacao.dominio.ContaEnum;
import app.br.com.letscode.aplicacao.dominio.Usuario;
import app.br.com.letscode.aplicacao.service.ContaFactory;
import app.br.com.letscode.aplicacao.service.ContaService;
import app.br.com.letscode.aplicacao.view.UsuarioView;
import lombok.Getter;
import lombok.Setter;


import javax.annotation.PostConstruct;
import javax.inject.Inject;
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
    private ContaFactory contaFactory;

    @PostConstruct
    public void iniciar(){
        System.out.println("Iniciando a aplicação");
        usuarios = new ArrayList<>();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void createUsuario(Scanner sc){
        getUsuarios().add(usuarioView.create(sc));
    }

    public Conta createConta (ContaEnum contaEnum, Conta conta){
        final ContaService contaFactoryConta = contaFactory.creatConta(contaEnum);
        return contaFactoryConta.criarconta(conta);
    }
}
