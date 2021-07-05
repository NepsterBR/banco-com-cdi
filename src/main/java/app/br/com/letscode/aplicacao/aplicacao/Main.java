package app.br.com.letscode.aplicacao.aplicacao;

import app.br.com.letscode.aplicacao.dominio.ContaEnum;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final WeldContainer container = new Weld().initialize();
        final Aplicacao aplicacao = container.select(Aplicacao.class).get();
        init(aplicacao);
    }

    private static void init(Aplicacao aplicacao) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        int escolha;
        do {
            for (int i = 0; i<50; i++){

            }
            System.out.println("____________---------Bem Vindo---------____________");
            System.out.println("O que deseja fazer?" +
                    "\n1- Cadastar Usuario" +
                    "\n2- Fazer Login" +
                    "\n3- Fechar o aplicativo");
            escolha = input.nextInt();
            switch (escolha) {
                case 1:
                    for (int i = 0; i<50; i++){

                    }
                    aplicacao.createUsuario(input);
                case 2:
                    for (int i = 0; i<50; i++){

                    }
                    login(aplicacao);
                case 3:
                    for (int i = 0; i<50; i++){

                    }
                    System.exit(0);
                default:
                    System.out.println("Escolha uma opção válida");
            }
        } while (escolha > 0);
    }

    private static void login(Aplicacao aplicacao) {
        Scanner input = new Scanner(System.in);
        String usuario = aplicacao.getUsuario(input);
        if (usuario != null) {
            usuarioAutenticado(aplicacao, usuario);
        } else {
            System.out.println("Usuario é nulo");
        }
    }

    private static void usuarioAutenticado(Aplicacao aplicacao, String cpf) {
        System.out.println("Usúario logado com sucesso");
        int escolha;
        Scanner input = new Scanner(System.in);
        do {
            for (int i = 0; i<50; i++){
            }
            System.out.println("O que deseja fazer?" +
                    "\n1- Cadastar nova conta" +
                    "\n2- Entrar na sua conta" +
                    "\n3- Sair");
            escolha = input.nextInt();
            switch (escolha) {
                case 1:
                    aplicacao.creatConta(input, cpf);
                case 2:
                    String conta = contaLogin(aplicacao, cpf);
                    if (conta != null) {
                        contaAutenticada(aplicacao, conta);
                    }
                    break;
                default:
                    System.out.println("Selecione uma opção valida");
                case 3:
                    System.exit(0);
                    return;
            }
        } while (escolha > 0);
    }

    private static void contaAutenticada(Aplicacao aplicacao, String conta) {
        int escolha;
        do {
            for (int i = 0; i<50; i++){

            }
            System.out.println("Olá! que operação deseja realizar?" +
                    "\n1- Ver seu saldo" +
                    "\n2- Depositar" +
                    "\n3- Sacar");
            var input = new Scanner(System.in);
            escolha = input.nextInt();
            switch (escolha) {
                case 1:
                    for (int i = 0; i<50; i++){
                    }
                    aplicacao.saldo(conta);
                    contaAutenticada(aplicacao, conta);
                    break;
                case 2:
                    for (int i = 0; i<50; i++){
                    }
                    aplicacao.deposito(conta);
                    contaAutenticada(aplicacao, conta);
                    break;
                case 3:
                    for (int i = 0; i<50; i++){
                    }
                    aplicacao.sacar(conta);
                    contaAutenticada(aplicacao, conta);
                    break;
            }
        } while (escolha > 0);
    }

    private static String contaLogin(Aplicacao aplicacao, String cpf) {
        for (int i = 0; i<50; i++){

        }
        System.out.println("EM qual conta deseja logar?" +
                "\n1- Conta Especial" +
                "\n2- Conta Poupança");
        Scanner input = new Scanner(System.in);
        int tipoConta = input.nextInt();

        switch (tipoConta) {
            case 1:
                if (aplicacao.getConta(cpf, ContaEnum.ESPECIAL)) {
                    return cpf + ContaEnum.ESPECIAL;
                }
                break;
            case 2:
                if (aplicacao.getConta(cpf, ContaEnum.POUPANÇA)) ;
                return cpf + ContaEnum.POUPANÇA;
            default:
                System.out.println("Selecine uma opção válida");
        }
        return null;
    }

}

