package org.example.MockTest;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Mock_30122025 {
    public static void main(String[] args) {
        System.out.println("Started day 30 of java 8");

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

//        Q.1. Find duplicate elements in a list
        List<String> list = Arrays.asList("apple", "banana", "apple", "orange", "banana");
        Set<String> listEle = new HashSet<>();
        List<String> collect = list.stream().filter(s -> !listEle.add(s)).toList();
//        System.out.println("Duplicate Elements in the given list : " +collect);

//        Q.2. Count occurrences of each element in a list

        Map<String, Long> occurrenceOfEachElemInList = list.stream().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()));

//        System.out.println("Occurrence of each elements in the list : "+occurrenceOfEachElemInList);


//       Q.3 Find the first non-repeated character in a string

        String cityName = "india";

        Optional<String> first = Arrays.stream(cityName.split(""))
                .collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();

//        System.out.println(first.get());


//        Q.4 Convert a list of strings to a map

        List<String> listFruit = Arrays.asList("apple", "banana", "orange");

        Map<String, Integer> fruitOfLength = listFruit.stream().collect(Collectors.toMap(Function.identity(),String::length));
//        System.out.println("Count each fruit name length : "+fruitOfLength);


//        Q.5. Find all Customers where order is greater than 1

        List<Customer> listOfCustGreaterThanOneOrder = customers.stream()
                .filter(c -> c.getOrders()!=null)
                .filter(e -> e.getOrders().size() > 1).toList();
        System.out.println(listOfCustGreaterThanOneOrder);


    }

}


