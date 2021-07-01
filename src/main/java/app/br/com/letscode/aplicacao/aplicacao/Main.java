package app.br.com.letscode.aplicacao.aplicacao;




import app.br.com.letscode.aplicacao.dominio.Conta;
import app.br.com.letscode.aplicacao.dominio.ContaEnum;
import app.br.com.letscode.aplicacao.dominio.Usuario;
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
            System.out.println("O que gostaria de fazer? \n 1- Cadastrar usúario \n 2- Criar conta \n 0 - sair \n");
            opcao = input.nextInt();
            definirOpcao(input, opcao, aplicacao);
        }while (opcao >0);
    }

    private static void definirOpcao(Scanner input, int opcao, Aplicacao aplicacao){
        switch (opcao){
            case 1:
                aplicacao.createUsuario(input);
                aplicacao.getUsuarios().stream()
                        .map(Usuario::getCaminhoArquivo).forEach(System.out::println);
                break;
            case 2:
                System.out.println("Tipo da conta \n\t 1- Poupança 2- Especial");
                int opcaoConta = input.nextInt();
                ContaEnum contaEnum = null;
                switch (opcaoConta){
                    case 1:
                        contaEnum = ContaEnum.POUPANÇA;
                        break;
                    case 2:
                        contaEnum = ContaEnum.ESPECIAL;
                        break;
                }
                aplicacao.createConta(contaEnum, new Conta());
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("digite um valor válido");
        }

    }
}
