package dao;

import model.Address;
import model.Client;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO extends DatabaseDAO{

    private final static String CREATE_TABLE = """
        create table  IF NOT EXISTS client(
                             id SERIAL PRIMARY KEY,
                             address Address,
                             nome text);
        """;

    public void createTable(){
        try(var con = connection();
            var stat = con.createStatement()){
            stat.execute(CREATE_TABLE);
        }catch (SQLException e){
            System.out.println("Error creating table");
            e.printStackTrace();
        }
    }

    public void insert(Client client, Address address){
        String insert = """
                insert into client(nome,address) values(?,?) where id = ?;
                """;
        try(var con = connection();
            var stat = con.prepareStatement(insert)){
            stat.setString(1,client.getName());
            stat.setObject(2,client.getClientAddress());
            stat.setInt(3, client.getId());
            stat.execute();
        }catch (SQLException e){
            System.out.println("Error inserting into table");
            e.printStackTrace();
        }
    }

    public void update(Client c){
        String sql = """
                update client set nome = ?, address = ? where id = ?;
                """;
        try(var con = connection();
            var stat = con.prepareStatement(sql)){
            stat.setString(1,c.getName());
            stat.setObject(2,c.getClientAddress());
            stat.setInt(3,c.getId());
            stat.execute();
        }catch (SQLException e){
            System.out.println("Error updating client where id = " + c.getId());
            e.printStackTrace();
        }
    }

    public void delete(long id){
        String sql = """
                delete client where id = ?;
                """;
        try(var con = connection();
            var stat = con.prepareStatement(sql)){
            stat.setLong(1,id);
            stat.execute();
        }catch (SQLException e){
            System.out.println("Error deleting client where id= "+ id);
            e.printStackTrace();
        }
    }

    public Client getById(long id){
        Client c = null;
        String sql = """
                select id, name, address from client where id = ?;
                """;
        try(var con = connection();
            var stat = con.prepareStatement(sql)){
            stat.setLong(1,id);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                c = new Client();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
            }
        }catch (SQLException e){
            System.out.println("Error getById()");
            e.printStackTrace();
        }
        return c;
    }

}

