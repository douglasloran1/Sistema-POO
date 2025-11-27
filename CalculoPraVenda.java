import java.util.ArrayList;
import java.util.Arrays;


public class CalculoPraVenda {
  
  public double lucro;
  public double valorFinal;
  public double margemLucro;

  // to pegando todos as despesas e colocando em um array
  public void TodosServ(String descricao ,double valorServ , int idServico){

    ArrayList<Servico> servicoFeitos = new ArrayList<>();
     
    Servico valorDoServico = new Servico(descricao ,valorServ ,idServico);
    
   servicoFeitos.add(valorDoServico);
  }

  public void calculoTotalServ(ArrayList<Servico> servicosFeito){
                    
                  // aqui ele transforma em um fluxo
    double total = servicosFeito.stream()
    .mapToDouble(s -> s.valorServ).sum();// depois pega cada valor transforma em um double separado
    // depois no sum ele soma todos

    System.out.println(" TOTAL DE SERVIÇOS " + total);
  }

  public void calculoPraVender(double valorCompra , double total){
    valorFinal = valorCompra + total + lucro ;
    margemLucro = (lucro / valorFinal) * 100;
  }
  

}
