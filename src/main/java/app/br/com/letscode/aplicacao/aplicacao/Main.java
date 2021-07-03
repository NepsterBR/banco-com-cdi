package app.br.com.letscode.aplicacao.aplicacao;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        final WeldContainer container = new Weld().initialize();
        final Aplicacao aplicacao = container.select(Aplicacao.class).get();
        init(aplicacao);
    }

    private static void init(Aplicacao aplicacao) throws ParseException, FileNotFoundException {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        int escolha;
        do {
            System.out.println("____________---------Bem Vindo---------____________");
            System.out.println("O que deseja fazer?" +
                    "\n1- Cadastar Usuario" +
                    "\n2- Fazer Login" +
                    "\n3- Fechar o aplicativo");
            escolha = input.nextInt();
            switch (escolha) {
                case 1:
                    aplicacao.createUsuario(input);
                case 2:
                    login(aplicacao);
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Escolha uma opção válida");
            }
        } while (escolha > 0);
    }

    private static void login(Aplicacao aplicacao) {
        Scanner input = new Scanner(System.in);
        String usuario = aplicacao.getUsuario(input);
        if (usuario != null){
            usuarioAutenticado(aplicacao, usuario);
        }else {
            System.out.println("Usuario é nulo");
        }
    }

    private static void usuarioAutenticado(Aplicacao aplicacao, String cpf) {

    }
}
