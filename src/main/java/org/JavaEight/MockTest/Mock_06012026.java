package org.JavaEight.MockTest;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Mock_06012026 {
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
                new Customer("Vikram", "Pune", 21,32100,"Active",
                        List.of(
                                new Order("O4", 2500, "CANCELLED"),
                                new Order("O5", 3200, "DELIVERED")
                        )
                )
        );



//       Q.1 Sort a Map by value DESC and key ASC

        Map<String, Integer> countryCode = new HashMap<>();
        countryCode.put("India", 91);
        countryCode.put("Qatar", 54);
        countryCode.put("Turkey", 98);
        countryCode.put("Russia", 7);

        List<String> sorted = countryCode.entrySet().stream()
                .filter(e -> e.getKey() != null)
                .map(Map.Entry::getKey)
                .sorted().toList();

//        System.out.println(sorted);

//      Q.2 Check if all employees are active

        boolean isAllCustomerActive = customers.stream()
                .filter(e -> e.getIsActive() != null)
                .allMatch(e -> e.getIsActive().toLowerCase().equals("active"));

//        System.out.println(isAllCustomerActive);

//      Q.3 Flatten a List<List<String>> into a single List

        List<Order> list = customers.stream()
                .filter(e -> e.getOrders() != null)
                .flatMap(e -> e.getOrders().stream()).toList();

//        System.out.println(list);

//      Q.4 Find the most frequent element in a List

        List<String> country = List.of("India", "USA", "Russia", "Dubai","India", "Canada","Russia");

        Optional<String> first = country.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .map(Map.Entry::getKey)
                .sorted(Comparator.reverseOrder())
                .findFirst();

//        first.ifPresent(System.out::println);

//      Q.5 Find the first employee from each city

//        Optional<Map.Entry<Customer, Long>> first1 = customers.stream()
//                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
//                .entrySet()
//                .stream().findFirst();
//
//        first1.ifPresent(System.out::println);
        Map<String, Customer> firstCustomerPerCity =
                customers.stream()
                        .collect(Collectors.groupingBy(
                                Customer::getCity,
                                LinkedHashMap::new,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list1 -> list1.get(0)
                                )
                        ));

//        System.out.println(firstCustomerPerCity);
    }
}
