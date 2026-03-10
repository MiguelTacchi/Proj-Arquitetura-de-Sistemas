public abstract class Pagamento {

    protected double valor;
    protected String data;

    public Pagamento(double valor, String data) {
        this.valor = valor;
        this.data = data;
    }

    public abstract void realizarPagamento();

    public void exibirComprovante() {
        System.out.println("=== COMPROVANTE ===");
        System.out.println("Data: " + data);
        System.out.println("Valor: R$ " + valor);
    }
}