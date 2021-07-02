package app.br.com.letscode.aplicacao.dao;

import app.br.com.letscode.aplicacao.dominio.Conta;

public interface ContaDao {
    void createPoupanca(Conta conta);
    void createEspecial(Conta conta);
}
