package lk.ijse.pos.model;

public class CustomerDTO {
    private  String cusId;
    private  String cusName;
    private  String cusAddress;
    private  double cusSalary;

    public CustomerDTO() {
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

    public double getCusSalary() {
        return cusSalary;
    }

    public void setCusSalary(double cusSalary) {
        this.cusSalary = cusSalary;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "cusId='" + cusId + '\'' +
                ", cusName='" + cusName + '\'' +
                ", cusAddress='" + cusAddress + '\'' +
                ", cusSalary=" + cusSalary +
                '}';
    }
}
