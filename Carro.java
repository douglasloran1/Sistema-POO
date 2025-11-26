
public class Carro {

  public String nomeCarro;
  public int anoCarro;
  public double valorCompra;
  public String corCarro;
  public String modeloCarro;
  public int idCarro;

    public Carro(String nome , int ano , double valor, String cor , String modelo , int id){ // construto para pegar os atributos
      this.nomeCarro = nome;
      this.anoCarro = ano;
      this.valorCompra = valor;
      this.corCarro = cor;
      this.modeloCarro = modelo;
      this.idCarro = id;
    }
}
