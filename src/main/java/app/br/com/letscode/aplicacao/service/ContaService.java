package app.br.com.letscode.aplicacao.service;

import app.br.com.letscode.aplicacao.dominio.Conta;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.text.ParseException;

public interface ContaService {

    void criarconta(Conta conta);

    void depositar(BigDecimal depositar) throws FileNotFoundException;

    void sacar(BigDecimal sacar);

    void extrato() throws ParseException;

    void tranferirInvestir();


}
