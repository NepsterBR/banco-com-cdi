package app.br.com.letscode.aplicacao.view;

import app.br.com.letscode.aplicacao.dominio.Conta;

import java.util.Scanner;

public interface ContaView {

    boolean logar(String senha);
    Conta createConta(Scanner input, String cpf);
    void sacar(String conta);
    void saldo(String conta);
    void depositar(String conta);


}
