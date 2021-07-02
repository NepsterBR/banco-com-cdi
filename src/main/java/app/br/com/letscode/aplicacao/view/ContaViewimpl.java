package app.br.com.letscode.aplicacao.view;

import app.br.com.letscode.aplicacao.dominio.Conta;
import app.br.com.letscode.aplicacao.dominio.ContaEnum;
import app.br.com.letscode.aplicacao.service.ContaFactory;
import app.br.com.letscode.aplicacao.service.ContaService;

import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ContaViewimpl implements ContaView {

    @Inject
    private ContaFactory contaFactory;

    public void createConta(Scanner input) {
        Conta conta = new Conta();
        System.out.println("Qual o tipo de conta a ser criada? \n1- Especial \n2- Poupança");
        int opcao = input.nextInt();
        ContaEnum contaEnum = null;
        switch (opcao) {
            case 1:
                contaEnum = ContaEnum.ESPECIAL;
                break;
            case 2:
                contaEnum = ContaEnum.POUPANÇA;
                break;
            default:
                System.out.println("Selecione uma opção valida");
        }
        ContaService contaService = contaFactory.creatConta(contaEnum);
        if (contaEnum == ContaEnum.ESPECIAL) {
            conta.setNumeroConta("0001");
            System.out.println("Com quanto deseja inicair a conta especial?");
            System.out.println("lembrece que na conta especial, você tem um crédito de R$ 200,00 =)");
            conta.setSaldoCe(input.nextBigDecimal());
            try {
                var lerArquivo = new BufferedReader(new FileReader("user.txt"));
                String usuario = lerArquivo.readLine();
                String password = lerArquivo.readLine();
                conta.setSenha(password);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            conta.setNumeroConta("0002");
            System.out.println("Com quanto deseja inicair a conta poupança?");
            conta.setSaldoCp(input.nextBigDecimal());
            try {
                var lerArquivo = new BufferedReader(new FileReader("user.txt"));
                String usuario = lerArquivo.readLine();
                String password = lerArquivo.readLine();
                conta.setSenha(password);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        contaService.criarconta(conta);
    }
}
