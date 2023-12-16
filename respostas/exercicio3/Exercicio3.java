package respostas.exercicio3;
import java.util.Scanner;

public class Exercicio3 { //Problema que não consegui resolver 100% com lógica
    //Então tive que apelar pra matemática...
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Digite o tamanho da maior base do triângulo: ");
        int mb = scanner.nextInt();
        System.out.printf("Deseja imprimir a parte de baixo: [s/n]");
        String imprime_embaixo = scanner.next();
        imprime_embaixo=imprime_embaixo.toLowerCase();
        scanner.close();

        // Parte de cima
        for (int i=mb;i>=0;i-=2){
            int espaco_em_branco=Math.round(i/2);
            if (mb%2==0 && i==mb){ //Bypass pra ele não printar a primeira linha caso o número seja par.
                continue; //Feito justamente pra não ter uma linha totalmente vazia.
            }
            for (int j=0;j<espaco_em_branco;j++){
                System.out.printf(" ");
            }
            for (int j=0;j<mb-2*espaco_em_branco;j++){
                System.out.printf("*");
            }
            for (int j=0;j<espaco_em_branco;j++){
                System.out.printf(" ");
            }
            System.out.println();
        }

        if (imprime_embaixo.equals("s")){
            for (int i=3;i<=mb;i+=2){
                int espaco_em_branco=Math.round(i/2);
                for (int j=0;j<espaco_em_branco;j++){
                    System.out.printf(" ");
                }
                for (int j=0;j<mb-2*espaco_em_branco;j++){
                    System.out.printf("*");
                }
                for (int j=0;j<espaco_em_branco;j++){
                    System.out.printf(" ");
                }
                System.out.println();
            }
        }
    }
}
