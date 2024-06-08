package spring07.setter.beans;

public class Address {
    private int houseNo;
    private String city;
    private int pinCode;
    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "House Number: " + houseNo + ", City: " + city + ", Pin-Code: " + pinCode;
    }
}
