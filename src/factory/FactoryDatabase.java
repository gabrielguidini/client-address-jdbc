package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryDatabase {

    private static FactoryDatabase instance;

    private FactoryDatabase(){
    }

    public synchronized static FactoryDatabase getInstance(){
        if(instance == null){
            instance = new FactoryDatabase();
        }
        return instance;
    }

    public Connection connection(){
        Connection c = null;
        try{
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "postgres");
        }catch (SQLException e){
            new RuntimeException("Erro ao conectar no banco de dados.",e);
        }
        return c;
    }

}
