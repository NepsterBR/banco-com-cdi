package app.br.com.letscode.aplicacao.service;

import app.br.com.letscode.aplicacao.dominio.Usuario;
import app.br.com.letscode.aplicacao.exceptions.PrecondicaoException;

public interface UsuarioService {
    Usuario create (Usuario usuario) throws PrecondicaoException;
}
