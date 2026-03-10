package src.main;

import src.database.ConnectionFactory;
import src.domain.Estoque;
import src.domain.MenuInterativo;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getConnection();
        Estoque estoque = new Estoque();
        MenuInterativo menuInterativo = new MenuInterativo(estoque);
        menuInterativo.escolherAcao();
        ConnectionFactory.closeConnection();
    }
}
