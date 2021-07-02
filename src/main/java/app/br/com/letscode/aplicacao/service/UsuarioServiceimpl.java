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


public class UsuarioServiceimpl implements UsuarioService{

    @Inject
    private UsuarioDAO usuarioDAO;

    @Override
    public Usuario create(Usuario usuario) throws PrecondicaoException, IOException {
        if (usuario.getIdade() >= 18){
            return usuarioDAO.create(usuario);
        }
        throw new PrecondicaoException("Usuario com precondições não satisfeitas");
    }

    @Override
    public Usuario autenticar(String user, String senha) throws UserInvalidoException, FileNotFoundException {
        String usuario = "";
        String password ="";
        try (var lerArquivo = new BufferedReader(new FileReader("user.txt"))) {
            usuario = lerArquivo.readLine();
            password = lerArquivo.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (usuario.equalsIgnoreCase(user) && password.equals(senha)){
            System.out.println("Autenticado com sucesso\n");
        }else{
            throw new UserInvalidoException("Login ou senha invalidos");}
        return new Usuario();
    }
}
