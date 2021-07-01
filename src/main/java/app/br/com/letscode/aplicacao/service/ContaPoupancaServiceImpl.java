package app.br.com.letscode.aplicacao.service;

import app.br.com.letscode.aplicacao.annotationLiteral.TipoConta;
import app.br.com.letscode.aplicacao.dominio.Conta;
import app.br.com.letscode.aplicacao.dominio.ContaEnum;
import app.br.com.letscode.aplicacao.exceptions.NoUserException;

@TipoConta(value = ContaEnum.POUPANÇA)

public class ContaPoupancaServiceImpl implements ContaService{

    @Override
    public Conta criarconta(Conta conta) {
        System.out.println("Criando conta Poupança");
        conta.setCaminhoArquivo("teste");
        if (conta.getUsuario() == null){
            throw new NoUserException("Usuário inexistente");
        }
        return conta;
    }
}
