package org.example.MockTest;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Mock_12012026 {
    public static void main(String[] args) {
        List<Customer> customers = List.of(
                new Customer("Amit", "Mumbai",21,32100,"Active",
                        List.of(
                                new Order("O1", 1200, "DELIVERED"),
                                new Order("O2", 800, "NEW")
                        )
                ),
                new Customer("Neha", "Pune",17,11000,"Active",
                        List.of(
                                new Order("O3", 4000, "DELIVERED")
                        )
                ),
                new Customer("Rohan", "Mumbai",42,82000, "InActive",null),
                new Customer("Priya", "Delhi", 33,54000,null,List.of()),
                new Customer("Vikram", "Pune", 21,82000,"Active",
                        List.of(
                                new Order("O4", 2500, "CANCELLED"),
                                new Order("O5", 3200, "DELIVERED")
                        )
                )
        );

//        Question 1: Find customers whose all orders are DELIVERED

        List<Customer> delivered = customers.stream()
                .filter(custFilter -> custFilter.getOrders() != null && !custFilter.getOrders().isEmpty() )
                .filter(customer -> customer.getOrders().stream().allMatch(cust -> cust.getStatus().equalsIgnoreCase("DELIVERED")))
                .toList();


//        System.out.println(delivered);

//      Question 2: Find total revenue generated from DELIVERED orders only
        int sum = customers.stream()
                .filter(custFilter -> custFilter.getOrders() != null && !custFilter.getOrders().isEmpty())
                .flatMap(customer -> customer.getOrders().stream())
                .filter(delOrder -> delOrder.getStatus().equalsIgnoreCase("DELIVERED"))
                .mapToInt(orderAmount ->(int) orderAmount.getAmount()).sum();

//        System.out.println(sum);

//        Question 3: Find city which has the maximum number of customers

        Map.Entry<String, Long> maxOrderCity = customers.stream()
                .collect(Collectors.groupingBy(Customer::getCity, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get();

//        System.out.println(maxOrderCity);


//        Question 4: Convert List<Customer> to Map<City, Set<CustomerName>>

        Map<String, Set<String>> collect = customers.stream()
                .collect(Collectors.groupingBy(Customer::getCity, Collectors.mapping(Customer::getName, Collectors.toSet())));

        Map<String, Set<Integer>> collect1 = customers.stream()
                .collect(Collectors.groupingBy(Customer::getCity, Collectors.mapping(Customer::getSalary, Collectors.toSet())));



        System.out.println(collect);
        System.out.println(collect1);


    }
}
