package app.br.com.letscode.aplicacao.view;

import app.br.com.letscode.aplicacao.dominio.Conta;
import app.br.com.letscode.aplicacao.dominio.ContaEnum;
import app.br.com.letscode.aplicacao.service.ContaService;

import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.Scanner;

public class ContaViewimpl implements ContaView {

    @Inject
    private ContaService contaService;

    @Override
    public boolean logar(String senha) {
        System.out.println("Informe sua senha");
        String senhaInformada = new Scanner(System.in).next();
        return contaService.logar(senha,senhaInformada);
    }




    public Conta createConta(Scanner input, String cpf) {
        for (int i = 0; i<50; i++){
        }
        var conta = new Conta();
        conta.setNumeroConta(cpf);
        System.out.println("Qual o tipo de conta a ser criada? \n1- Especial \n2- Poupança");
        int opcao = input.nextInt();
        switch (opcao) {
            case 1:
                conta.setContaEnum(ContaEnum.ESPECIAL);
                break;
            case 2:
                conta.setContaEnum(ContaEnum.POUPANÇA);
                break;
            default:
                System.out.println("Selecione uma opção valida");
        }

        System.out.println("Escolha a senha da sua conta");
        conta.setSenha(input.next());

        if (conta.getContaEnum().equals(ContaEnum.ESPECIAL)) {
            conta.setSaldo(new BigDecimal("400"));
        } else if (conta.getContaEnum().equals(ContaEnum.POUPANÇA)) {
            conta.setSaldo(new BigDecimal("0"));
        }
        contaService.criarconta(conta);
        return conta;

    }

    @Override
    public void sacar(String conta) {
        System.out.println("Quanto deseja sacar?");
        BigDecimal sacar = new Scanner(System.in).nextBigDecimal();
        contaService.sacar(sacar,conta);
    }

    @Override
    public void saldo(String conta) {
        final var caminhoDoArquivo = "C:\\Users\\gabri\\IdeaProjects\\Banco-com-CDI\\src\\main\\java\\app\\br\\com\\letscode\\aplicacao\\arquivos/"
                + conta + ".txt";
        try (var lerArquivo = new BufferedReader(new FileReader(caminhoDoArquivo))){
            String senha = lerArquivo.readLine();
            String tipoConta = lerArquivo.readLine();
            String saldo = lerArquivo.readLine();
            System.out.println("O Saldo atual é de R$" + saldo);
        } catch (Exception ex) {
            System.out.println("Erro interno, não foi possivel concluir a ação" +
                    "c ontate o suporte.");
        }
    }

    @Override
    public void depositar(String conta) {
        System.out.println("Quanto deseja depositar?");
        BigDecimal deposito = new Scanner(System.in).nextBigDecimal();
        contaService.depositar(conta, deposito);

    }
}
