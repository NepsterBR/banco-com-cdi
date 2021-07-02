package app.br.com.letscode.aplicacao.service;

import app.br.com.letscode.aplicacao.annotationLiteral.TipoConta;
import app.br.com.letscode.aplicacao.dao.ContaDao;
import app.br.com.letscode.aplicacao.dominio.Conta;
import app.br.com.letscode.aplicacao.dominio.ContaEnum;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.text.ParseException;

@TipoConta(value = ContaEnum.ESPECIAL)
public class ContaEspecialServiceImpl implements ContaService {

    @Inject
    private ContaDao contaDao;

    @Override
    public void criarconta(Conta conta){

        contaDao.createEspecial(conta);
    }

    @Override
    public void depositar(BigDecimal depositar) {

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
