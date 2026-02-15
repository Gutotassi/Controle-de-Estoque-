package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class Estoque {
    int indiceListagem = 1;
    private Produtos produtoEntrada;
    ArrayList<Produtos> produtos = new ArrayList<Produtos>();
    private Scanner input = new Scanner(System.in);

    public void cadastrarProdutos() {
        System.out.println("\n" +
                "--- Digite o produto que deseja adicionar --");
        String adicionarNomeProduto = input.nextLine();
        Produtos produto = new Produtos(adicionarNomeProduto);
        produtos.add(produto);
    }

    public void entradaDeEstoque() {
        indiceListagem = 1;
        System.out.println("\n" +
                "--- Qual produto você quer dar entrada? ---");
        for (Produtos percorrendoListaDeProdutos : produtos) {
            System.out.println(indiceListagem + "-" + percorrendoListaDeProdutos.getNomeProduto());
            indiceListagem++;
        }
        int escolherProduto = input.nextInt();
        if (escolherProduto - 1 <= produtos.size() && escolherProduto > 0) {
            produtoEntrada = produtos.get(escolherProduto - 1);
        }
        adicionarQuantidade();
        adicionarPreco();
    }

    public void adicionarQuantidade() {
        if (produtoEntrada != null) {
            System.out.println("\n" +
                    "--- Qual a quantidade? ---");
            int adicionarQuantidadeDoProduto = input.nextInt();
            produtoEntrada.setQuantidadeProdutoEmEstoque(
                    produtoEntrada.getQuantidadeProdutoEmEstoque() + adicionarQuantidadeDoProduto);
        }
    }

    public void adicionarPreco() {
        if (produtoEntrada != null) {
            System.out.println("\n" +
                    "--- Qual o valor da unidade? ---");
            double adicionarQuantidadeDoProduto = input.nextDouble();
            produtoEntrada.setPrecoDoProduto(
                    produtoEntrada.getPrecoDoProduto() + adicionarQuantidadeDoProduto);
        }
    }

    public void saidaDeEstoque() {
        indiceListagem = 1;
        System.out.println("\n" +
                "--- Qual produto você quer retirar? ---");
        for (Produtos percorrendoListaDeProdutos : produtos) {
            System.out.println(indiceListagem + "-" + percorrendoListaDeProdutos.getNomeProduto());
            indiceListagem++;
        }
        int retirandoProduto = input.nextInt();
        if (retirandoProduto - 1 <= produtos.size() && retirandoProduto > 0) {
            produtoEntrada = produtos.get(retirandoProduto - 1);
        }
        retirarProdutoCompleto();
    }

    public void retirarProdutoCompleto() {
        if (produtoEntrada != null) {
            System.out.println("\n" +
                    "--- Deseja retirar alguma quantidade em estoque ou tirar o produto do estoque? ---");
            String acaoParaRetirarProduto = input.next().toLowerCase();
            String verificacaoSeCompleto = "produto";
            String verificacaoSeQuantidade = "estoque";
            if (acaoParaRetirarProduto.contains(verificacaoSeCompleto.substring(0, 4))) {
                produtos.remove(produtoEntrada);
            } else if (acaoParaRetirarProduto.contains(verificacaoSeQuantidade.substring(0, 4))) {
                retirarQuantidadeDoEstoque();
            } else {
                System.out.println("\n" +
                        "Digite 'Produto' ou 'Estoque' para êxito: ");
                retirarProdutoCompleto();
            }
        }
    }

    public void retirarQuantidadeDoEstoque() {
        if (produtoEntrada != null && produtoEntrada.getQuantidadeProdutoEmEstoque() != 0) {
            System.out.println("\n" +
                    "--- Quantos produtos serão retirdados? ---");
            int retirandoQuantidadeProduto = input.nextInt();
            produtoEntrada.setQuantidadeProdutoEmEstoque(
                    produtoEntrada.getQuantidadeProdutoEmEstoque() - retirandoQuantidadeProduto);
        }
    }

    public void listarProdutos() {
        indiceListagem = 1;
        System.out.println("\n" +
                "--- Os produtos em estoque são ---");
        for (Produtos percorrendoListaDeProdutos : produtos) {
            System.out.println(indiceListagem + "- " + percorrendoListaDeProdutos.getNomeProduto() + " "
                    + " Valor Unítario -- R$ "
                    + percorrendoListaDeProdutos.getPrecoDoProduto() + " Valor Total -- R$ "
                    + percorrendoListaDeProdutos.getPrecoDoProduto()
                            * percorrendoListaDeProdutos.getQuantidadeProdutoEmEstoque()
                    + " " + " Quantidade em estoque "
                    + percorrendoListaDeProdutos.getQuantidadeProdutoEmEstoque());
            indiceListagem++;
        }
        System.out.println(indiceListagem + "- Voltar");
        int voltarParaMenuInterativo = input.nextInt();
        if (indiceListagem == voltarParaMenuInterativo) {
            System.out.println("\nVoltando... \n");
        }
    }

    public void alterarPreco() {
        indiceListagem = 1;
        System.out.println("\n" +
                "--- Os produtos em estoque são ---");
        for (Produtos percorrendoListaDEProdutos : produtos) {
            System.out.println(indiceListagem + "- " + percorrendoListaDEProdutos.getNomeProduto() + " "
                    + "Preço atual: " + percorrendoListaDEProdutos.getPrecoDoProduto());
            indiceListagem++;
        }
        System.out.println("\n" +
                "--- Qual produto deseja alterar? ---");
        int interacaoAlterar = input.nextInt();
        if (interacaoAlterar - 1 <= produtos.size() && interacaoAlterar > 0) {
            System.out.println("--- Altere o valor ---");
            double alterarPrecoProduto = input.nextDouble();
            produtoEntrada.setPrecoDoProduto(alterarPrecoProduto);
        } else {
            System.out.println("--- Produto inválido tente novamente ---");
            alterarPreco();
        }
    }
}