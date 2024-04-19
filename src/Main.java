import dao.AddressDAO;
import dao.ClientDAO;
import model.Address;
import model.Client;

public class Main {
    public static void main(String[] args) {
        Client c1 = new Client(0,
                new Address("89221543","128",0)
                ,"Gibirilina");
        ClientDAO clientDAO = new ClientDAO();
        AddressDAO addressDAO = new AddressDAO();
        clientDAO.createTable();
        addressDAO.createTable();
    }
}