package trabalho;

public class FilaVetor<T> implements Fila<T> {
    private T info[];
    private int limite;
    private int tamanho;
    private int inicio;

    public FilaVetor(int limite) {
        setInfo((T[]) new Object[limite]);
        setLimite(limite);
        setTamanho(0);
        setInicio(0);
    }
    
    @Override
    public void inserir(T valor) {
        if (tamanho == limite)
            throw new FilaCheiaException();
        
        int posicaoInserir;
        posicaoInserir = (inicio + tamanho) % limite;
        info[posicaoInserir] = valor;
        tamanho++;
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public T peek() {
        if (estaVazia())
            throw new FilaVaziaException();
        
        return info[inicio];
    }

    @Override
    public T retirar() {
        if (estaVazia())
            throw new FilaVaziaException();
        T valor = peek();
        info[inicio] = null;
        inicio = (inicio + 1) % limite;
        tamanho++;
        return valor;
    }

    @Override
    public void liberar() {
        for(int i = 0;i < limite;i++) {
            info[i] = null;
        }
        tamanho = 0;
        inicio = 0;
    }

    @Override
    public String toString() {
        String resultado = "";
        for(int i = 0;i < limite;i++) {
            if (info[i] != null) {
                resultado += info[i] + "";
                if (i < limite - 1)
                    resultado += ",";
            }
        }
        return resultado;
    }
    
    public T[] getInfo() {
        return info;
    }

    public void setInfo(T[] info) {
        this.info = info;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }
    
}
