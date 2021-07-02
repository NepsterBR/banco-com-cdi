package app.br.com.letscode.aplicacao.service;

import app.br.com.letscode.aplicacao.annotationLiteral.TipoConta;
import app.br.com.letscode.aplicacao.dao.ContaDao;
import app.br.com.letscode.aplicacao.dominio.Conta;
import app.br.com.letscode.aplicacao.dominio.ContaEnum;
import app.br.com.letscode.aplicacao.dominio.Usuario;

import javax.inject.Inject;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

@TipoConta(value = ContaEnum.POUPANÇA)
public class ContaPoupancaServiceImpl extends Conta implements ContaService {

    protected Scanner input = new Scanner(System.in);

    //coloquei "CANADA", pois não tem Brasil no padrão, concertei o "R$" no sout.
    protected NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.CANADA);

    Usuario usuario = new Usuario();
    Conta conta = new Conta();

    @Inject
    private ContaDao contaDao;

    @Override
    public void criarconta(Conta conta) {

        contaDao.createPoupanca(conta);
    }

    @Override
    public void depositar(BigDecimal depositar) throws FileNotFoundException {
        System.out.println("Quanto deseja depositar na conta poupança? ");
        System.out.print("R$ ");
        depositar = input.nextBigDecimal();
        Scanner nome = new Scanner(new FileReader("user.txt")).useDelimiter("\\n");
        System.out.print( nome + ", você depositou: R" + this.nf.format(depositar));

//        Scanner saldo = new Scanner(new FileReader("contaPoupança.txt")).useDelimiter("\\n");

//        saldo += depositar;

        final var caminhoDoArquivo = "contaPoupança.txt";
        try (var arq = new FileWriter(caminhoDoArquivo, true)) {
            var writeArq = new PrintWriter(arq);
            writeArq.printf("%n%s", conta.getSaldoCp());
        } catch (IOException ignored) {
        }

        System.out.println("Seu saldo atual é de: R" + this.nf.format(getSaldoCp()));
    }

    @Override
    public void sacar(BigDecimal sacar) {

    }

    @Override
    public void extrato() throws ParseException {

    }

    @Override
    public void tranferirInvestir() {

    }
}
