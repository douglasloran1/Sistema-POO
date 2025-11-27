import java.util.ArrayList;
import java.util.List;

public class venda {

    public int idVenda;
    public Cliente cliente;
    public Carro carroVendido;
    public List<Servico> servicosAdicionais;
    public CalculoPraVenda calculoFinal;
    public pagamento detalhesPagamento;

    public venda(int idVenda, Cliente cliente, Carro carroVendido, List<Servico> servicos) {
        this.idVenda = idVenda;
        this.cliente = cliente;
        this.carroVendido = carroVendido;
        this.servicosAdicionais = (servicos != null) ? servicos : new ArrayList<>();
        this.calculoFinal = new CalculoPraVenda();
        this.detalhesPagamento = null;
    }

    public void calcularVenda(double lucroEsperado) {

        // 1. Calcula o total dos serviços
        // Para simplificar, vou calcular a soma aqui também.
        double totalServicos = servicosAdicionais.stream()
                .mapToDouble(s -> s.valorServ).sum();

        // O método na classe CalculoPraVenda já imprime o total
        calculoFinal.calculoTotalServ((ArrayList<Servico>) servicosAdicionais);

        // 2. Define o lucro e calcula o valor final
        calculoFinal.lucro = lucroEsperado;
        calculoFinal.calculoPraVender(carroVendido.valorCompra, totalServicos);
    }

    public void registrarPagamento(String tipoPagamento, int numeroParcelas) {
        if (calculoFinal.valorFinal <= 0) {
            System.out.println("ERRO: Valor final da venda não calculado.");
            return;
        }
        this.detalhesPagamento = new pagamento(calculoFinal.valorFinal, tipoPagamento, numeroParcelas);
        detalhesPagamento.exibirDetalhes();
    }

    public void exibirResumoVenda() {
        System.out.println("\n========= VENDA " + idVenda + " =========");
        System.out.println("CLIENTE: " + cliente.nome + " (CPF: " + cliente.cpf + ")");
        System.out.println("CARRO: " + carroVendido.modeloCarro + " (" + carroVendido.anoCarro + ")");

        System.out.println("VALOR FINAL: R$" + String.format("%.2f", calculoFinal.valorFinal));
        System.out.println("LUCRO: R$" + String.format("%.2f", calculoFinal.lucro) + " (" + String.format("%.2f", calculoFinal.margemLucro) + "%)");

        if (detalhesPagamento != null) {
            System.out.println("PAGAMENTO: " + detalhesPagamento.tipoPagamento);
        }
        System.out.println("===============================");
    }
}