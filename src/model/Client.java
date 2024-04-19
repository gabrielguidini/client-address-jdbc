package model;

public class Client {
    private Integer id;
    private Address clientAddress;
    private String name;

    public Client(Integer id, Address clientAddress, String name) {
        this.id = id;
        this.clientAddress = clientAddress;
        this.name = name;
    }

    @Override
    public String toString() {
        return "model.Client{" +
                "id='" + id + '\'' +
                ", clientAddress=" + clientAddress +
                ", name='" + name + '\'' +
                '}';
    }

    public Client() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Address getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(Address clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
