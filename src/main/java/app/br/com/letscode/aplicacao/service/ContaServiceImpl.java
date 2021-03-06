package app.br.com.letscode.aplicacao.service;


import app.br.com.letscode.aplicacao.dao.ContaDao;
import app.br.com.letscode.aplicacao.dominio.Conta;
import app.br.com.letscode.aplicacao.dominio.ContaEnum;

import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;

public class ContaServiceImpl implements ContaService {

    @Inject
    private ContaDao contaDao;

    @Override
    public Conta criarconta(Conta conta) {
        return contaDao.criar(conta);
    }

    @Override
    public void depositar(String conta, BigDecimal depositar) {
        final var caminhoDoArquivo = "C:\\Users\\gabri\\IdeaProjects\\Banco-com-CDI\\src\\main\\java\\app\\br\\com\\letscode\\aplicacao\\arquivos/"
                + conta + ".txt";
        try (var lerArquivo = new BufferedReader(new FileReader(caminhoDoArquivo))) {
            String senha = lerArquivo.readLine();
            String contaEnum = lerArquivo.readLine();
            String saldo = lerArquivo.readLine();
            BigDecimal novoSaldo = new BigDecimal(saldo).add(depositar);
            if (contaEnum.equalsIgnoreCase("POUPANÇA")) {
                BigDecimal taxa = new BigDecimal("0.007");
                novoSaldo = novoSaldo.subtract(taxa);
            }
            contaDao.alterar(novoSaldo, senha, conta, contaEnum);
        } catch (Exception ex) {
            System.out.println("Erro interno, não foi possivel concluir a ação" +
                    " contate o suporte.");
        }
    }

    @Override
    public void sacar(BigDecimal sacar, String conta) {
        final var caminhoDoArquivo = "C:\\Users\\gabri\\IdeaProjects\\Banco-com-CDI\\src\\main\\java\\app\\br\\com\\letscode\\aplicacao\\arquivos/"
                + conta + ".txt";
        try (var lerArquivo = new BufferedReader(new FileReader(caminhoDoArquivo))) {
            String senha = lerArquivo.readLine();
            String contaEnum = lerArquivo.readLine();
            String saldo = lerArquivo.readLine();
            BigDecimal novoSaldo = new BigDecimal(saldo).subtract(sacar);
            if (contaEnum.equalsIgnoreCase("POUPANÇA")) {
                BigDecimal taxa = new BigDecimal("0.007");
                novoSaldo = novoSaldo.subtract(taxa);
            }
            if (contaEnum.equalsIgnoreCase("ESPECIAL")) {
                int limite = novoSaldo.compareTo(new BigDecimal("-201"));
                if (limite < 1) {
                    System.out.println("Você já ultrapassou seu limite");
                    return;
                }
            }
            contaDao.alterar(novoSaldo, senha, conta, contaEnum);
        } catch (Exception ex) {
            System.out.println("Erro interno, não foi possivel concluir a ação" +
                    " contate o suporte.");
        }
    }

    @Override
    public void extrato() {

    }

    @Override
    public boolean logar(String autorizado, String senha) {
        //TODO ler o arquivo com a senha para comparar
        if (autorizado.equals(senha)) {
            System.out.println("Logado com sucesso");
            return true;
        } else {
            System.out.println("Não autorizado, senha incorreta");
            return false;
        }
    }
}
