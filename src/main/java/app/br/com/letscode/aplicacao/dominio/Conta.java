package app.br.com.letscode.aplicacao.dominio;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Conta {
    private String numeroConta;
    private String senha;
    private Usuario usuario;
    private String caminhoArquivo;
}
