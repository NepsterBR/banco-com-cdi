package app.br.com.letscode.aplicacao.service;

import app.br.com.letscode.aplicacao.dao.UsuarioDAO;
import app.br.com.letscode.aplicacao.dominio.Usuario;
import app.br.com.letscode.aplicacao.exceptions.PrecondicaoException;
import app.br.com.letscode.aplicacao.exceptions.UserInvalidoException;

import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class UsuarioServiceimpl implements UsuarioService {

    @Inject
    private UsuarioDAO usuarioDAO;

    @Override
    public Usuario create(Usuario usuario) throws PrecondicaoException, IOException {
        if (usuario.getIdade() >= 18) {
            return usuarioDAO.criar(usuario);
        }
        throw new PrecondicaoException("Usuario com precondições não satisfeitas");
    }

}
