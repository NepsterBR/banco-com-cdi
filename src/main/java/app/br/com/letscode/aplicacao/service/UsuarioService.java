package app.br.com.letscode.aplicacao.service;

import app.br.com.letscode.aplicacao.dominio.Usuario;
import app.br.com.letscode.aplicacao.exceptions.PrecondicaoException;
import app.br.com.letscode.aplicacao.exceptions.UserInvalidoException;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface UsuarioService {
    Usuario create (Usuario usuario) throws PrecondicaoException, IOException;
}
