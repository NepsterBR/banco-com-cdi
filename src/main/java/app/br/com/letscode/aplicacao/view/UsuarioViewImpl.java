package app.br.com.letscode.aplicacao.view;

import app.br.com.letscode.aplicacao.dominio.Usuario;
import app.br.com.letscode.aplicacao.service.UsuarioService;

import javax.inject.Inject;
import java.util.Scanner;

public class UsuarioViewImpl implements UsuarioView {

    @Inject
    private UsuarioService usuarioService;


    @Override
    public Usuario create (Scanner input){
        Usuario usuario = new Usuario();
        System.out.println("Informe o nome do usúario");
        usuario.setNome(input.next());
        System.out.println("Informe a idade do usúario");
        usuario.setIdade(input.nextInt());
        usuarioService.create(usuario);
        System.out.printf("Usúario %s criado com sucesso \n", usuario.getNome());
        return usuario;
    }
}