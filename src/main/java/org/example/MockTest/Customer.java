package org.example.MockTest;

import java.util.List;

public class Customer {
    private String name;
    private String city;
    private int age;
    private int salary;
    private List<Order> orders;

    public Customer(String name,String city,int age,int salary, List<Order> orders) {
        this.name = name;
        this.city = city;
        this.age=age;
        this.salary=salary;
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
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

