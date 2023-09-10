package lk.ijse.pos.entity;

public class Order {
    private String orderId;
    private String itemId;
    private String date;

    public Order() {
    }

    public Order(String orderId, String itemId, String date) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.date = date;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", itemId='" + itemId + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
