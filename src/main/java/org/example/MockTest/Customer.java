package org.example.MockTest;

import java.util.List;

public class Customer {
    private String name;
    private String city;
    private List<Order> orders;

    public Customer(String name,String city, List<Order> orders) {
        this.name = name;
        this.city = city;
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public String getCity() {return city;}

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", orders=" + orders +
                '}';
    }
}

