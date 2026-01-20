package org.example.JavaExamples;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Employee {

    public int generateUUID(){
        return UUID.randomUUID().hashCode();
    }
    String name;
    Address address;
    Double salary;
    List<String> email;
    String department;

    public Employee(String name, Address address, Double salary, List<String> email,String department) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.email = email;
        this.department=department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    public String getDeptartment() {
        return department;
    }

    public void setDeptartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", salary=" + salary +
                ", email=" + email +
                '}';
    }
}
//
//class Address {
//    String city;
//    String state;
//    String country;
//
//    public Address(String city, String state, String country) {
//        this.city = city;
//        this.state = state;
//        this.country = country;
//    }
//
//    @Override
//    public String toString() {
//        return "Address{" +
//                "city='" + city + '\'' +
//                ", state='" + state + '\'' +
//                ", country='" + country + '\'' +
//                '}';
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public String getState() {
//        return state;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//
//}
