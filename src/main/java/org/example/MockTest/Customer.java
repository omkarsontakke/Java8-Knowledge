package org.example.MockTest;

import java.util.List;

public class Customer {
    private String name;
    private String city;
    private int age;
    private int salary;
    private String isActive;
    private List<Order> orders;

    public Customer(String name,String city,int age,int salary,String isActive, List<Order> orders) {
        this.name = name;
        this.city = city;
        this.age=age;
        this.salary=salary;
        this.isActive=isActive;
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public String getIsActive() {
        return isActive;
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
                ", age=" + age +
                ", salary=" + salary +
                ", status='" + isActive + '\'' +
                ", orders=" + orders +
                '}';
    }

}

