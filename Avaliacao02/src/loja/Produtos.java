package loja;

public class Produtos {
    
    private String codigo;
    private String nome;
    private double valor;
    private int estoque;

    public Produtos() {
    }

    public Produtos(String codigo, String nome, double valor, int estoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.estoque = estoque;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public int getEstoque() {
        return estoque;
    }
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return "Código do produto:" + codigo + ", Estocagem" + estoque + ", Nome: " + nome + ", Valor " + valor + "";
    }
     public void subtrairestoque(int subtrairestoque)
     {
         estoque -= subtrairestoque;
     }


}
