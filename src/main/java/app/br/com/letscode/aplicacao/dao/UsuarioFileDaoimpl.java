package app.br.com.letscode.aplicacao.dao;

import app.br.com.letscode.aplicacao.dominio.Usuario;

public class UsuarioFileDaoimpl implements UsuarioDAO{
    @Override
    public Usuario create(Usuario usuario) {
        usuario.setCaminhoArquivo("caminho do usúario");
        System.out.println("passou na persistencia");
        return usuario;
    }
}
