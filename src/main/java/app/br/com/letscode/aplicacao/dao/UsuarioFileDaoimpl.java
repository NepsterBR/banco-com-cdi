package app.br.com.letscode.aplicacao.dao;

import app.br.com.letscode.aplicacao.dominio.Usuario;

import java.io.FileWriter;
import java.io.PrintWriter;

public class UsuarioFileDaoimpl implements UsuarioDAO {

    @Override
    public Usuario criar(Usuario usuario) {
        final var caminhoDoArquivo = "C:\\Users\\gabri\\IdeaProjects\\Banco-com-CDI\\src\\main\\java\\app\\br\\com\\letscode\\aplicacao\\arquivos/usuarios.txt";
        try (var arquivo = new FileWriter(caminhoDoArquivo, false)) {
            var escreverArquivo = new PrintWriter(arquivo);
            escreverArquivo.printf("%s%n%s%n%s", usuario.getNome(), usuario.getIdade(), usuario.getCpf());
        } catch (Exception ex) {
            System.out.println("Não foi possivel criar o arquivo");
        }
        return usuario;
    }


}
