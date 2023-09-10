package lk.ijse.pos.model;

public class OrderDTO {
    private String orderId;
    private String customerId;
    private String date;

    public OrderDTO() {
    }

    public OrderDTO(String orderId, String customerId, String date) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.date = date;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
