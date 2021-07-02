package app.br.com.letscode.aplicacao.view;

import app.br.com.letscode.aplicacao.dominio.Usuario;
import app.br.com.letscode.aplicacao.exceptions.PrecondicaoException;
import app.br.com.letscode.aplicacao.exceptions.UserInvalidoException;
import app.br.com.letscode.aplicacao.service.ContaPoupancaServiceImpl;
import app.br.com.letscode.aplicacao.service.ContaService;
import app.br.com.letscode.aplicacao.service.UsuarioService;

import javax.inject.Inject;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Scanner;

public class UsuarioViewImpl implements UsuarioView {

    private final ContaService contaService = new ContaPoupancaServiceImpl();

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
        System.out.printf("%s, agora Defina sua senha: ", usuario.getNome());
        usuario.setSenha(input.next());
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
    public void autenticar() throws UserInvalidoException {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        Scanner input = new Scanner(System.in);
        System.out.println("é necessário estar autenticado para prosseguir.\n");
        System.out.print("Insira seu usuário: ");
        String user = input.nextLine();
        System.out.print("Insira sua senha: ");
        String senha = input.nextLine();
        try {
            usuarioService.autenticar(user, senha);
        } catch (UserInvalidoException | FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            autenticar();
        }
    }

    @Override
    public void menu() {
        System.out.println();
        System.out.println("___--- O que deseja fazer?---____");
        System.out.println(" 1 - Consultar Extrato");
        System.out.println(" 2 - Transferir");
        System.out.println(" 3 - Sacar");
        System.out.println(" 4 - Depositar");
        System.out.println(" 5 - Deslogar do sistema");
        System.out.println("__________________________________");
        System.out.print("indice: ");
    }

    @Override
    public void indice() throws ParseException, FileNotFoundException {
        int indice;
        Scanner input = new Scanner(System.in);
        do {
            menu();
            indice = input.nextInt();
            escolheIndice(indice);
        } while (indice != 5);
    }

    @Override
    public void escolheIndice(int indice) throws ParseException, FileNotFoundException {
        switch (indice) {
            case 1:
                for (int i = 0; i < 50; i++) {
                    System.out.println();
                }
                contaService.extrato();
                break;
            case 2:
                for (int i = 0; i < 50; i++) {
                    System.out.println();
                }
                contaService.tranferirInvestir();
                break;
            case 3:
                for (int i = 0; i < 50; i++) {
                    System.out.println();
                }
                contaService.sacar(new BigDecimal("0"));
                break;
            case 4:
                for (int i = 0; i < 50; i++) {
                    System.out.println();
                }
                contaService.depositar(new BigDecimal("0"));
                break;
            case 5:
                for (int i = 0; i < 50; i++) {
                    System.out.println();
                }
                System.out.println("Até Breve :)");
        }
    }
}
