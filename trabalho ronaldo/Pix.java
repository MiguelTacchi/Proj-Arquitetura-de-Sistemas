import java.util.Scanner;
import java.util.UUID;

public class Pix extends Pagamento {

    private String chavePix;

    public Pix(double valor, String data) {
        super(valor, data);
        this.chavePix = gerarChavePix();
    }

    private String gerarChavePix() {
        return UUID.randomUUID().toString();
    }

    @Override
    public void realizarPagamento() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== PAGAMENTO VIA PIX ===");
        System.out.println("Valor: R$ " + String.format("%.2f", valor));

        System.out.println("\nChave PIX gerada:");
        System.out.println(chavePix);

        System.out.println("\nCopie a chave acima e cole abaixo para confirmar o pagamento.");
        System.out.print("Cole aqui para pagar: ");

        String chaveDigitada = scanner.nextLine();

        if (chaveDigitada.equals(chavePix)) {
            System.out.println("\nPagamento confirmado!");
        } else {
            System.out.println("\nChave incorreta. Pagamento não confirmado.");
        }
    }
}