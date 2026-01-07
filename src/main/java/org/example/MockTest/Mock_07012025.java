package org.example.MockTest;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mock_07012025 {
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



//        Question 1: Find the second-highest salary (distinct)

        Optional<Integer> secondHighestSalary  = customers.stream()
                .map(Customer::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();

        List<Customer> secondHighestSalaryCustomer = customers.stream()
                .filter(customer -> customer.getSalary() == secondHighestSalary.orElse(-1))
                .toList();

//        secondHighestSalary .ifPresent(System.out::println);

//        System.out.println(secondHighestSalaryCustomer);
//
//        Question 2: Find customers who have at least one DELIVERED order above 3000


        List<Order> delivered = customers.stream()
                .filter(u -> u.getOrders() != null)
                .flatMap(c -> c.getOrders().stream())
                .filter(f -> f.getStatus().equals("DELIVERED") && f.getAmount() > 3000)
                .toList();

//        System.out.println(delivered);


//        Question 3: Convert List<Customer> into Map<City, AverageSalary>

        Map<String, Double> collect = customers.stream()
                .collect(
                        Collectors.groupingBy(
                                Customer::getCity,
                                Collectors.averagingDouble(Customer::getSalary)
                        ));

//        System.out.println(collect);

//        Question 4: Find duplicate elements and their count (only duplicates)

        List<String> integers = List.of("java","python","java","C","ruby","ruby");

        Map<String, Long> custToMap = integers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));

//        System.out.println(custToMap);


//        Question 5: Check if any customer is under 18 AND has an ACTIVE status

        boolean active = customers.stream()
                .anyMatch(customer -> customer.getAge() < 18
                        && customer.getIsActive().equalsIgnoreCase("ACTIVE"));

        System.out.println(active);


    }
}
