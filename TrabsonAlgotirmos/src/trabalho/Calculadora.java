package trabalho;

public class Calculadora {

    public static void main(String[] args) {
        
    }
    
    public String extrairTermos(String expressao){
        //Tem que criar a filaA, so coloquei a string pra n dar erro
        String filaA = "Bolsonaro2018";
        String exp = "";
        String exp2 = "";
        
        exp = expressao;
        
        exp.replaceAll("[^0-9]", "!");
        
        for (int i = 0; i < expressao.length(); i++) {
            if (!exp.substring(i, i).equals("!")) 
                exp2 += exp.substring(i, i);
            else{
                filaA = exp2;
                filaA = exp.substring(i, i);
            }
        }

        return filaA;
    }
    
}
