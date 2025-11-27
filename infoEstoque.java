import java.util.ArrayList;
import java.util.List;

public class infoEstoque {

    private List<Carro> carrosEmEstoque = new ArrayList<>();

    public void adicionarCarro(Carro carro) {
        this.carrosEmEstoque.add(carro);
    }

    public boolean removerCarro(int idCarro) {
        Carro carroParaRemover = carrosEmEstoque.stream()
                .filter(c -> c.idCarro == idCarro)
                .findFirst()
                .orElse(null);

        if (carroParaRemover != null) {
            this.carrosEmEstoque.remove(carroParaRemover);
            return true;
        }
        return false;
    }

    public void listarEstoque() {
        if (carrosEmEstoque.isEmpty()) {
            System.out.println("O estoque está vazio.");
            return;
        }
        System.out.println("--- ESTOQUE ATUAL ---");
        for (Carro carro : carrosEmEstoque) {
            System.out.println("ID: " + carro.idCarro + " | Modelo: " + carro.modeloCarro +
                    " | Ano: " + carro.anoCarro + " | Compra: R$" + carro.valorCompra);
        }
    }

    public List<Carro> getCarrosEmEstoque() {
        return carrosEmEstoque;
    }
}