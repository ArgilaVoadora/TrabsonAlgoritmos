package trabalho;

public class PilhaVetor<T> implements Pilha<T> {

    private T info[];
    private int limite;
    private int tamanho;

    public PilhaVetor(int limite) {
        this.info = (T[]) new Object[limite];
        this.limite = limite;
        this.tamanho = 0;
    }

    @Override
    public void push(T info) {
        if (limite == tamanho) {
            throw new PilhaCheiaException();
        }

        this.info[tamanho] = info;
        tamanho = tamanho + 1;
    }

    @Override
    public T pop() {
        T valor;
        valor = peek();
        info[tamanho - 1] = null;
        tamanho = tamanho - 1;
        return valor;
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }

        return info[tamanho - 1];
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public void liberar() {
        while (!estaVazia()) {
            pop();
        }
    }

    @Override
    public String toString() {
        String resultado = "";
        for (int i = tamanho - 1; i >= 0; i--) {
            resultado += info[i] + "";
            if (i > 0) {
                resultado += ",";
            }
        }
        return resultado;
    }
}
