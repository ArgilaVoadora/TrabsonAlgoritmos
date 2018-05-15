package trabalho;

public class Calculadora {
    public FilaVetor<String> extrairTermos(String expressao) {
        expressao = expressao.replaceAll("\\s", "");
        char[] termos = expressao.toCharArray();
        int cont = 0;
        FilaVetor<String> fila = new FilaVetor<>(contTermos(expressao));
        for(int i = 0;i < fila.getLimite();i++){
            String aux = "";        
            for (int i2 = cont;i2 < termos.length;i2++) {
                if (i2 == termos.length - 1) {
                    aux += termos[i2] + "";
                    break;
                } else if (verificaTermos(termos[i2])){
                    aux = termos[i2] + "";
                    cont = i2 + 1;
                    break;
                } else if (verificaTermos(termos[i2 + 1])) { 
                    aux += termos[i2] + "";
                    cont = i2 + 1;
                    break;
                } else {
                    aux += termos[i2];
                }
            }
            fila.inserir(aux);
        }
        return fila;
    }
    
    public FilaVetor<String> gerarExprPosfixada(FilaVetor<String> exprInfixada) {
        return null;
    }
    
    public double calcularExprPosfixada(FilaVetor<String> exprPosfixada) {
        return 0.0;
    }
    
    public int contTermos(String expressao) {
        int total = 0;
        char[] termos = expressao.toCharArray();
        
        for (int i = 0;i < termos.length;i++) {
            if (verificaTermos(termos[i]))
                total++;
            else if (i != termos.length - 1) { 
                if (verificaTermos(termos[i + 1])) {
                    total++;
                }
            } else {
                total++;
            }
        }
        
        return total;
    }
    
    public boolean verificaTermos(char s) {
        char[] termos = new char[6];
        termos[0] = '+';
        termos[1] = '-';
        termos[2] = '*';
        termos[3] = '/';
        termos[4] = '(';
        termos[5] = ')';
        
        for (int i = 0;i < termos.length;i++) {
            if (s == termos[i])
                return true;
        }
        return false;
    }
}
