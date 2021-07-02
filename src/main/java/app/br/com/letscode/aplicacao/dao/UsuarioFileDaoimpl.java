package app.br.com.letscode.aplicacao.dao;

import app.br.com.letscode.aplicacao.dominio.Usuario;
import app.br.com.letscode.aplicacao.exceptions.PrecondicaoException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UsuarioFileDaoimpl implements UsuarioDAO{

    @Override
    public Usuario create(Usuario usuario){
        final var caminhoDoArquivo = "user.txt";
        try (var arq = new FileWriter(caminhoDoArquivo, false)) {
            var writeArq = new PrintWriter(arq);
            writeArq.printf("%s%n%s%n%s", usuario.getNome(), usuario.getSenha(), usuario.getCpf());
        }catch (IOException ignored){
        }
        return usuario;
    }


}
