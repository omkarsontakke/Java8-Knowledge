package org.example.MockTest;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Mock_05012026 {
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
                new Customer("Priya", "Delhi", 33,54000,"InActive",List.of()),
                new Customer("Vikram", "Pune", 21,32100,"Active",
                        List.of(
                                new Order("O4", 2500, "CANCELLED"),
                                new Order("O5", 3200, "DELIVERED")
                        )
                )
        );



//      Q.1. Find the second-highest salary customers

        Optional<Customer> first = customers.stream()
                .distinct()
                .sorted(Comparator.comparing(Customer::getSalary).reversed())
                .skip(1)
                .findFirst();

//        first.ifPresent(System.out::println);

//      Q2. Find employees whose name starts with a vowel and salary > average salary

        List<Character> vowels = List.of('a','e','i','o','u');

        List<Customer> customerStream = customers.stream()
                .filter(e -> vowels.contains(e.getName().toLowerCase().charAt(0)))
                .toList();

//        System.out.println(customerStream);

//      Q.3. Convert List<Employee> to Map<Department, TotalSalary>

        Map<String, Double> collect = customers.stream()
                .collect(Collectors.groupingBy(Customer::getCity, Collectors.summingDouble(Customer::getSalary)));
//        System.out.println(collect);

//      Q4. Find duplicate elements in a List and their count

        List<Integer> integers = List.of(2, 5, 3, 6, 7, 1, 1,1, 9, 4, 2);
        Set<Integer> set = new HashSet<>();
        Map<Integer, Long> collect1 = integers.stream()
                .filter(n -> !set.add(n))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

//        System.out.println(collect1);


//      Q5. Find customers who have placed more than 1 order

//        List<Customer> list = customers.stream()
//                .filter(c -> c.getOrders() != null)
//                .filter(c -> c.getOrders().stream()
//                        .anyMatch(order -> "DELIVERED".equals(order.getStatus()))
//                ).toList();

//        System.out.println(list);

        List<Customer> oderGreaterThanOne = customers.stream()
                .filter(c -> c.getOrders() != null)
                .filter(c -> c.getOrders().size() > 1)
                .toList();

        System.out.println(oderGreaterThanOne);


    }

}


