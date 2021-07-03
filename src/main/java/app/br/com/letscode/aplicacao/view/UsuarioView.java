package app.br.com.letscode.aplicacao.view;

import app.br.com.letscode.aplicacao.dominio.Usuario;

import java.util.Scanner;

public interface UsuarioView {

    Usuario create(Scanner input);

    String getUsuario(Scanner input)

}
