package app.br.com.letscode.aplicacao.view;

import app.br.com.letscode.aplicacao.aplicacao.Aplicacao;
import app.br.com.letscode.aplicacao.dominio.ContaEnum;
import app.br.com.letscode.aplicacao.dominio.Usuario;
import app.br.com.letscode.aplicacao.exceptions.PrecondicaoException;
import app.br.com.letscode.aplicacao.exceptions.UserInvalidoException;
import app.br.com.letscode.aplicacao.service.ContaFactory;
import app.br.com.letscode.aplicacao.service.ContaService;
import app.br.com.letscode.aplicacao.service.UsuarioService;

import javax.inject.Inject;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Scanner;

public class UsuarioViewImpl implements UsuarioView {


    @Inject
    private UsuarioService usuarioService;

    @Override
    public Usuario create(Scanner input) {
        Usuario usuario = new Usuario();
        System.out.print("Informe seu nome de usúario: ");
        usuario.setNome(input.next());
        System.out.printf("Informe a seu CPF %s: ", usuario.getNome());
        usuario.setCpf(input.next());
        System.out.printf("Informe a sua idade %s: ", usuario.getNome());
        usuario.setIdade(input.nextInt());
        try {
            usuarioService.create(usuario);
        } catch (PrecondicaoException | IOException ex) {
            System.err.println(ex.getMessage());
            System.out.println();
            System.out.println("Gostaria de tentar novamente?\n" +
                    "1- Sim \n2- Não");
            int opcao = 0;
            opcao = input.nextInt();
            switch (opcao) {
                case 1:
                    return create(input);
                case 2:
                    System.exit(0);
            }

        }
        System.out.printf("Usúario %s criado com sucesso. \n", usuario.getNome());
        return new Usuario();
    }

    @Override
    public String getUsuario(Scanner input) {
        Aplicacao aplicacao = new Aplicacao();
        System.out.print("Digite seu cpf: ");
        String cpf = input.next();
        return aplicacao.getNomeDeUsuario(cpf);
    }

}
