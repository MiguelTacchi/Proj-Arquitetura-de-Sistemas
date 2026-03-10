public class Dinheiro extends Pagamento {

    private double valorRecebido;

    public Dinheiro(double valor, String data, double valorRecebido) {
        super(valor, data);
        this.valorRecebido = valorRecebido;
    }

    public double calcularTroco() {
        return valorRecebido - valor;
    }

    @Override
    public void realizarPagamento() {
        System.out.println("Pagamento em Dinheiro");
        System.out.println("Valor recebido: R$ " + valorRecebido);
        System.out.println("Troco: R$ " + calcularTroco());
    }
}