package app.br.com.letscode.aplicacao.dao;

import app.br.com.letscode.aplicacao.dominio.Usuario;

import javax.enterprise.inject.Alternative;

@Alternative
public class UsuarioObDaoimpl implements UsuarioDAO{
    @Override
    public Usuario create(Usuario usuario) {
        return null;
    }
}
