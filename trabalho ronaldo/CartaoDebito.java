public class CartaoDebito extends Pagamento {

    private String numeroCartao;
    private String nomeTitular;

    public CartaoDebito(double valor, String data, String numeroCartao, String nomeTitular) {
        super(valor, data);
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
    }

    @Override
    public void realizarPagamento() {
        System.out.println("Pagamento com Cartão de Débito");
        System.out.println("Titular: " + nomeTitular);
        System.out.println("Valor: R$ " + valor);
    }
}