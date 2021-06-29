package app.br.com.letscode.aplicacao.aplicacao;




import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final WeldContainer container = new Weld().initialize();
        final Aplicacao aplicacao = container.select(Aplicacao.class).get();
        init(aplicacao);
    }

    private static void init(Aplicacao aplicacao){
        int opcao = 0;
        System.out.println("Bem Vindo");
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("O que gostaria de fazer? \n 1- Cadastrar usúario \n 0 - sair ");
            opcao = input.nextInt();
            definirOpcao(input, opcao, aplicacao);
        }while (opcao >0);
    }

    private static void definirOpcao(Scanner input, int opcao, Aplicacao aplicacao){
        switch (opcao){
            case 1:
                aplicacao.getUsuarioView().create(input);
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("digite um valor válido");
        }

    }
}
