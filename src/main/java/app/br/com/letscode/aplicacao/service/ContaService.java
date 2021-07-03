package app.br.com.letscode.aplicacao.service;

import app.br.com.letscode.aplicacao.dominio.Conta;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.text.ParseException;

public interface ContaService {

    Conta criarconta(Conta conta);

    void depositar(String conta, BigDecimal depositar);

    void sacar(BigDecimal sacar, String conta);

    void extrato();

    boolean logar(String autorizado, String senha);


}
