package model;

public class Address {
    private Integer fk_id;
    private String zipCode;
    private String houseNumber;

    public Address(String zipCode, String houseNumber, Integer fk_id) {
        this.zipCode = zipCode;
        this.houseNumber = houseNumber;
        this.fk_id = fk_id;
    }

    public Address() {
    }

    public Integer getFk_id() {
        return fk_id;
    }

    public void setFk_id(Integer fk_id) {
        this.fk_id = fk_id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "model.Address{" +
                "fk_id=" + fk_id +
                ", zipCode='" + zipCode + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                '}';
    }
}
