package org.JavaEight.MockTest;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return age == customer.age && salary == customer.salary && Objects.equals(name, customer.name) && Objects.equals(city, customer.city) && Objects.equals(isActive, customer.isActive) && Objects.equals(orders, customer.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city, age, salary, isActive, orders);
    }
}

