package app.br.com.letscode.aplicacao.service;

import app.br.com.letscode.aplicacao.dao.UsuarioDAO;
import app.br.com.letscode.aplicacao.dominio.Usuario;
import app.br.com.letscode.aplicacao.exceptions.PrecondicaoException;

import javax.inject.Inject;

public class UsuarioServiceimpl implements UsuarioService{

    @Inject
    private UsuarioDAO usuarioDAO;

    @Override
    public Usuario create(Usuario usuario) throws PrecondicaoException {
        System.out.println("passou aqui");
        if (usuario.getIdade() > 18){
            return usuarioDAO.create(usuario);
        }
        throw new PrecondicaoException("Usuario com precondições não satisfeitas");
    }
}
