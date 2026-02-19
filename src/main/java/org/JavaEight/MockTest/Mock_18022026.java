package org.JavaEight.MockTest;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Mock_18022026 {

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
                new Customer("Rohan", "Delhi", 33,54000,null,List.of()),
                new Customer("Rakmo", "Pune", 21,82000,"Active",
                        List.of(
                                new Order("O4", 2500, "CANCELLED"),
                                new Order("O5", 3200, "DELIVERED")
                        )
                )
        );



       // Q. Convert List to Map (handle Duplicate)
        List<String> programmingLang = List.of("Java","C","Python","Ruby","Java");

        Map<String,Long> listToMap = programmingLang.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        // Q. Longest String in List

        String longestString = programmingLang.stream()
                .max(Comparator.comparing(String::length))
                .orElse("");

        System.out.println(longestString);

        // Q. group customers by city

        Map<String, List<Customer>> custByCity = customers.stream()
                .collect(Collectors.groupingBy(Customer::getCity));

        System.out.println(custByCity);

    }
}
