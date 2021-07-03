package app.br.com.letscode.aplicacao.dao;

import app.br.com.letscode.aplicacao.dominio.Usuario;

import java.io.IOException;

public interface UsuarioDAO {
    Usuario criar(Usuario usuario) throws IOException;
}
