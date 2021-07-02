package app.br.com.letscode.aplicacao.dao;

import app.br.com.letscode.aplicacao.dominio.Conta;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CantaDaoImpl implements ContaDao{
    @Override
    public void createPoupanca(Conta conta){
        final var caminhoDoArquivo = "contaPoupança.txt";
        try (var arq = new FileWriter(caminhoDoArquivo, false)) {
            var writeArq = new PrintWriter(arq);
            writeArq.printf("%s%n%s%n%s", conta.getNumeroConta(), conta.getSaldoCp(), conta.getSenha());
        }catch (IOException ignored){
        }
    }

    @Override
    public void createEspecial(Conta conta){
        final var caminhoDoArquivo = "contaEspecial.txt";
        try (var arq = new FileWriter(caminhoDoArquivo, false)) {
            var writeArq = new PrintWriter(arq);
            writeArq.printf("%s%n%s%n%s", conta.getNumeroConta(), conta.getSaldoCe(), conta.getSenha());
        }catch (IOException ignored){
        }
    }
}
