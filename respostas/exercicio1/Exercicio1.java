package respostas.exercicio1;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.printf("Informe o valor do empréstimo: ");
        double total_saldo_devedor = scanner.nextDouble();
        System.out.printf("a taxa de juros do empréstimo: ");
        double juros_ao_mes = scanner.nextDouble()/100.00;
        System.out.printf("o tempo para pagamento: ");
        int total_de_meses = scanner.nextInt();
        scanner.close();

        final double amortizacao = total_saldo_devedor / total_de_meses;
        //Inicia-se a variavel saldo devedor com a fórmula aplicada ao total.
        double saldo_devedor_atual = total_saldo_devedor;
        double juros_mensal;
        double parcela_mensal;
        double total_juros=0;

        System.out.printf("Valor fixo da amortização R$ %.2f, Saldo devedor total R$ %.2f com um juros de %.1f ao mês\n", amortizacao, total_saldo_devedor, juros_ao_mes*100.0);
        for (int i=1; i<=total_de_meses;i++){
            juros_mensal = saldo_devedor_atual * juros_ao_mes;
            parcela_mensal = juros_mensal + amortizacao;
            saldo_devedor_atual -= amortizacao;
            total_juros+=juros_mensal;
            System.out.printf("Parcela %d | Juros: R$ %.2f | Prestação: R$ %.2f | Saldo devedor: R$ %.2f\n", i, juros_mensal, parcela_mensal, saldo_devedor_atual);
        }
        System.out.printf("Total: Prestação R$ %.2f, Juros R$ %.2f, Amortização R$ %.2f", total_saldo_devedor+total_juros, total_juros, total_saldo_devedor);
    }
}
