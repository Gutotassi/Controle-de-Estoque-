import domain.Estoque;
import domain.MenuInterativo;

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        MenuInterativo menuInterativo = new MenuInterativo(estoque);
        menuInterativo.escolherAcao();
    }
}
