package src.main;

import src.domain.Estoque;
import src.domain.MenuInterativo;

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        MenuInterativo menuInterativo = new MenuInterativo(estoque);
        menuInterativo.escolherAcao();
    }
}
