package app.br.com.letscode.aplicacao.view;

import app.br.com.letscode.aplicacao.dominio.Usuario;
import app.br.com.letscode.aplicacao.exceptions.UserInvalidoException;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public interface UsuarioView {

    Usuario create(Scanner input);

    void autenticar() throws UserInvalidoException;

    void menu();

    void escolheIndice(int indice) throws ParseException, FileNotFoundException;

    void indice() throws ParseException, FileNotFoundException;
}
