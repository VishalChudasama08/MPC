package spring07.constructor.beans;

public class Address {
    private int houseNo;
    private String city;
    private int pinCode;
    public Address(int houseNo, String city, int pinCode){
        this.houseNo = houseNo;
        this.city = city;
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "House Number: " + houseNo + ", City: " + city + ", Pin-Code: " + pinCode;
    }
}
