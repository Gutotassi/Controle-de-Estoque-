package domain;

public class Produtos {
    private String nomeProduto;
    private int quantidadeProdutoEmEstoque;
    private double precoDoProduto;

    public Produtos(String nomeProduto) {
        this.nomeProduto = nomeProduto;
        this.quantidadeProdutoEmEstoque = 0;
        this.precoDoProduto = 0.0;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQuantidadeProdutoEmEstoque() {
        return quantidadeProdutoEmEstoque;
    }

    public void setQuantidadeProdutoEmEstoque(int quantidadeProdutoEmEstoque) {
        this.quantidadeProdutoEmEstoque = quantidadeProdutoEmEstoque;
    }

    public double getPrecoDoProduto() {
        return precoDoProduto;
    }

    public void setPrecoDoProduto(double precoDoProduto) {
        this.precoDoProduto = precoDoProduto;
    }

}
