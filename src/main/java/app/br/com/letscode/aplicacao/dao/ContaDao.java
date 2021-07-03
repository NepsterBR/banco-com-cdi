package app.br.com.letscode.aplicacao.dao;

import app.br.com.letscode.aplicacao.dominio.Conta;

import java.math.BigDecimal;

public interface ContaDao {
    Conta criar(Conta conta);
    void alterar(BigDecimal saldo, String  senha, String conta, String contaEnum);
}
