import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CAIXA DE PAGAMENTO ===");
        System.out.println("Escolha a forma de pagamento:");
        System.out.println("1 - Cartão de Crédito");
        System.out.println("2 - PIX");
        System.out.println("3 - Dinheiro");
        System.out.println("4 - Cartão de Débito");
        System.out.print("Opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o valor da compra: R$ ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        String data = "09/03/2026";
        Pagamento pagamento = null;

        switch (opcao) {
            case 1:
                System.out.print("Digite o nome do titular: ");
                String nomeTitularCredito = scanner.nextLine();

                System.out.print("Digite o número do cartão: ");
                String numeroCartaoCredito = scanner.nextLine();

                System.out.print("Deseja parcelar? (s/n): ");
                String resposta = scanner.nextLine();

                int parcelas = 1;
                double taxaJuros = 0.0;

                if (resposta.equalsIgnoreCase("s")) {
                    System.out.print("Digite a quantidade de parcelas: ");
                    parcelas = scanner.nextInt();
                    scanner.nextLine();

                    if (parcelas > 4) {
                        taxaJuros = parcelas * 1.5;
                    }
                }

                pagamento = new CartaoCredito(
                        valor,
                        data,
                        numeroCartaoCredito,
                        nomeTitularCredito,
                        parcelas,
                        taxaJuros
                );
                break;

            case 2:
                pagamento = new Pix(valor, data);
                break;

            case 3:
                System.out.print("Digite o valor recebido: R$ ");
                double valorRecebido = scanner.nextDouble();
                scanner.nextLine();

                pagamento = new Dinheiro(valor, data, valorRecebido);
                break;

            case 4:
                System.out.print("Digite o nome do titular: ");
                String nomeTitularDebito = scanner.nextLine();

                System.out.print("Digite o número do cartão: ");
                String numeroCartaoDebito = scanner.nextLine();

                pagamento = new CartaoDebito(
                        valor,
                        data,
                        numeroCartaoDebito,
                        nomeTitularDebito
                );
                break;

            default:
                System.out.println("Opção inválida.");
                scanner.close();
                return;
        }

        System.out.println();
        pagamento.realizarPagamento();
        System.out.println();
        pagamento.exibirComprovante();

        scanner.close();
    }
}