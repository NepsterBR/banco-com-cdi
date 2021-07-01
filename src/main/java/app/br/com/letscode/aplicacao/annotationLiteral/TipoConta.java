package app.br.com.letscode.aplicacao.annotationLiteral;

import app.br.com.letscode.aplicacao.dominio.ContaEnum;

import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TipoConta {
    ContaEnum value();
}
