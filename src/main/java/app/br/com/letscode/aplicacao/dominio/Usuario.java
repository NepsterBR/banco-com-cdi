package app.br.com.letscode.aplicacao.dominio;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {
    private String Nome;
    private Integer idade;
    private String caminhoArquivo;
}
