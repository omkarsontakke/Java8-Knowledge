package org.JavaEight.MockTest;

public class Order {
    private String id;
    private double amount;
    private String status;

    public Order(String id, double amount, String status) {
        this.id = id;
        this.amount = amount;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}
