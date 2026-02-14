package domain;

import java.util.Scanner;

public class MenuInterativo {
    private int numeroDoMenuInterativo = 1;
    private Estoque estoque;
    private Scanner input = new Scanner(System.in);

    public MenuInterativo(Estoque estoque) {
        this.estoque = estoque;
    }

    public void imprimeMenu() {
        System.out.println("\n");
        System.out.println("=== Escolha uma Ação ====");
        System.out.println("| 1- Cadastrar Produto  |");
        System.out.println("| 2- Entrada no Estoque |");
        System.out.println("| 3- Saída do Estoque   |");
        System.out.println("| 4- Listar Produtos    |");
        System.out.println("| 5- Alterar Preço      |");
        System.out.println("| 6- Sair do Programa   |");
        System.out.println("=========================");
    }

    public void escolherAcao() {
        while (numeroDoMenuInterativo < 6 && numeroDoMenuInterativo > 0) {
            imprimeMenu();
            numeroDoMenuInterativo = input.nextInt();
            selecionarAcao(numeroDoMenuInterativo);
        }
        input.close();
    }

    public void selecionarAcao(int numeroInterativoParaAcao) {
        switch (numeroInterativoParaAcao) {
            case 1:
                estoque.cadastrarProdutos();
                break;

            case 2:
                estoque.entradaDeEstoque();
                break;

            case 3:
                estoque.saidaDeEstoque();
                break;

            case 4:
                estoque.listarProdutos();
                break;

            case 5:
                estoque.alterarPreco();
                return;

            default:
                break;
        }
    }

}
