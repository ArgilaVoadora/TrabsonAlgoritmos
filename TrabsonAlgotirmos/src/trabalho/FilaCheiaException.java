package trabalho;

public class FilaCheiaException extends RuntimeException {

    public FilaCheiaException() {
        super("A Fila Esta Cheia!");
    }
}
