package app.br.com.letscode.aplicacao.exceptions;

public class NoUserException extends RuntimeException{
    public NoUserException(String message) {
        super(message);
    }
}
