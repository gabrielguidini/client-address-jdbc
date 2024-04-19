package dao;

import model.Address;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressDAO extends DatabaseDAO{

        private final static String CREATE_TABLE = """
        create table  IF NOT EXISTS address(
                             "foreign key(fk_id) references client)";,
                             zip_code text,
                             house_number text);
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

        public void insert(Address address){
            String insert = """
                insert into address(zip_code, house_number,fk_id) values(?,?) where id = ?;
                """;
            try(var con = connection();
                var stat = con.prepareStatement(insert)){
                stat.setString(1,address.getZipCode());
                stat.setString(2,address.getHouseNumber());
                stat.setInt(3, address.getFk_id());
                stat.execute();
            }catch (SQLException e){
                System.out.println("Error inserting into table");
                e.printStackTrace();
            }
        }

        public void update(Address address){
            String sql = """
                update address set zip_code = ?, house_number = ? where fk_id = ?;
                """;
            try(var con = connection();
                var stat = con.prepareStatement(sql)){
                stat.setString(1,address.getZipCode());
                stat.setString(2,address.getHouseNumber());
                stat.setInt(3,address.getFk_id());
                stat.execute();
            }catch (SQLException e){
                System.out.println("Error updating client where id = " + address.getFk_id());
                e.printStackTrace();
            }
        }

        public void delete(Integer id){
            String sql = """
                delete address where fk_id = ?;
                """;
            try(var con = connection();
                var stat = con.prepareStatement(sql)){
                stat.setInt(1,id);
                stat.execute();
            }catch (SQLException e){
                System.out.println("Error deleting address where id= "+ id);
                e.printStackTrace();
            }
        }

        public Address getById(Integer id){
            Address address = null;
            String sql = """
                select id, name, address from address where id = ?;
                """;
            try(var con = connection();
                var stat = con.prepareStatement(sql)){
                stat.setInt(1,id);
                ResultSet rs = stat.executeQuery();
                if(rs.next()){
                    address = new Address();
                    address.setFk_id(rs.getInt("fk_id"));
                    address.setZipCode(rs.getString("zip_code"));
                    address.setHouseNumber(rs.getString("house_number"));
                }
            }catch (SQLException e){
                System.out.println("Error getById");
                e.printStackTrace();
            }
            return address;
        }
}
