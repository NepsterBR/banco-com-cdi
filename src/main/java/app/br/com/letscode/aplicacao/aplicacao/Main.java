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
        System.out.println("\n____________Bem Vindo______________");
        System.out.println("Vamos começar criando um login e uma senha");
        aplicacao.createUsuario(input);
        aplicacao.autenticarUsuario();
        aplicacao.creatConta(input);
        aplicacao.indice();
    }
}
