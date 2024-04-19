package dao;

import factory.FactoryDatabase;

import java.sql.Connection;

public class DatabaseDAO {

    protected Connection connection(){
        return FactoryDatabase.getInstance().connection();
    }

}
