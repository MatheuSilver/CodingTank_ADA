package respostas.exercicio2;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite uma temperatura para ser transformada: ");
        double t = scanner.nextDouble();
        String orig_unid="c";
        String dest_unid="c";
        System.out.println("Informe a unidade de origem da temperatura: [C, K, F]");
        orig_unid = scanner.next();
        orig_unid=orig_unid.toLowerCase();
        if (!orig_unid.equals("c") && !orig_unid.equals("k") && !orig_unid.equals("f")){
            System.out.println("a entrada especificada não é válida");
            scanner.close(); //Corrigindo leak de memória
            return; //Depois de responder o usuário, ele encerra o programa.
        }
        System.out.println("Informe a unidade de destino das temperaturas: [C, K, F]");
        dest_unid = scanner.next();
        dest_unid=dest_unid.toLowerCase();
        if (!dest_unid.equals("c") && !dest_unid.equals("k") && !dest_unid.equals("f")){
            System.out.println("a entrada especificada não é válida");
            scanner.close(); //Mesmo padrão anterior.
            return;
        }
        scanner.close();

        
        double resultado;
        if (dest_unid.equals("f")){
            resultado = converte_para_f(orig_unid, t);
        }else if (dest_unid.equals("k")){
            resultado = converte_para_k(orig_unid, t);
        }else {
            resultado = converte_para_c(orig_unid, t);
        }

        System.out.printf("%,.2f %s = %,.2f %s", t, orig_unid, resultado, dest_unid);



    }

    private static double converte_para_c(String orig_unid, double t){
        double c;
        if (orig_unid.equals("f")){
            c = (t - 32) * 5 / 9;
        }else if (orig_unid.equals("k")){
            c = t - 273.15;
        }else{
            c = t; //Vai que o cara quer converter de Celsius para Celsius... 
        }

        return c;
    }

    private static double converte_para_k(String orig_unid, double t){
        double k;
        if (orig_unid.equals("c")){
            k = 273.15 + t;
        }else if (orig_unid.equals("f")){
            k = converte_para_c("f", t) + 273.15; //Como não temos uma fórmula de fahrenheit para kelvin
            //Apesar de ser possível calcular, considero que não temos essa oportunidade haja vista que a formula não foi dada.
        }else{
            k = t;
        }

        return k;
    }

    private static double converte_para_f(String orig_unid, double t){
        double f;
        if (orig_unid.equals("c")){
            f = (t * 9 / 5) + 32;
        }else if (orig_unid.equals("k")){
            f = (converte_para_c("k", t) * 9 / 5) + 32; //Como não temos uma fórmula de fahrenheit para kelvin
            //Apesar de ser possível calcular, considero que não temos essa oportunidade haja vista que a formula não foi dada.
        }else{
            f = t;
        }

        return f;
    }
}
