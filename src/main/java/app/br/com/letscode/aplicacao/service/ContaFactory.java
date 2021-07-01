package app.br.com.letscode.aplicacao.service;

import app.br.com.letscode.aplicacao.annotationLiteral.ContaAnnotationLiteral;
import app.br.com.letscode.aplicacao.dominio.ContaEnum;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

public class ContaFactory {

    @Inject
    @Any
    private Instance<ContaService> contaServiceInstance;

    public ContaService creatConta(ContaEnum contaEnum){
       final ContaAnnotationLiteral literal = new ContaAnnotationLiteral(contaEnum);
       return contaServiceInstance.select(literal).get();
    }
}
