package app.br.com.letscode.aplicacao.dominio;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {
    private String Nome;
    private int idade;
    private Object caminhoArquivo;

    public void setCaminhoArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }
}
