package lk.ijse.pos.entity;

public class Customer {
    private  String cusId;
    private  String cusName;
    private  String cusAddress;
    private  String cusSalary;

    public Customer() {
    }

    public Customer(String cusId, String cusName, String cusAddress, String cusSalary) {
        this.cusId = cusId;
        this.cusName = cusName;
        this.cusAddress = cusAddress;
        this.cusSalary = cusSalary;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public String getCusSalary() {
        return cusSalary;
    }

    public void setCusSalary(String cusSalary) {
        this.cusSalary = cusSalary;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cusId='" + cusId + '\'' +
                ", cusName='" + cusName + '\'' +
                ", cusAddress='" + cusAddress + '\'' +
                ", cusSalary='" + cusSalary + '\'' +
                '}';
    }
}
