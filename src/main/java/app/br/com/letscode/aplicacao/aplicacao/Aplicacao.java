package app.br.com.letscode.aplicacao.aplicacao;

import app.br.com.letscode.aplicacao.dominio.ContaEnum;
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
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class Aplicacao {


    @Inject
    private UsuarioView usuarioView;

    @Inject
    private ContaView contaView;

    public void createUsuario(Scanner sc) {
        usuarioView.create(sc);
    }

    public void creatConta(Scanner sc, String cpf) {
        contaView.createConta(sc, cpf);
    }

    public void deposito(String conta) {
        contaView.depositar(conta);
    }

    public void saldo(String conta) {
        contaView.saldo(conta);
    }

    public void sacar(String conta) {
        contaView.sacar(conta);
    }

    public String getNomeDeUsuario(String cpf) {
        final var caminhoDoArquivo = "C:\\Users\\gabri\\IdeaProjects\\Banco-com-CDI\\src\\main\\java\\app\\br\\com\\letscode\\aplicacao\\arquivos/usuarios.txt";
        try (var arquivo = new BufferedReader(new FileReader(caminhoDoArquivo))) {
            var validacao = arquivo.readLine();
            while (validacao != null) {
                arquivo.readLine();
                validacao = arquivo.readLine();
                if (cpf.equalsIgnoreCase(validacao)) {
                    return cpf;
                }
                validacao = arquivo.readLine();
            }
        } catch (Exception ex) {
            System.out.println("Não foi possivel encontrar o usuario");
        }
        return null;
    }

    public boolean getConta(String conta, ContaEnum contaEnum) {
        final var caminhoDoArquivo = "C:\\Users\\gabri\\IdeaProjects\\Banco-com-CDI\\src\\main\\java\\app\\br\\com\\letscode\\aplicacao\\arquivos/" +
                 conta + contaEnum + ".txt";
        try (var arquivo = new BufferedReader(new FileReader(caminhoDoArquivo))) {
            String busca = arquivo.readLine();
            return  contaView.logar(busca);
        } catch (Exception ex) {
            System.out.println("Desculpe, você não tem uma conta do tipo " +
                    contaEnum);
            return false;
        }
    }

    public String getUsuario(Scanner input){
        return usuarioView.getUsuario(input);
    }
}



