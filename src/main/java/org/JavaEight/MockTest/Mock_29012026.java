package org.JavaEight.MockTest;

import java.util.List;
import java.util.stream.Collectors;

public class Mock_29012026 {
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




//      1. Find employees/customers whose name starts with a given prefix

        List<Customer> namesStartWithA = customers.stream()
                .filter(cust -> cust.getName().startsWith("A"))
                .toList();

//        System.out.println(namesStartWithA);

//      2. Find maximum and minimum salary from a customers

        int maxSalary = customers.stream()
                .mapToInt(Customer::getSalary)
                .max()
                .orElse(-1);

        int minSalary = customers.stream()
                .mapToInt(Customer::getSalary)
                .min()
                .orElse(-1);

//        System.out.println(maxSalary);
//        System.out.println(minSalary);

//      3. Convert a list into a comma-separated string
        List<String> lang = List.of("Java","Springboot","Ruby");

        String commaSeparatedName = customers.stream()
                .map(Customer::getName)
                .collect(Collectors.joining(", "));

//        System.out.println(commaSeparatedName);

//      4. Find customers with no orders

        List<Customer> custWithoutOrders = customers.stream()
                .filter(cust -> cust.getOrders() == null || cust.getOrders().isEmpty())
                .toList();

//        System.out.println(custWithoutOrders);

//       5. Check if all order amount is greater than 500?

        List<Order> orderGreaterThanAmount = customers.stream()
                .filter(cust -> cust.getOrders() != null)
                .flatMap(cust -> cust.getOrders().stream())
                .filter(order -> order.getAmount() > 2000)
                .toList();

        List<Customer> orderGreaterThanAmount1 = customers.stream()
                .filter(cust -> cust.getOrders() != null)
                .filter(custOrder -> custOrder.getOrders().stream().anyMatch(
                        order -> order.getAmount() > 2000
                ))
                .toList();

        System.out.println(orderGreaterThanAmount1);


    }
}
