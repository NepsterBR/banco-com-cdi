package app.br.com.letscode.aplicacao.annotationLiteral;

import app.br.com.letscode.aplicacao.dominio.ContaEnum;

import javax.enterprise.util.AnnotationLiteral;

public class ContaAnnotationLiteral extends AnnotationLiteral<TipoConta> implements TipoConta{

    private final ContaEnum contaEnum;

    public ContaAnnotationLiteral(ContaEnum contaEnum) {
        this.contaEnum = contaEnum;
    }

    @Override
    public ContaEnum value() {
        return this.contaEnum;
    }
}
