package trabalho;

public class FilaVaziaException extends RuntimeException {

    public FilaVaziaException() {
        super("A Fila Esta Vazia!");
    }
}
