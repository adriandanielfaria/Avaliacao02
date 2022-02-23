package loja;

public class Vendas {
   
    private int datav;
    private int produtov;
    private int qtdvenda;
    
    public Vendas() {
    }

    public Vendas(int itens, Produtos produtos) {
    }

    public int getDatav() {
        return datav;
    }
    public void setDatav(int datav) {
        this.datav = datav;
    }
    public int getProdutov() {
        return produtov;
    }
    public void setProdutov(int produtov) {
        this.produtov = produtov;
    }
    public int getQtdvenda() {
        return qtdvenda;
    }
    public void setQtdvenda(int qtdvenda) {
        this.qtdvenda = qtdvenda;
    }

    
}
