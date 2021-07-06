package app.br.com.letscode.aplicacao.dao;

import app.br.com.letscode.aplicacao.dominio.Conta;
import app.br.com.letscode.aplicacao.dominio.ContaEnum;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;

public class CantaDaoImpl implements ContaDao{
    @Override
    public Conta criar(Conta conta){
        final var caminhoDoArquivo = "C:\\Users\\gabri\\IdeaProjects\\Banco-com-CDI\\src\\main\\java\\app\\br\\com\\letscode\\aplicacao\\arquivos/"  +
                conta.getNumeroConta() + conta.getContaEnum() + ".txt";
        if (conta.getContaEnum() == ContaEnum.ESPECIAL){
            conta.setSaldo(new BigDecimal(400));
        }
        if (conta.getContaEnum() == ContaEnum.POUPANÇA){
            conta.setSaldo(new BigDecimal(100));
        }
        try (var arquivo = new FileWriter(caminhoDoArquivo, false)) {
            var escreverArquivo = new PrintWriter(arquivo);
            escreverArquivo.printf("%s%n%s%n%s%n", conta.getSenha(), conta.getContaEnum(), conta.getSaldo());
        } catch (Exception ex) {
            System.out.println("Não foi possivel criar o arquivo");
        }
        return conta;
    }

    @Override
    public void alterar(BigDecimal saldo, String  senha, String conta, String contaEnum){
        final var caminhoDoArquivo = "C:\\Users\\gabri\\IdeaProjects\\Banco-com-CDI\\src\\main\\java\\app\\br\\com\\letscode\\aplicacao\\arquivos/" +conta+".txt";
        try (var arquivo = new FileWriter(caminhoDoArquivo, false)) {
            var escreverArquivo = new PrintWriter(arquivo);
            escreverArquivo.printf("%s%n%s%n%s%n",senha,contaEnum, saldo);
        } catch (Exception ex) {
            System.out.println("Não foi possivel criar o arquivo");
        }
    }
}
