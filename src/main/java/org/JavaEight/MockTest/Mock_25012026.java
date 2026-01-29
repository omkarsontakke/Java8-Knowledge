package org.JavaEight.MockTest;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Mock_25012026 {
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
                new Customer("Rohan", "Mumbai",42,83000, "InActive",null),
                new Customer("Priya", "Delhi", 33,54000,null,List.of()),
                new Customer("Vikram", "Pune", 21,84000,"Active",
                        List.of(
                                new Order("O4", 2500, "CANCELLED"),
                                new Order("O5", 3200, "DELIVERED")
                        )
                )
        );

        Map<String, List<Customer>> groupByCity = customers.stream()
                .collect(Collectors.groupingBy(
                        Customer::getCity,
                        LinkedHashMap::new,
                        Collectors.toList()
                ));


//        System.out.println(groupByCity);

//        Find customers who have no orders

        List<Customer> noOrdersCustomer = customers.stream()
                .filter(nullCust -> nullCust.getOrders() != null)
                .filter(c -> c.getOrders().isEmpty())
                .toList();

        System.out.println(noOrdersCustomer);

//        Get a list of all DELIVERED order IDs

        List<Order> delivered = customers.stream()
                .filter(cus -> cus.getOrders() != null)
                .flatMap(flatCust -> flatCust.getOrders().stream())
                .filter(cust -> cust.getStatus().equalsIgnoreCase("DELIVERED"))
                .toList();

//        System.out.println(delivered);


//        Find The Second Highest salary

        List<Integer> secondHighestSal = customers.stream()
                .map(cust -> cust.getSalary())
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .limit(1)
                .toList();

        System.out.println(secondHighestSal);

    }
}
